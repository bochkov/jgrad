package com.sb.jgrad.thermocouple;

import java.util.stream.Stream;

import com.sb.jgrad.OutOfBoundException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class NNNTest extends ThermocoupleTest {

    private final NNN t = new NNN();

    @Test
    void testNameAndDescription() {
        Assertions.assertThat(t.name()).isNotNull().isNotEmpty();
        Assertions.assertThat(t.description()).isNotNull().isNotEmpty();
    }

    private static Stream<TestData> unbound() {
        return Stream.of(
                new TestData(-271, -4.346),
                new TestData(1301, 47.514)
        );
    }

    private static Stream<ThermocoupleTest.TestData> arguments() {
        // полиномы определены от -200 градусов
        return Stream.of(
                new TestData(-200, -3.990),
                new TestData(0, 0.0),
                new TestData(300, 9.341),
                new TestData(600, 20.613),
                new TestData(900, 32.371),
                new TestData(1200, 43.846),
                new TestData(1300, 47.513)
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
