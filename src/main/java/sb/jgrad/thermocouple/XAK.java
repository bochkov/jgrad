package sb.jgrad.thermocouple;

/**
 * Nominal static graduation of K-thermocouple
 */
public final class XAK extends Thermocouple {

    public static final String NAME = "ТХА(K)";
    public static final String DESCRIPTION = "Номинальная статическая характеристика " +
            "преобразования термопары типа ТХА(K) { никель-хром/никель-алюминий (хромель/алюмель) }";

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
        double start = 0;
        if (temp >= -270 && temp < 0)
            A = new double[]{0, 3.9450128025e-2, 2.3622373598e-5, -3.2858906784e-7,
                    -4.9904828777e-9, -6.7509059173e-11, -5.7410327428e-13,
                    -3.1088872894e-15, -1.0451609365e-17, -1.9889266878e-20,
                    -1.6322697486e-23};
        else if (temp >= 0 && temp <= 1372) {
            A = new double[]{ -1.7600413686e-2, 3.8921204975e-2, 1.8558770032e-5,
                    -9.9457592874e-8, 3.1840945719e-10, -5.6072844889e-13,
                    5.6075059059e-16, -3.2020720003e-19, 9.7151147152e-23,
                    -1.2104721275e-26};
            start = 1.185976e-1 * Math.pow(Math.E, -1.183432e-4 * (temp - 126.9686) * (temp - 126.9686));
        }
        else
            throw new IllegalArgumentException("temp is out of bounds [-270..1372]");

        return calculate(A, temp, start);
    }

    @Override
    public double temp(double v) {
        double[] C;
        if (v >= -5.891 && v < 0)
            C = new double[]{0, 2.5173462e1, -1.1662878, -1.0833638,
                    -8.9773540e-1, -3.7342377e-1, -8.6632643e-2,
                    -1.0450598e-2, -5.1920577e-4};
        else if (v >= 0 && v < 20.644)
            C = new double[]{0, 2.508355e1, 7.860106e-2, -2.503131e-1,
                    8.315270e-2, -1.228034e-2, 9.804036e-4,
                    -4.413030e-5, 1.057734e-6, -1.052755e-8};
        else if (v >= 20.644 && v <= 54.886)
            C = new double[]{ -1.318058e2, 4.830222e1, -1.646031,
                    5.464731e-2, -9.650715e-4, 8.802193e-6,
                    -3.110810e-8};
        else
            throw new IllegalArgumentException("value is out of bounds [-5.891..54.886]");

        return calculate(C, v);
    }
}
