package com.sb.jgrad.thermocouple;

import java.util.stream.Stream;

import com.sb.jgrad.OutOfBoundException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class MKTTest extends ThermocoupleTest {

    private final MKT t = new MKT();

    @Test
    void testNameAndDescription() {
        Assertions.assertThat(t.name()).isNotNull().isNotEmpty();
        Assertions.assertThat(t.description()).isNotNull().isNotEmpty();
    }

    private static Stream<ThermocoupleTest.TestData> unbound() {
        return Stream.of(
                new TestData(-271, -6.259),
                new TestData(401, 20.873)
        );
    }

    private static Stream<ThermocoupleTest.TestData> arguments() {
        // полиномы определены от 200 градусов
        return Stream.of(
                new TestData(-200, -5.603),
                new TestData(-50, -1.819),
                new TestData(0, 0.0),
                new TestData(50, 2.036),
                new TestData(200, 9.288),
                new TestData(400, 20.872)
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
