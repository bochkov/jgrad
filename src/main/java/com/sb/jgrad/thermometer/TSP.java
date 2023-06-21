package com.sb.jgrad.thermometer;

import com.sb.jgrad.OutOfBoundException;

/**
 * a = 0.00391
 */
public final class TSP extends Thermometer {

    public TSP(double impedance) {
        super(impedance);
    }

    @Override
    public String name() {
        return String.format("%.0fП", impedance);
    }

    @Override
    public String description() {
        return "";
    }

    @Override
    public double value(double temp) throws OutOfBoundException {
        if (temp >= lower() && temp <= higher()) {
            double a = 3.9690e-3;
            double b = -5.841e-7;
            double c = -4.330e-12;
            double wt = 1 + a * temp + b * temp * temp;
            if (temp < 0)
                wt += c * (temp - 100) * temp * temp * temp;
            return wt * impedance;
        } else
            throw new OutOfBoundException("temp is out of bounds [-200..850]");
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
