package com.sb.jgrad.thermocouple;

import java.util.stream.Stream;

import com.sb.jgrad.OutOfBoundException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class MKMTest extends ThermocoupleTest {

    private final MKM t = new MKM();

    @Test
    void testNameAndDescription() {
        Assertions.assertThat(t.name()).isNotNull().isNotEmpty();
        Assertions.assertThat(t.description()).isNotNull().isNotEmpty();
    }

    private static Stream<TestData> unbound() {
        return Stream.of(
                new TestData(-201, -6.155),
                new TestData(101, 4.723)
        );
    }

    private static Stream<TestData> arguments() {
        return Stream.of(
                new TestData(-200, -6.154),
                new TestData(-150, -5.111),
                new TestData(-100, -3.715),
                new TestData(0.02, 0.0),
                new TestData(1, 0.043),
                new TestData(50, 2.252),
                new TestData(100, 4.722)
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
