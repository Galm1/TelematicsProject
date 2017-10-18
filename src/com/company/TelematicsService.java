package com.company;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


public class TelematicsService {

    public void report(VehicleInfo vehicleInfo) throws IOException {

        String filename = vehicleInfo.getVIN() + ".json";
        File newFile = new File(filename);

        Date currentDate = new Date();
        vehicleInfo.setDateOfService(currentDate);

        try {
            FileWriter fileWriter = new FileWriter(newFile);
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(vehicleInfo);
            fileWriter.write(json);
            fileWriter.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        File file = new File(".");

        ArrayList<VehicleInfo> vehicles = new ArrayList<>();

        for (File f : file.listFiles()) {
            if (f.getName().endsWith(".json")) {
                try {
                    ObjectMapper mapper = new ObjectMapper();
                    VehicleInfo vi = mapper.readValue(f, VehicleInfo.class);
                    vehicles.add(vi);
                } catch (FileNotFoundException ex) {
                    System.out.println("Could not find file *" + f + "*");
                    ex.printStackTrace();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }

        Double totalOdometer = 0.0;
        Double totalConsumption = 0.0;
        Double totalOdometerAtLastOilChange = 0.0;
        Double totalEngineSize = 0.0;
        Double totalMPG = 0.0;

        Double averageOdometer = 0.0;
        Double averageConsumption = 0.0;
        Double averageOdometerAtLastOilChange = 0.0;
        Double averageEngineSize = 0.0;
        Double averageMPG = 0.0;

        for( VehicleInfo vehicle: vehicles ) {
            totalOdometer += vehicle.getOdometer();
            totalConsumption += vehicle.getConsumption();
            totalOdometerAtLastOilChange += vehicle.getOdometerSenseLastOilChange();
            totalEngineSize += vehicle.getEngineSize();
            totalMPG += vehicle.calculateMilesPerGallon();
        }

        averageOdometer = totalOdometer / vehicles.size();
        averageConsumption = totalConsumption / vehicles.size();
        averageOdometerAtLastOilChange = totalOdometerAtLastOilChange / vehicles.size();
        averageEngineSize = totalEngineSize / vehicles.size();
        averageMPG = totalMPG / vehicles.size();

        file = new File ("index.template");
        String fileContents = new String();
        try {
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNext()) {
                fileContents += fileScanner.nextLine() + "\n";
            }
        }
        catch (FileNotFoundException ex) {
            System.out.println("Could not find file *" + file + "*");
            ex.printStackTrace();
        }

        DecimalFormat df = new DecimalFormat("#.#");
        fileContents = fileContents.replace("numVehicles", String.valueOf(vehicles.size()));
        fileContents = fileContents.replace("aveOdometer", df.format(averageOdometer).toString());
        fileContents = fileContents.replace("aveConsumption", df.format(averageConsumption).toString());
        fileContents = fileContents.replace("aveLastOilChange", df.format(averageOdometerAtLastOilChange).toString());
        fileContents = fileContents.replace("aveEngineSize", df.format(averageEngineSize).toString());
        fileContents = fileContents.replace("aveMPG", df.format(averageMPG).toString());

        String vehicleDataRows = "";

        for( VehicleInfo vehicle: vehicles ) {
            vehicleDataRows += "<tr>";
            vehicleDataRows += "<td>" + vehicle.getDateOfService() + "</td>";
            vehicleDataRows += "<td>" + df.format(vehicle.getVIN()) + "</td>";
            vehicleDataRows += "<td>" + df.format(vehicle.getOdometer()) + "</td>";
            vehicleDataRows += "<td>" + df.format(vehicle.getConsumption()) + "</td>";
            vehicleDataRows += "<td>" + df.format(vehicle.getOdometerSenseLastOilChange()) + "</td>";
            vehicleDataRows += "<td>" + df.format(vehicle.getEngineSize()) + "</td>";
            vehicleDataRows += "<td>" + df.format(vehicle.calculateMilesPerGallon()) + "</td>";
            vehicleDataRows += "</tr>";
        }

        fileContents = fileContents.replace("vehicleDataRows", vehicleDataRows);

        filename = "index.html";
        newFile = new File(filename);

        try {
            FileWriter fileWriter = new FileWriter(newFile);
            fileWriter.write(fileContents);
            fileWriter.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

