package org.example;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.ArrayList;
import java.util.List;

public class SensorList {

    private List<SensorClient> sensors;

    public SensorList() {
        this.sensors = new ArrayList<>();
    }

    public List<SensorClient> getSensors() {
        return sensors;
    }

    public void setSensors(final List<SensorClient> sensors) {
        this.sensors = sensors;
    }
}
