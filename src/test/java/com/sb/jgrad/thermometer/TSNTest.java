package com.sb.jgrad.thermometer;

import java.util.stream.Stream;

import com.sb.jgrad.OutOfBoundException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class TSNTest extends ThermometerTest {

    private final TSN t = new TSN(100);

    @Test
    void testNameAndDescription() {
        Assertions.assertThat(t.name()).isEqualTo("100Н");
        Assertions.assertThat(t.description()).isNotNull().isEmpty();
    }

    @Test
    void testLimits() {
        Assertions.assertThat(t.lower() - t.higher()).isLessThan(0.0);
    }

    private static Stream<TestData> unbound() {
        return Stream.of(
                new TestData(-61, 68.0),
                new TestData(181, 224.0)
        );
    }

    private static Stream<TestData> arguments() {
        return Stream.of(
                new TestData(-60, 69.45),
                new TestData(0, 100.0),
                new TestData(60, 135.41),
                new TestData(120, 175.95),
                new TestData(180, 223.21)
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    void testValueAndTemp(TestData data) throws OutOfBoundException {
        testData(t, data);
    }

    @ParameterizedTest
    @MethodSource("unbound")
    void testLimits(TestData data) {
        testUnbound(t, data);
    }
}
