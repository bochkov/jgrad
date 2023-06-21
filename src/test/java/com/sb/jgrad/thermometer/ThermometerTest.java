package com.sb.jgrad.thermometer;

import com.sb.jgrad.OutOfBoundException;
import org.assertj.core.api.Assertions;
import org.assertj.core.data.Offset;

abstract class ThermometerTest {

    private final Offset<Double> eps = Assertions.offset(0.05);

    record TestData(double temp, double value) {
    }

    protected void testData(Thermometer t, TestData data) throws OutOfBoundException {
        Assertions.assertThat(t.value(data.temp)).isCloseTo(data.value, eps);
        Assertions.assertThat(t.temp(data.value)).isCloseTo(data.temp, eps);
    }

    protected void testUnbound(Thermometer t, TestData data) {
        Assertions.assertThatExceptionOfType(OutOfBoundException.class)
                .isThrownBy(() -> t.value(data.temp));
        Assertions.assertThatExceptionOfType(OutOfBoundException.class)
                .isThrownBy(() -> t.temp(data.value));
    }
}
