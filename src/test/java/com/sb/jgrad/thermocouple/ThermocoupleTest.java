package com.sb.jgrad.thermocouple;

import com.sb.jgrad.OutOfBoundException;
import org.assertj.core.api.Assertions;
import org.assertj.core.data.Offset;

abstract class ThermocoupleTest {

    // 3.4 Погрешность расчета значений ТЭДС по приведенным полиномам не превышает одной
    // единицы в последней значащей цифре приведенных в таблицах настоящего стандарта значений ТЭДС.
    private final Offset<Double> toValue = Assertions.offset(0.001);
    private final Offset<Double> toTemp = Assertions.offset(1.0);

    record TestData(double temp, double value) {
    }

    protected void testData(Thermocouple t, TestData data) throws OutOfBoundException {
        Assertions.assertThat(t.value(data.temp)).isCloseTo(data.value, toValue);
        if (data.temp == 0.0) {
            Assertions.assertThat(t.temp(data.value)).isCloseTo(data.temp, toValue);
        } else {
            Assertions.assertThat(t.temp(data.value)).isCloseTo(data.temp, toTemp);
        }
    }

    protected void testUnbound(Thermocouple t, TestData data) {
        Assertions.assertThatExceptionOfType(OutOfBoundException.class)
                .isThrownBy(() -> t.value(data.temp));
        Assertions.assertThatExceptionOfType(OutOfBoundException.class)
                .isThrownBy(() -> t.temp(data.value));
    }

}
