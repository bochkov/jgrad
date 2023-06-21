package com.sb.jgrad;

public interface Graduation {

    /**
     * Convert graduation value to temperature
     * @param value graduation value
     * @return temperature
     */
    double temp(double value) throws OutOfBoundException;

    /**
     * Convert temperature to graduation value
     * @param temp temperature
     * @return graduation value
     */
    double value(double temp) throws OutOfBoundException;

    /**
     * @return graduation name
     */
    String name();

    /**
     * @return graduation description
     */
    String description();
}
