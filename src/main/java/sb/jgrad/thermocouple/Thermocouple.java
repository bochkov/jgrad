package sb.jgrad.thermocouple;

import sb.jgrad.Graduation;

/**
 * Abstract class of thermocouples
 */
public abstract class Thermocouple implements Graduation {

    /**
     * Magic calculate with some offset
     *
     * @param arr   data
     * @param value independed thermocouple constant
     * @param start offset
     * @return result
     */
    protected double calculate(double[] arr, double value, double start) {
        double res = start;
        for (int i = 0; i < arr.length; ++i)
            res += arr[i] * Math.pow(value, i);
        return res;
    }

    /**
     * Magic calculate without offset
     *
     * @param arr   data
     * @param value independed thermocouple constant
     * @return result
     */
    protected double calculate(double[] arr, double value) {
        return calculate(arr, value, 0);
    }
}