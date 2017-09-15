package com.company;

public class VehicleInfo {


    int VIN;
    double odometer;
    double consumption;
    double odometerSenseLastOilChange;
    double engineSize;

    public VehicleInfo(int VIN, double odometer, double consumption, double odometerSenseLastOilChange, double engineSize) {

    }

    public int getVIN() {
        return VIN;
    }

    public void setVIN(int VIN) {
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

    public double getOdometerSenseLastOilChange() {
        return odometerSenseLastOilChange;
    }

    public void setOdometerSenseLastOilChange(double odometerSenseLastOilChange) {
        this.odometerSenseLastOilChange = odometerSenseLastOilChange;
    }

    public double getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(double engineSize) {
        this.engineSize = engineSize;
    }
}
