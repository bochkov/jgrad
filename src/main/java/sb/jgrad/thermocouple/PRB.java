package sb.jgrad.thermocouple;

/**
 * Nominal static graduation of B-thermocouple
 */
public final class PRB extends Thermocouple {

    public static final String NAME = "ТПР(B)";
    public static final String DESCRIPTION = "Номинальная статическая характеристика " +
            "преобразования термопары типа ТПР(B) { 30%-платина-родий/платина-родий-6% }";

    @Override
    public String description() {
        return DESCRIPTION;
    }

    @Override
    public String name() {
        return NAME;
    }

    @Override
    public double value(double temp) {
        double[] A;
        if (temp >= 0 && temp < 630.615)
            A = new double[]{0, -2.4650818346e-4, 5.9040421171e-6, -1.3257931636e-9,
                    1.5668291901e-12, -1.6944529240e-15, 6.2990347094e-19};
        else if (temp >= 630.615 && temp <= 1820)
            A = new double[]{ -3.8938168621, 2.8571747470e-2, -8.4885104785e-5,
                    1.5785280164e-7, -1.6835344864e-10, 1.1109794013e-13,
                    -4.4515431033e-17, 9.8975640821e-21, -9.3791330289e-25};
        else
            throw new IllegalArgumentException("temp is out of bounds [0..1820]");

        return calculate(A, temp);
    }

    @Override
    public double temp(double v) {
        double[] C;
        if (v >= 0.291 && v < 2.431)
            C = new double[]{9.8423321e1, 6.9971500e2, -8.4765304e2,
                    1.0052644e3, -8.3345952e2, 4.5508542e2,
                    -1.5523037e2, 2.9886750e1, -2.4742860};
        else if (v >= 2.431 && v <= 13.820)
            C = new double[]{2.1315071e2, 2.8510504e2, -5.2742887e1,
                    9.9160804, -1.2965303, 1.1195870e-1,
                    -6.0625199e-3, 1.8661696e-4, -2.4878585e-6};
        else
            throw new IllegalArgumentException("value is out of bounds [0.291..13.820]");

        return calculate(C, v);
    }
}
