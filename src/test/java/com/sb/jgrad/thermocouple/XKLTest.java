package com.sb.jgrad.thermocouple;

import java.util.stream.Stream;

import com.sb.jgrad.OutOfBoundException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class XKLTest extends ThermocoupleTest {

    private final XKL t = new XKL();

    @Test
    void testNameAndDescription() {
        Assertions.assertThat(t.name()).isNotNull().isNotEmpty();
        Assertions.assertThat(t.description()).isNotNull().isNotEmpty();
    }

    private static Stream<TestData> unbound() {
        return Stream.of(
                new TestData(-201, -9.489),
                new TestData(801, 66.467)
        );
    }

    private static Stream<TestData> arguments() {
        return Stream.of(
                new TestData(-200, -9.488),
                new TestData(-190, -9.203),
                new TestData(0, 0.0),
                new TestData(200, 14.560),
                new TestData(400, 31.492),
                new TestData(600, 49.108),
                new TestData(800, 66.466)
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
