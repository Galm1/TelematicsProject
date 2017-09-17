package com.company;

import com.sun.xml.internal.bind.v2.TODO;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here


        Scanner input = new Scanner(System.in);
        VehicleInfo newVehicle = new VehicleInfo();

        String[] prompt =
                {
                        "VIN number",
                        "odometer number",
                        "gas consumption",
                        "odometer sense your last oil change",
                        "engine size in liters"
                };
        // figure out reflection to make a pseudo array of methods
        double[] setArray = {new newVehicle.setVIN(), };
        int counter = 0;

        while(counter != prompt.length){

            System.out.println(prompt[counter]);
            String in = input.nextLine();
            newVehicle.
            counter++;
        }

    }
}
