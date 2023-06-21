package com.sb.jgrad.thermocouple;

import com.sb.jgrad.Graduation;

public abstract class Thermocouple implements Graduation {

    protected double calculate(double[] arr, double value, double start) {
        double res = start;
        for (int i = 0; i < arr.length; ++i)
            res += arr[i] * Math.pow(value, i);
        return res;
    }

    protected double calculate(double[] arr, double value) {
        return calculate(arr, value, 0);
    }
}