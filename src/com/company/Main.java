package com.company;

import java.util.Scanner;

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
        boolean inputFinished = false;
        int counter = 0;

        while(counter != prompt.length){
            System.out.println(prompt[counter]);
            String in = input.nextLine();
            counter++;
        }

    }
}
