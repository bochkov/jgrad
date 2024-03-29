package com.sb.jgrad.thermocouple;

import com.sb.jgrad.OutOfBoundException;

public final class JKJ extends Thermocouple {

    @Override
    public String name() {
        return "ТЖК(J)";
    }

    @Override
    public String description() {
        return "Номинальная статическая характеристика преобразования термопары типа ТЖК(J) { железо-медь/никель (железо/константан) }";
    }

    @Override
    public double value(double temp) throws OutOfBoundException {
        double[] a;
        if (temp >= -210 && temp < 760)
            a = new double[]{0, 5.0381187815e-2, 3.0475836930e-5, -8.5681065720e-8,
                    1.3228195295e-10, -1.7052958337e-13, 2.0948090697e-16,
                    -1.2538395336e-19, 1.5631725697e-23};
        else if (temp >= 760 && temp <= 1200)
            a = new double[]{2.9645625681e2, -1.4976127786, 3.1787103924e-3,
                    -3.1847686701e-6, 1.5720819004e-9, -3.0691369056e-13};
        else
            throw new OutOfBoundException("temp is out of bounds [-210..1200]");

        return calculate(a, temp);
    }

    @Override
    public double temp(double v) throws OutOfBoundException {
        double[] c;
        if (v >= -8.095 && v < 0)
            c = new double[]{0, 1.9528268e1, -1.2286185, -1.0752178,
                    -5.9086933e-1, -1.7256713e-1, -2.8131513e-2,
                    -2.3963370e-3, -8.3823321e-5};
        else if (v >= 0 && v < 42.919)
            c = new double[]{0, 1.978425e1, -2.001204e-1, 1.036969e-2,
                    -2.549687e-4, 3.585153e-6, -5.344285e-8,
                    5.099890e-10};
        else if (v >= 42.919 && v <= 69.553)
            c = new double[]{-3.11358187e3, 3.00543684e2, -9.94773230,
                    1.70276630e-1, -1.43033468e-3, 4.73886084e-6};
        else
            throw new OutOfBoundException("value is out of bounds [-8.095..69.553]");

        return calculate(c, v);
    }

}
