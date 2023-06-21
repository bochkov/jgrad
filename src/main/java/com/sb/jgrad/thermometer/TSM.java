package com.sb.jgrad.thermometer;

import com.sb.jgrad.OutOfBoundException;

public final class TSM extends Thermometer {

    public TSM(double impedance) {
        super(impedance);
    }

    @Override
    public String name() {
        return String.format("%.0fМ", impedance);
    }

    @Override
    public String description() {
        return "";
    }

    @Override
    public double value(double temp) throws OutOfBoundException {
        if (temp >= lower() && temp <= higher()) {
            double a = 4.28e-3;
            double b = -6.2032e-7;
            double c = 8.5154e-10;
            double wt = (1 + a * temp);
            if (temp < 0)
                wt += b * temp * (temp + 6.7) + c * temp * temp * temp;
            return wt * impedance;
        } else
            throw new OutOfBoundException("temp is out of bounds [-50..200]");
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
