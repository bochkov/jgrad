package com.sb.jgrad.thermocouple;

import java.util.stream.Stream;

import com.sb.jgrad.OutOfBoundException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class XAKTest extends ThermocoupleTest {

    private final XAK t = new XAK();

    @Test
    void testNameAndDescription() {
        Assertions.assertThat(t.name()).isNotNull().isNotEmpty();
        Assertions.assertThat(t.description()).isNotNull().isNotEmpty();
    }

    private static Stream<TestData> unbound() {
        return Stream.of(
                new TestData(-271, -6.459),
                new TestData(1373, 54.887)
        );
    }

    private static Stream<TestData> arguments() {
        // полиномы определены от -200 градусов
        return Stream.of(
                new TestData(-200, -5.891),
                new TestData(-100, -3.554),
                new TestData(0, 0.0),
                new TestData(300, 12.209),
                new TestData(600, 24.905),
                new TestData(900, 37.326),
                new TestData(1200, 48.838),
                new TestData(1372, 54.886)
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
