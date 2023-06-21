package com.sb.jgrad.thermocouple;

import java.util.stream.Stream;

import com.sb.jgrad.OutOfBoundException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class PPRTest extends ThermocoupleTest {

    private final PPR t = new PPR();

    @Test
    void testNameAndDescription() {
        Assertions.assertThat(t.name()).isNotNull().isNotEmpty();
        Assertions.assertThat(t.description()).isNotNull().isNotEmpty();
    }

    private static Stream<TestData> unbound() {
        return Stream.of(
                new TestData(-51, -0.227),
                new TestData(1769, 21.102)
        );
    }

    private static Stream<ThermocoupleTest.TestData> arguments() {
        return Stream.of(
                new TestData(-50, -0.226),
                new TestData(-30, -0.145),
                new TestData(-10, -0.051),
                new TestData(0, 0.0),
                new TestData(1, 0.005),
                new TestData(300, 2.401),
                new TestData(600, 5.583),
                new TestData(900, 9.205),
                new TestData(1200, 13.228),
                new TestData(1500, 17.451),
                new TestData(1700, 20.222),
                new TestData(1768, 21.101)
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
