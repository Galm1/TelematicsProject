package com.company;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;


public class TelematicsService {

    public void report(VehicleInfo vehicleInfo) throws IOException {

        String filename = vehicleInfo.getVIN() + ".json";
        File newFile = new File(filename);

        Date currentDate = new Date();
        vehicleInfo.setOdometerSenseLastOilChange(currentDate);

    }
}

