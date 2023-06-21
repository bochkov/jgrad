package com.sb.jgrad.thermocouple;

import com.sb.jgrad.OutOfBoundException;

public final class VRA1 extends Thermocouple {

    @Override
    public String name() {
        return "ТВР(A-1)";
    }

    @Override
    public String description() {
        return "Номинальная статическая характеристика преобразования термопары типа ТВР(A-1) { вольфрам-рений/вольфрам-рений }";
    }

    @Override
    public double value(double temp) throws OutOfBoundException {
        if (temp == 0.0)
            return 0.0;
        double[] a;
        if (temp > 0 && temp <= 2500)
            a = new double[]{7.1564735e-4, 1.1951905e-2, 1.6672625e-5,
                    -2.8287807e-8, 2.8397839e-11, -1.8505007e-14,
                    7.3632123e-18, -1.6148878e-21, 1.4901679e-25};
        else
            throw new OutOfBoundException("temp is out of bounds [0..2500]");

        return calculate(a, temp);
    }

    @Override
    public double temp(double v) throws OutOfBoundException {
        if (v == 0.0)
            return 0.0;
        double[] c;
        if (v >= 0 && v <= 33.640)
            c = new double[]{0.9643027, 7.9495086e1, -4.9990310,
                    0.6341776, -4.7440967e-2, 2.1811337e-3,
                    -5.8324228e-5, 8.2433725e-7, -4.5928480e-9};
        else
            throw new OutOfBoundException("value is out of bounds [0..33.640]");

        return calculate(c, v);
    }
}
