package sb.jgrad.thermometr;

/**
 * M-Thermometer
 */
public final class TSM extends Thermometr {

    private final double R;

    public TSM(double r) {
        this.R = r;
    }

    @Override
    public String name() {
        return String.format("%.0fМ", R);
    }

    @Override
    public String description() {
        return "";
    }

    @Override
    public double value(double temp) {
        if (temp >= -50 && temp <= 200) {
            double A = 4.28e-3;
            double B = -6.2032e-7;
            double C = 8.5154e-10;
            double Wt = (1 + A * temp);
            if (temp < 0)
                Wt += B * temp * (temp + 6.7) + C * temp * temp * temp;
            return Wt * R;
        } else
            throw new IllegalArgumentException("temp is out of bounds [-50..200]");
    }

    @Override
    public double lower() {
        return -50;
    }

    @Override
    public double higher() {
        return 200;
    }
}
