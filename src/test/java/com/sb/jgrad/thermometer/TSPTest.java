package com.sb.jgrad.thermometer;

import java.util.stream.Stream;

import com.sb.jgrad.OutOfBoundException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class TSPTest extends ThermometerTest {

    private final TSP t = new TSP(100);

    @Test
    void testNameAndDescription() {
        Assertions.assertThat(t.name()).isEqualTo("100П");
        Assertions.assertThat(t.description()).isNotNull().isEmpty();
    }

    @Test
    void testLimits() {
        Assertions.assertThat(t.lower() - t.higher()).isLessThan(0.0);
    }

    private static Stream<TestData> unbound() {
        return Stream.of(
                new TestData(-201, 15.0),
                new TestData(851, 400.0)
        );
    }

    private static Stream<TestData> arguments() {
        return Stream.of(
                new TestData(-200, 17.24),
                new TestData(-100, 59.64),
                new TestData(0, 100.0),
                new TestData(200, 177.04),
                new TestData(400, 249.41),
                new TestData(600, 317.11),
                new TestData(850, 395.16)
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
