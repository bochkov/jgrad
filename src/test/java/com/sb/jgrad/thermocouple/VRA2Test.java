package com.sb.jgrad.thermocouple;

import java.util.stream.Stream;

import com.sb.jgrad.OutOfBoundException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class VRA2Test extends ThermocoupleTest {

    private final VRA2 t = new VRA2();

    @Test
    void testNameAndDescription() {
        Assertions.assertThat(t.name()).isNotNull().isNotEmpty();
        Assertions.assertThat(t.description()).isNotNull().isNotEmpty();
    }

    private static Stream<TestData> unbound() {
        return Stream.of(
                new TestData(-1, -0.001),
                new TestData(1801, 27.233)
        );
    }

    private static Stream<ThermocoupleTest.TestData> arguments() {
        return Stream.of(
                new TestData(0, 0.0),
                new TestData(2, 0.023),
                new TestData(100, 1.338),
                new TestData(300, 4.571),
                new TestData(600, 9.707),
                new TestData(900, 14.696),
                new TestData(1200, 19.330),
                new TestData(1500, 23.515),
                new TestData(1800, 27.232)
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    void testValueAndTemp(ThermocoupleTest.TestData data) throws OutOfBoundException {
        testData(t, data);
    }

    @ParameterizedTest
    @MethodSource("unbound")
    void testLimits(ThermocoupleTest.TestData data) {
        testUnbound(t, data);
    }
}
