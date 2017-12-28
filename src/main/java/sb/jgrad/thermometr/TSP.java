package sb.jgrad.thermometr;

/**
 * T-Thermometer
 * a = 0.00391
 */
public final class TSP extends Thermometr {

    private final double R;

    public TSP(double r) {
        this.R = r;
    }

    @Override
    public String name() {
        return String.format("%.0fП", R);
    }

    @Override
    public String description() {
        return "";
    }

    @Override
    public double value(double temp) {
        if (temp >= -200 && temp <= 850) {
            double A = 3.9690e-3;
            double B = -5.841e-7;
            double C = -4.330e-12;
            double Wt = 1 + A * temp + B * temp * temp;
            if (temp < 0)
                Wt += C * (temp - 100) * temp * temp * temp;
            return R * Wt;
        }
        else
            throw new IllegalArgumentException("temp is out of bounds [-200..850]");
    }

    @Override
    public double lower() {
        return -200;
    }

    @Override
    public double higher() {
        return 850;
    }
}
