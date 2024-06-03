package org.example;

import java.util.ArrayList;
import java.util.List;

public class MeasurementList {

    List<MeasurementClient> measurementClients;

    public MeasurementList() {
        this.measurementClients = new ArrayList<>();
    }

    public List<MeasurementClient> getMeasurementClients() {
        return measurementClients;
    }

    public void setMeasurementClients(final List<MeasurementClient> measurementClients) {
        this.measurementClients = measurementClients;
    }
}
