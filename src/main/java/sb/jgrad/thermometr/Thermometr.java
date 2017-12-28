package sb.jgrad.thermometr;

import sb.jgrad.Graduation;

public abstract class Thermometr implements Graduation {

    private static final double EPS = 0.001;

    abstract public double lower();

    abstract public double higher();

    @Override
    public double temp(double ohm) {
        value(ohm); // проверка на IllegalArgumentException
        double begin = lower();
        double end = higher();
        double middle;
        do {
            middle = (begin + end) / 2;
            if (value(middle) > ohm)
                end = middle;
            else
                begin = middle;
        } while (Math.abs(value(middle) - ohm) > EPS);
        return middle;
    }
}
