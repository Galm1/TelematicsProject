package com.company;

import java.util.Date;

public class VehicleInfo {


    double VIN;
    double odometer;
    double consumption;
    Date odometerSenseLastOilChange;
    double engineSize;

    public VehicleInfo() {

    }

    public double getVIN() {
        return VIN;
    }

    public void setVIN(double VIN) {
        this.VIN = VIN;
    }

    public double getOdometer() {
        return odometer;
    }

    public void setOdometer(double odometer) {
        this.odometer = odometer;
    }

    public double getConsumption() {
        return consumption;
    }

    public void setConsumption(double consumption) {
        this.consumption = consumption;
    }

    public Date getOdometerSenseLastOilChange() {
        return odometerSenseLastOilChange;
    }

    public void setOdometerSenseLastOilChange(Date odometerSenseLastOilChange) {
        this.odometerSenseLastOilChange = odometerSenseLastOilChange;
    }

    public double getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(double engineSize) {
        this.engineSize = engineSize;
    }

}
