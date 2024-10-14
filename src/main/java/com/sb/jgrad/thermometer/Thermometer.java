package com.sb.jgrad.thermometer;

import com.sb.jgrad.Graduation;
import com.sb.jgrad.OutOfBoundException;

public abstract class Thermometer implements Graduation {

    private static final double EPS = 0.005;

    protected final double impedance;

    protected Thermometer(double impedance) {
        this.impedance = impedance;
    }

    public abstract double lower();

    public abstract double higher();

    @Override
    public double temp(double ohm) throws OutOfBoundException {
        double lowerBound = value(lower()) - EPS;
        if (ohm < lowerBound)
            throw new OutOfBoundException(String.format("value %f is lower than minimal value = %f", ohm, lowerBound));
        double higherBound = value(higher()) + EPS;
        if (ohm > higherBound)
            throw new OutOfBoundException(String.format("value %f is higher than maximum value = %f", ohm, higherBound));

        double begin = lower();
        double end = higher();
        double middle;
        while (true) {
            middle = (begin + end) / 2;
            double value = value(middle);
            if (value > ohm) {
                end = middle;
            } else {
                begin = middle;
            }
            if (Math.abs(value - ohm) < EPS) {
                break;
            }
        }
        return middle;
    }
}
