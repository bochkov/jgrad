package sb.jgrad.thermocouple;

/**
 * Nominal static graduation of A-2-thermocouple
 */
public final class VRA2 extends Thermocouple {

    public static final String NAME = "ТВР(A-2)";
    public static final String DESCRIPTION = "Номинальная статическая характеристика " +
            "преобразования термопары типа ТВР(A-2) { вольфрам-рений/вольфрам-рений }";

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
            A = new double[]{ -1.0850558e-4, 1.1642292e-2, 2.1280289e-5,
                    -4.4258402e-8, 5.5652058e-11, -4.3801310e-14,
                    2.0228390e-17, -4.9354041e-21, 4.8119846e-25};
        else
            throw new IllegalArgumentException("temp is out of bounds [0..1800]");

        return calculate(A, temp);
    }

    @Override
    public double temp(double v) {
        double[] C;
        if (v >= 0 && v <= 27.232)
            C = new double[]{1.1196428, 8.0569397e1, -6.2279122,
                    0.9337015, -8.2608051e-2, 4.4110979e-3,
                    -1.3610551e-4, 2.2183851e-6, -1.4527698e-8};
        else
            throw new IllegalArgumentException("value is out of bounds [0..27.232]");

        return calculate(C, v);
    }
}
