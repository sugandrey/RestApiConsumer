package org.example;

import java.util.Objects;

public class SensorClient {

    private String sensorName;

    public String getSensorName() {
        return sensorName;
    }

    public void setSensorName(final String sensorName) {
        this.sensorName = sensorName;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final SensorClient sensor = (SensorClient) o;
        return Objects.equals(sensorName, sensor.sensorName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sensorName);
    }
}
