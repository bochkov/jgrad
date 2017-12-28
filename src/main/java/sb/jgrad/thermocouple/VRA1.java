package sb.jgrad.thermocouple;

/**
 * Nominal static graduation of A-1-thermocouple
 */
public final class VRA1 extends Thermocouple {

    public static final String NAME = "ТВР(A-1)";
    public static final String DESCRIPTION = "Номинальная статическая характеристика " +
            "преобразования термопары типа ТВР(A-1) { вольфрам-рений/вольфрам-рений }";

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
        if (temp >= 0 && temp <= 2500)
            A = new double[]{7.1564735e-4, 1.1951905e-2, 1.6672625e-5,
                    -2.8287807e-8, 2.8397839e-11, -1.8505007e-14,
                    7.3632123e-18, -1.6148878e-21, 1.4901679e-25};
        else
            throw new IllegalArgumentException("temp is out of bounds [0..2500]");

        return calculate(A, temp);
    }

    @Override
    public double temp(double v) {
        double[] C;
        if (v >= 0 && v <= 33.640)
            C = new double[]{0.9643027, 7.9495086e1, -4.9990310,
                    0.6341776, -4.7440967e-2, 2.1811337e-3,
                    -5.8324228e-5, 8.2433725e-7, -4.5928480e-9};
        else
            throw new IllegalArgumentException("value is out of bounds [0..33.640]");

        return calculate(C, v);
    }
}
