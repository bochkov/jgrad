package sb.jgrad.thermocouple;

/**
 * Nominal static graduation of M-thermocouple
 */
public final class MKM extends Thermocouple {

    public static final String NAME = "ТМК(M)";
    public static final String DESCRIPTION = "Номинальная статическая характеристика " +
            "преобразования термопары типа ТМК(M) { медь/копель }";

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
        if (temp >= -200 && temp <= 100)
            A = new double[] {2.4455560e-6, 4.2638917e-2, 5.0348392e-5,
                    -4.4974485e-8};
        else
            throw new IllegalArgumentException("temp is out of bounds [-200..100]");

        return calculate(A, temp);
    }

    @SuppressWarnings({"unused", "UnusedAssignment"})
    @Override
    public double temp(double v) {
        double[] C;
        if (v >= -6.154 && v <= 4.722)
            C = new double[]{ 0.4548090, 2.2657698e-2, -7.7935652e-7, 1.1786931e-10};
        else
            throw new IllegalArgumentException("value is out of bounds [-6.154..4.722]");

        return calculate0(v);
    }

    private double calculate0(double v) {
        double EPS = 0.001;
        double begin = -200;
        double end = 100;
        double middle;
        do {
            middle = (begin + end) / 2;
            if (v > value(middle))
                begin = middle;
            else
                end = middle;
        } while (Math.abs(v - value(middle)) > EPS);
        return middle;
    }
}
