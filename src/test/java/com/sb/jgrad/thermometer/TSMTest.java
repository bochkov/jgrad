package com.sb.jgrad.thermometer;

import java.util.stream.Stream;

import com.sb.jgrad.OutOfBoundException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class TSMTest extends ThermometerTest {

    private final TSM t = new TSM(100);

    @Test
    void testNameAndDescription() {
        Assertions.assertThat(t.name()).isEqualTo("100М");
        Assertions.assertThat(t.description()).isNotNull().isEmpty();
    }

    @Test
    void testLimits() {
        Assertions.assertThat(t.lower() - t.higher()).isLessThan(0.0);
    }

    private static Stream<TestData> unbound() {
        return Stream.of(
                new TestData(-51, 77.0),
                new TestData(201, 188.0)
        );
    }

    private static Stream<TestData> arguments() {
        return Stream.of(
                new TestData(-50, 78.46),
                new TestData(0, 100.0),
                new TestData(50, 121.40),
                new TestData(100, 142.80),
                new TestData(150, 164.20),
                new TestData(200, 185.60)
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
