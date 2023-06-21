package com.sb.jgrad.thermocouple;

import java.util.stream.Stream;

import com.sb.jgrad.OutOfBoundException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class JKJTest extends ThermocoupleTest {

    private final JKJ t = new JKJ();

    @Test
    void testNameAndDescription() {
        Assertions.assertThat(t.name()).isNotNull().isNotEmpty();
        Assertions.assertThat(t.description()).isNotNull().isNotEmpty();
    }

    private static Stream<TestData> unbound() {
        return Stream.of(
                new TestData(-211, -8.096),
                new TestData(1201, 69.554)
        );
    }

    private static Stream<TestData> arguments() {
        return Stream.of(
                new TestData(-210, -8.095),
                new TestData(0, 0.0),
                new TestData(300, 16.327),
                new TestData(600, 33.102),
                new TestData(900, 51.877),
                new TestData(1200, 69.553)
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
