package com.sb.jgrad.thermocouple;

import com.sb.jgrad.OutOfBoundException;

public final class VRA2 extends Thermocouple {

    @Override
    public String name() {
        return "ТВР(A-2)";
    }

    @Override
    public String description() {
        return "Номинальная статическая характеристика преобразования термопары типа ТВР(A-2) { вольфрам-рений/вольфрам-рений }";
    }

    @Override
    public double value(double temp) throws OutOfBoundException {
        if (temp == 0.0)
            return 0.0;
        double[] a;
        if (temp >= 0 && temp <= 1800)
            a = new double[]{-1.0850558e-4, 1.1642292e-2, 2.1280289e-5,
                    -4.4258402e-8, 5.5652058e-11, -4.3801310e-14,
                    2.0228390e-17, -4.9354041e-21, 4.8119846e-25};
        else
            throw new OutOfBoundException("temp is out of bounds [0..1800]");

        return calculate(a, temp);
    }

    @Override
    public double temp(double v) throws OutOfBoundException {
        if (v == 0.0)
            return 0.0;
        double[] c;
        if (v >= 0 && v <= 27.232)
            c = new double[]{1.1196428, 8.0569397e1, -6.2279122,
                    0.9337015, -8.2608051e-2, 4.4110979e-3,
                    -1.3610551e-4, 2.2183851e-6, -1.4527698e-8};
        else
            throw new OutOfBoundException("value is out of bounds [0..27.232]");

        return calculate(c, v);
    }
}
