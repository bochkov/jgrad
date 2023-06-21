package com.sb.jgrad.thermocouple;

import java.util.stream.Stream;

import com.sb.jgrad.OutOfBoundException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class PPSTest extends ThermocoupleTest {

    private final PPS t = new PPS();

    @Test
    void testNameAndDescription() {
        Assertions.assertThat(t.name()).isNotNull().isNotEmpty();
        Assertions.assertThat(t.description()).isNotNull().isNotEmpty();
    }

    private static Stream<TestData> unbound() {
        return Stream.of(
                new TestData(-51, -0.237),
                new TestData(1769, 18.694)
        );
    }

    private static Stream<ThermocoupleTest.TestData> arguments() {
        return Stream.of(
                new TestData(-50, -0.236),
                new TestData(-40, -0.194),
                new TestData(-10, -0.053),
                new TestData(0, 0.0),
                new TestData(1, 0.005),
                new TestData(300, 2.323),
                new TestData(600, 5.239),
                new TestData(900, 8.449),
                new TestData(1200, 11.951),
                new TestData(1500, 15.582),
                new TestData(1700, 17.947),
                new TestData(1768, 18.693)
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
