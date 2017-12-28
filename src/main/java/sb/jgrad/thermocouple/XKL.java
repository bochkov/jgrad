package sb.jgrad.thermocouple;

/**
 * Nominal static graduation of L-thermocouple
 */
public final class XKL extends Thermocouple {

    public static final String NAME = "ТХК(L)";
    public static final String DESCRIPTION = "Номинальная статическая характеристика " +
            "преобразования термопары типа ТХК(L) { хромель/копель }";

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
        if (temp >= -200 && temp < 0)
            A = new double[]{ -5.8952244e-5, 6.3391502e-2, 6.7592964e-5, 2.0672566e-7,
                5.5720884e-9, 5.7133860e-11, 3.2995593e-13, 9.92322420e-16, 1.2079584e-18 };
        else if (temp >=0 && temp <= 800)
            A = new double[] { -1.8656953e-5, 6.3310975e-2, 6.0153091e-5, -8.0073134e-8,
                    9.6946071e-11, -3.6047289e-14, -2.4694775e-16, 4.2880341e-19, -2.0725297e-22 };
        else
            throw new IllegalArgumentException("temp is out of bounds [-200..800]");

        return calculate(A, temp);
    }

    @Override
    public double temp(double v) {
        double[] C;
        if (v >= -9.488 && v < 0.000)
            C = new double[]{ 1.1573067e-4, 1.5884573e1, 4.0458554e-2, 0.3170064,
                    0.1666128, 5.1946958e-2, 9.5288883e-3, 1.0301283e-3, 6.0654431e-5, 1.5131878e-6 };
        else if (v >= 0.000 && v <= 66.466)
            C = new double[] { 7.2069422e-3, 1.5775525e1, -0.2261183, 9.4286756e-3, -3.5394655e-4,
                    1.0050886e-5, -1.9323678e-7, 2.3816891e-9, -1.7130654e-11, 5.4857331e-14 };
        else
            throw new IllegalArgumentException("value is out of bounds [-9.488..66.466]");

        return calculate(C, v);
    }
}
