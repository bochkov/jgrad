package sb.jgrad.thermometr;

/**
 * N-Thermometer
 */
public final class TSN extends Thermometr {

    private final double R;

    public TSN(double r) {
        this.R = r;
    }

    @Override
    public String name() {
        return String.format("%.0fН", R);
    }

    @Override
    public String description() {
        return "";
    }

    @Override
    public double value(double temp) {
        if (temp >= -60 && temp <= 180) {
            double A = 5.4963e-3;
            double B = 6.7556e-6;
            double C = 9.2004e-9;
            double Wt = 1 + A * temp + B * temp * temp;
            if (temp > 100)
                Wt += C * (temp - 100) * temp * temp;
            return R * Wt;
        }
        else
            throw new IllegalArgumentException("temp is out of bounds [-60..180]");
    }

    @Override
    public double lower() {
        return -60;
    }

    @Override
    public double higher() {
        return 180;
    }
}
