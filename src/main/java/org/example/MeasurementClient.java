package org.example;

public class MeasurementClient {

    private long value;

    private String raining;

    private SensorClient sensor;

    public long getValue() {
        return value;
    }

    public void setValue(final long value) {
        this.value = value;
    }

    public String getRaining() {
        return raining;
    }

    public void setRaining(final String raining) {
        this.raining = raining;
    }

    public SensorClient getSensor() {
        return sensor;
    }

    public void setSensor(final SensorClient sensor) {
        this.sensor = sensor;
    }
}
