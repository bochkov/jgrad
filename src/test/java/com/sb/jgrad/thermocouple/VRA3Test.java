package com.sb.jgrad.thermocouple;

import java.util.stream.Stream;

import com.sb.jgrad.OutOfBoundException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class VRA3Test extends ThermocoupleTest {

    private final VRA3 t = new VRA3();

    @Test
    void testNameAndDescription() {
        Assertions.assertThat(t.name()).isNotNull().isNotEmpty();
        Assertions.assertThat(t.description()).isNotNull().isNotEmpty();
    }

    private static Stream<TestData> unbound() {
        return Stream.of(
                new TestData(-1, -0.001),
                new TestData(1801, 26.774)
        );
    }

    private static Stream<TestData> arguments() {
        return Stream.of(
                new TestData(0, 0.0),
                new TestData(2, 0.023),
                new TestData(100, 1.319),
                new TestData(300, 4.470),
                new TestData(600, 9.506),
                new TestData(900, 14.411),
                new TestData(1200, 18.981),
                new TestData(1500, 23.106),
                new TestData(1800, 26.773)
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
