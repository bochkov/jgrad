package com.sb.jgrad.thermometer;

import java.util.stream.Stream;

import com.sb.jgrad.OutOfBoundException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class TSPtTest extends ThermometerTest {

    private final TSPt t = new TSPt(100);

    @Test
    void testNameAndDescription() {
        Assertions.assertThat(t.name()).isEqualTo("Pt100");
        Assertions.assertThat(t.description()).isNotNull().isEmpty();
    }

    @Test
    void testLimits() {
        Assertions.assertThat(t.lower() - t.higher()).isLessThan(0.0);
    }

    private static Stream<TestData> unbound() {
        return Stream.of(
                new TestData(-201, 17.0),
                new TestData(851, 400.0)
        );
    }

    private static Stream<TestData> arguments() {
        return Stream.of(
                new TestData(-200, 18.52),
                new TestData(-100, 60.26),
                new TestData(0, 100.0),
                new TestData(200, 175.86),
                new TestData(400, 247.09),
                new TestData(600, 313.71),
                new TestData(850, 390.48)
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
