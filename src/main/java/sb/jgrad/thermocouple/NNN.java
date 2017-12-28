package sb.jgrad.thermocouple;

/**
 * Nominal static graduation of N-thermocouple
 */
public final class NNN extends Thermocouple {

    public static final String NAME = "ТНН(N)";
    public static final String DESCRIPTION = "Номинальная статическая характеристика " +
            "преобразования термопары типа ТНН(N) { никель-хром-кремний/никель-кремний (нихросил/нисил) }";

    @Override
    public String name() {
        return NAME;
    }

    @Override
    public String description() {
        return DESCRIPTION;
    }

    @Override
    public double value(double temp) {
        double[] A;
        if (temp >= -270 && temp < 0)
            A = new double[] {0, 2.6159105962e-2, 1.0957484228e-5, -9.3841111554e-8,
                    -4.6412039759e-11, -2.6303357716e-12, -2.26534380003e-14,
                    -7.6089300791e-17, -9.3419667835e-20};
        else if (temp >= 0 && temp <= 1300)
            A = new double[] {0, 2.5929394601e-2, 1.5710141880e-5, 4.3825627237e-8,
                    -2.5261169794e-10, 6.4311819339e-13, -1.0063471519e-15,
                    9.9745338992e-19, -6.0863245607e-22, 2.0849229339e-25,
                    -3.0682196151e-29};
        else
            throw new IllegalArgumentException("temp is out of bounds [-270..1300]");

        return calculate(A, temp);
    }

    @Override
    public double temp(double v) {
        double[] C;
        if (v >= -3.990 && v < 0)
            C = new double[]{0, 3.8436847e1, 1.1010485, 5.2229312,
                    7.2060525, 5.8488586, 2.7754916,
                    7.7075166e-1, 1.1582665e-1, 7.3138868e-3};
        else if (v >= 0 && v < 20.613)
            C = new double[]{0, 3.86896e1, -1.08267, 4.70205e-2,
                    -2.12169e-6, -1.17272e-4, 5.39280e-6,
                    -7.98156e-8};
        else if (v >= 20.613 && v <= 47.513)
            C = new double[]{1.972485e1, 3.300943e1, -3.915159e-1,
                    9.855391e-3, -1.274371e-4, 7.767022e-7};
        else
            throw new IllegalArgumentException("value is out of bounds [-3.990..47.513]");

        return calculate(C, v);
    }

}
