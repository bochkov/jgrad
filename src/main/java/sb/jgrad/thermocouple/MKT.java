package sb.jgrad.thermocouple;

/**
 * Nominal static graduation of T-thermocouple
 */
public final class MKT extends Thermocouple {

    public static final String NAME = "ТМК(T)";
    public static final String DESCRIPTION = "Номинальная статическая характеристика " +
            "преобразования термопары типа ТМК(T) { медь/медь-никель (медь/константан) }";

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
            A = new double[] {0, 3.8748106364e-2, 4.4194434347e-5, 1.1844323105e-7,
                    2.0032973554e-8, 9.0138019559e-10, 2.2651156593e-11,
                    3.6071154205e-13, 3.8493939883e-15, 2.8213521925e-17,
                    1.4251594779e-19, 4.8768662286e-22, 1.0795539270e-24,
                    1.3945027062e-27, 7.9795153927e-31};
        else if (temp >= 0 && temp <= 400)
            A = new double[] {0, 3.8748106364e-2, 3.3292227880e-5, 2.0618243404e-7,
                    -2.1882256846e-9, 1.0996880928e-11, -3.0815758772e-14,
                    4.5479135290e-17, -2.7512901673e-20};
        else
            throw new IllegalArgumentException("temp is out of bounds [-270..400]");

        return calculate(A, temp);
    }

    @Override
    public double temp(double v) {
        double[] C;
        if (v >= -5.603 && v < 0)
            C = new double[] {0, 2.5949192e1, -2.1316967e-1, 7.9018692e-1,
                    4.2527777e-1, 1.3304473e-1, 2.0241446e-2,
                    1.2668171e-3};
        else if (v >= 0 && v <= 20.872)
            C = new double[] {0, 2.592800e1, -7.602961e-1, 4.637791e-2,
                    -2.165394e-3, 6.048144e-5, -7.293422e-7};
        else
            throw new IllegalArgumentException("value is out of bounds [-5.603..20.872]");

        return calculate(C, v);
    }

}
