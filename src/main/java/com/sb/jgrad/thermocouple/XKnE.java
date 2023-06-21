package com.sb.jgrad.thermocouple;

import com.sb.jgrad.OutOfBoundException;

public final class XKnE extends Thermocouple {

    @Override
    public String name() {
        return "ТХКн(E)";
    }

    @Override
    public String description() {
        return "Номинальная статическая характеристика преобразования термопары типа ТХКн(E) { никель-хром/медь-никель (медь/константан) }";
    }

    @Override
    public double value(double temp) throws OutOfBoundException {
        double[] a;
        if (temp >= -200 && temp < 0)
            a = new double[]{0, 5.8665508708e-2, 4.5410977124e-5, -7.7998048686e-7,
                    -2.5800160843e-8, -5.9452583057e-10, -9.3214058667e-12,
                    -1.0287605534e-13, -8.0370123621e-16, -4.3979497391e-18,
                    -1.6414776355e-20, -3.9673619516e-23, -5.5827328721e-26,
                    -3.4657842013e-29};
        else if (temp >= 0 && temp <= 1000)
            a = new double[]{0, 5.8665508710e-2, 4.5032275582e-5, 2.8908407212e-8,
                    -3.3056896652e-10, 6.5024403270e-13, -1.9197475504e-16,
                    -1.2536600497e-18, 2.1489217569e-21, -1.4388041782e-24,
                    3.5960899481e-28};
        else
            throw new OutOfBoundException("temp is out of bounds [-200..1000]");

        return calculate(a, temp);
    }

    @Override
    public double temp(double v) throws OutOfBoundException {
        double[] c;
        if (v >= -8.825 && v < 0)
            c = new double[]{0, 1.6977288e1, -4.3514970e-1, -1.5859697e-1,
                    -9.2502871e-2, -2.6084314e-2, -4.1360199e-3,
                    -3.4034030e-4, -1.1564890e-5};
        else if (v >= 0 && v <= 76.373)
            c = new double[]{0, 1.7057035e1, -2.3301759e-1, 6.5435585e-3,
                    -7.3562749e-5, -1.7896001e-6, 8.4036165e-8,
                    -1.3735879e-9, 1.0629823e-11, -3.2447087e-14};
        else
            throw new OutOfBoundException("value is out of bounds [-8.825..76.373]");

        return calculate(c, v);
    }
}
