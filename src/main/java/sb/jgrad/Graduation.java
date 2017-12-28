package sb.jgrad;

public interface Graduation {

    /**
     * Convert graduation value to themperature
     *
     * @param value graduation value
     * @return themperature
     */
    double temp(double value);

    /**
     * Convert themperature to graduation value
     *
     * @param temp themperature
     * @return graduation value
     */
    double value(double temp);

    /**
     * @return graduation name
     */
    String name();

    /**
     * @return graduation description
     */
    String description();
}
