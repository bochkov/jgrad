package com.sb.jgrad.thermocouple;

import java.util.stream.Stream;

import com.sb.jgrad.OutOfBoundException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class XKnETest extends ThermocoupleTest {

    private final XKnE t = new XKnE();

    @Test
    void testNameAndDescription() {
        Assertions.assertThat(t.name()).isNotNull().isNotEmpty();
        Assertions.assertThat(t.description()).isNotNull().isNotEmpty();
    }

    private static Stream<TestData> unbound() {
        return Stream.of(
                new TestData(-271, -9.836),
                new TestData(1001, 76.374)
        );
    }

    private static Stream<TestData> arguments() {
        // полиномы определены от -200 градусов
        return Stream.of(
                new TestData(-200, -8.825),
                new TestData(0, 0.0),
                new TestData(300, 21.036),
                new TestData(600, 45.093),
                new TestData(1000, 76.373)
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
