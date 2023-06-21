package com.sb.jgrad.thermocouple;

import java.util.stream.Stream;

import com.sb.jgrad.OutOfBoundException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class VRA1Test extends ThermocoupleTest {

    private final VRA1 t = new VRA1();

    @Test
    void testNameAndDescription() {
        Assertions.assertThat(t.name()).isNotNull().isNotEmpty();
        Assertions.assertThat(t.description()).isNotNull().isNotEmpty();
    }

    private static Stream<TestData> unbound() {
        return Stream.of(
                new TestData(-1, -0.001),
                new TestData(2501, 33.641)
        );
    }

    private static Stream<ThermocoupleTest.TestData> arguments() {
        return Stream.of(
                new TestData(0, 0.0),
                new TestData(1, 0.013),
                new TestData(100, 1.337),
                new TestData(500, 7.908),
                new TestData(1000, 16.128),
                new TestData(1500, 23.311),
                new TestData(2000, 29.186),
                new TestData(2500, 33.640)
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
