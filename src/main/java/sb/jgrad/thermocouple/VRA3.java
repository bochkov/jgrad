package sb.jgrad.thermocouple;

/**
 * Nominal static graduation of A-3-thermocouple
 */
public final class VRA3 extends Thermocouple {

    public static final String NAME = "ТВР(A-3)";
    public static final String DESCRIPTION = "Номинальная статическая характеристика " +
            "преобразования термопары типа ТВР(A-3) { вольфрам-рений/вольфрам-рений }";

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
        if (temp >= 0 && temp <= 1800)
            A = new double[]{ -1.0649133e-4, 1.1686475e-2, 1.8022157e-5,
                    -3.3436998e-8, 3.7081688e-11, -2.5748444e-14,
                    1.0301893e-17, -2.0735944e-21, 1.4678450e-25};
        else
            throw new IllegalArgumentException("temp is out of bounds [0..1800]");

        return calculate(A, temp);
    }

    @Override
    public double temp(double v) {
        double[] C;
        if (v >= 0 && v <= 26.773)
            C = new double[]{0.8769216, 8.1483231e1, -5.9344173,
                    0.8699340, -7.6797687e-2, 4.1814387e-3,
                    -1.3439670e-4, 2.342409e-6, -1.6988727e-8};
        else
            throw new IllegalArgumentException("value is out of bounds [0..26.773]");

        return calculate(C, v);
    }
}
