package com.company;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;


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
        Double totalCunsumption = 0.0;
        Double totalOdometerAtLastOilChange = 0.0;
        Double totalEngineSize = 0.0;
        Double totalMPG = 0.0;

        Double averageOdometer = 0.0;
        Double averageCunsumption = 0.0;
        Double averageOdometerAtLastOilChange = 0.0;
        Double averageEngineSize = 0.0;
        Double averageMPG = 0.0;

        for( VehicleInfo vehicle: vehicles ) {
            totalOdometer += vehicle.getOdometer();
            totalCunsumption += vehicle.getConsumption();
            totalOdometerAtLastOilChange += vehicle.getOdometerSenseLastOilChange();
            totalEngineSize += vehicle.getEngineSize();
            totalMPG += vehicle.calculateMilesPerGallon();
        }
    }
}

