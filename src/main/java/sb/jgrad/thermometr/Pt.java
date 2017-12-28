package sb.jgrad.thermometr;

/**
 * Pt-Thermometer
 * a = 0.00385
 */
public final class Pt extends Thermometr {

    private final double R;

    public Pt(double r) {
        this.R = r;
    }

    @Override
    public String name() {
        return String.format("Pt%.0f", R);
    }

    @Override
    public String description() {
        return "";
    }

    @Override
    public double value(double temp) {
        if (temp >= -200 && temp <= 850) {
            double A = 3.9083e-3;
            double B = -5.775e-7;
            double C = -4.183e-12;
            double Wt = 1 + A * temp + B * temp * temp;
            if (temp < 0)
                Wt += C * (temp - 100) * temp * temp * temp;
            return R * Wt;
        } else
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
