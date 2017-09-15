package com.company;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here


        Scanner input = new Scanner(System.in);

        String[] prompt =
                {
                        "VIN number",
                        "odometer number",
                        "gas consumption",
                        "odometer sense your last oil change",
                        "engine size in liters"
                };
        int counter = 0;

        String[] userIn = new String[5];

        while(counter != prompt.length){
            System.out.println(prompt[counter]);
            String in = input.nextLine();
            userIn.push(in);
            counter++;
        }

    }
}
