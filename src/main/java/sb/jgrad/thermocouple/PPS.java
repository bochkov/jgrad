package sb.jgrad.thermocouple;

/**
 * Nominal static graduation of S-thermocouple
 */
public final class PPS extends Thermocouple {

    public static final String NAME = "ТПП(S)";
    public static final String DESCRIPTION = "Номинальная статическая характеристика " +
            "преобразования термопары типа ТПП(S) { 10%-платина-родий/платина }";

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
        if (temp >= -50 && temp < 1064.18)
            A = new double[]{0, 5.40313308631e-3, 1.25934289740e-5, -2.32477968689e-8,
                    3.22028823036e-11, -3.31465196389e-14, 2.55744251786e-17,
                    -1.25068871393e-20, 2.71443176145e-24};
        else if (temp >= 1064.18 && temp < 1664.5)
            A = new double[]{1.32900444085, 3.34509311344e-3, 6.54805192818e-6,
                    -1.64856259209e-9, 1.29989605174e-14};
        else if (temp >= 1664.5 && temp < 1768.1)
            A = new double[]{1.46628232636e2, -2.58430516752e-1, 1.63693574641e-4,
                    -3.30439046987e-8, -9.43223690612e-15};
        else
            throw new IllegalArgumentException("temp is out of bounds [-50..1768.1]");

        return calculate(A, temp);
    }

    @Override
    public double temp(double v) {
        double[] C;
        if (v >= -0.235 && v <= 1.874)
            C = new double[]{0, 1.84949460e2, -8.00504062e1, 1.02237430e2,
                    -1.52248592e2, 1.88821343e2, -1.59085941e2,
                    8.23027880e1, -2.34181944e1, 2.79786260};
        else if (v >= 1.874 && v < 10.332)
            C = new double[]{1.291507177e1, 1.466298863e2, -1.534713402e1,
                    3.145945973, -4.163257839e-1, 3.187963771e-2,
                    -1.291637500e-3, 2.183475089e-5, -1.447379511e-7,
                    8.211272125e-9};
        else if (v >= 10.332 && v < 17.536)
            C = new double[]{ -8.087801117e1, 1.621573104e2, -8.536869453,
                    4.719686976e-1, -1.441693666e-2, 2.081618890e-4};
        else if (v >= 17.536 && v <= 18.694)
            C = new double[]{5.333875126e4, -1.235892298e4, 1.092657613e3,
                    -4.265693686e1, 6.247205420e-1};
        else
            throw new IllegalArgumentException("value is out of bounds [-0.236..18.694]");

        return calculate(C, v);
    }
}
