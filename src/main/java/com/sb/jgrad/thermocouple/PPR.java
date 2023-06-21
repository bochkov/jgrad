package com.sb.jgrad.thermocouple;

import com.sb.jgrad.OutOfBoundException;

public final class PPR extends Thermocouple {

    @Override
    public String name() {
        return "ТПП(R)";
    }

    @Override
    public String description() {
        return "Номинальная статическая характеристика преобразования термопары типа ТПП(R) { 13%-платина-родий/платина }";
    }

    @Override
    public double value(double temp) throws OutOfBoundException {
        double[] a;
        if (temp >= -50 && temp < 1064.18)
            a = new double[]{0, 5.28961729765e-3, 1.39166589782e-5, -2.3885693017e-8,
                    3.56916001063e-11, -4.62347666298e-14, 5.00777441034e-17,
                    -3.73105886191e-20, 1.57716482367e-23, -2.81038625251e-27};
        else if (temp >= 1064.18 && temp < 1664.5)
            a = new double[]{2.95157925316, -2.52061251332e-3, 1.59564501865e-5,
                    -7.64085947576e-9, 2.05305291024e-12, -2.93359668173e-16};
        else if (temp >= 1664.5 && temp < 1768.1)
            a = new double[]{1.52232118209e2, -2.68819888545e-1, 1.71280280471e-4,
                    -3.45895706453e-8, -9.34633971046e-15};
        else
            throw new OutOfBoundException("temp is out of bounds [-50..1768]");

        return calculate(a, temp);
    }

    @Override
    public double temp(double v) throws OutOfBoundException {
        double[] c;
        if (v >= -0.226 && v < 1.923)
            c = new double[]{0, 1.8891380e2, -9.3835290e1, 1.3068619e2,
                    -2.2703580e2, 3.5145659e2, -3.8953900e2,
                    2.8239471e2, -1.2607281e2, 3.1353611e1, -3.3187769};
        else if (v >= 1.923 && v < 11.361)
            c = new double[]{1.334584505e1, 1.472644573e2, -1.844024844e1,
                    4.031129726, -6.249428360e-1, 6.468412049e-2,
                    -4.458750426e-3, 1.994710149e-4, -5.313401790e-6, 6.481976217e-8};
        else if (v >= 11.361 && v < 19.739)
            c = new double[]{-8.199599416e1, 1.553962042e2, -8.342197663,
                    4.279433549e-1, -1.191577910e-2, 1.492290091e-4};
        else if (v >= 19.739 && v < 21.102)
            c = new double[]{3.406177836e4, -7.023729171e3, 5.582903813e2,
                    -1.952394635e1, 2.560740231e-1};
        else
            throw new OutOfBoundException("value is out of bounds [-0.225..21.101]");

        return calculate(c, v);
    }
}
