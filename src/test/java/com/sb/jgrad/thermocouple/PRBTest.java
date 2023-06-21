package com.sb.jgrad.thermocouple;

import java.util.stream.Stream;

import com.sb.jgrad.OutOfBoundException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class PRBTest extends ThermocoupleTest {

    private final PRB t = new PRB();

    @Test
    void testNameAndDescription() {
        Assertions.assertThat(t.name()).isNotNull().isNotEmpty();
        Assertions.assertThat(t.description()).isNotNull().isNotEmpty();
    }

    private static Stream<TestData> unbound() {
        return Stream.of(
                new TestData(-1, -0.004),
                new TestData(1821, 13.821)
        );
    }

    private static Stream<ThermocoupleTest.TestData> arguments() {
        // полиномы определены от 250 градусов
        return Stream.of(
                new TestData(300, 0.431),
                new TestData(600, 1.792),
                new TestData(900, 3.957),
                new TestData(1200, 6.786),
                new TestData(1500, 10.099),
                new TestData(1820, 13.820)
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
