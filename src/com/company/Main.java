package com.company;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here


        Scanner input = new Scanner(System.in);
        VehicleInfo newVehicle = new VehicleInfo();

        System.out.println("Enter you VIN");
        newVehicle.setVIN(Double.parseDouble(input.next()));

        System.out.println("Enter you Odometer");
        newVehicle.setOdometer(Double.parseDouble(input.next()));

        System.out.println("Enter your gas consumption");
        newVehicle.setConsumption(Double.parseDouble(input.next()));

        System.out.println("Enter odometer sense last oil change");
        newVehicle.setOdometerSenseLastOilChange(Double.parseDouble(input.next()));

        System.out.println("Enter your engine size");
        newVehicle.setEngineSize(Double.parseDouble(input.next()));

        TelematicsService telematicsService = new TelematicsService();
        telematicsService.report(newVehicle);


    }
}
