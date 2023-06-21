package com.sb.jgrad.thermometer;

import com.sb.jgrad.OutOfBoundException;

public final class TSN extends Thermometer {

    public TSN(double impedance) {
        super(impedance);
    }

    @Override
    public String name() {
        return String.format("%.0fН", impedance);
    }

    @Override
    public String description() {
        return "";
    }

    @Override
    public double value(double temp) throws OutOfBoundException {
        if (temp >= lower() && temp <= higher()) {
            double a = 5.4963e-3;
            double b = 6.7556e-6;
            double c = 9.2004e-9;
            double wt = 1 + a * temp + b * temp * temp;
            if (temp > 100)
                wt += c * (temp - 100) * temp * temp;
            return wt * impedance;
        } else
            throw new OutOfBoundException("temp is out of bounds [-60..180]");
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
