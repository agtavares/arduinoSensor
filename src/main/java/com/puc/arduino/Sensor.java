package com.puc.arduino;

public class Sensor {

    private String sensorName;

    private String percentageValue;

    public String getSensorName() {
        return sensorName;
    }

    public void setSensorName(String sensorName) {
        this.sensorName = sensorName;
    }

    public String getPercentageValue() {
        return percentageValue;
    }

    public void setPercentageValue(String percentageValue) {
        this.percentageValue = percentageValue;
    }

}
