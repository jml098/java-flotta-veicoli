package org.java.vehiclefleet;

import org.java.vehiclefleet.exceptions.LicensePlateConflictException;
import org.java.vehiclefleet.exceptions.VehicleNotFoundException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Prompt prompt = new Prompt(new Scanner(System.in));
        FleetManager fleetManager = new FleetManager();

        boolean exit = false;
        while (!exit) {

            int choice = prompt.askInt(
                    "Choose option:" +
                            "\n -1 Add vehicle." +
                            "\n -2 Get info about vehicle." +
                            "\n -3 Count vehicles." +
                            "\n -4 Exit.\n");


            switch (choice) {
                case 1 -> {
                    Vehicle vehicle = null;
                    int licensePlateNumber = prompt.askInt("Insert license plate number: ");
                    int registrationYear = prompt.askInt("Insert registration year: ");

                    String type = prompt.ask("Which type? (Car/Motorcycle): ");

                    switch (type) {
                        case "Car" -> {
                            int numberOfDoors = prompt.askInt("Insert number of doors: ");
                            vehicle = new Car(licensePlateNumber, registrationYear, numberOfDoors);
                        }
                        case "Motorcycle" -> {
                            boolean hasStand = prompt.ask("Has it a stand?: ").equalsIgnoreCase("yes");
                            vehicle = new Motorcycle(licensePlateNumber, registrationYear, hasStand);
                        }
                        default -> System.out.println("No such type.");
                    }

                    if (vehicle != null) {
                        try {
                            fleetManager.add(vehicle);
                            System.out.println(vehicle + " has been added!");
                        } catch (LicensePlateConflictException e) {
                            System.out.println(e.getMessage());
                        }
                    }

                }
                case 2 -> {
                    try {
                        Vehicle vehicle = fleetManager.getByLicensePlateNumber(
                                prompt.askInt("Insert license plate."));

                        System.out.println("Info about the vehicle: " + vehicle);
                    } catch (VehicleNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 3 -> {
                    String type = prompt.ask("Insert vehicle type: (Car/Motorcycle)");
                    int count = fleetManager.countByType(type);
                    System.out.println("There are " + count + " " + type + "s");
                }
                case 4 -> {
                    exit = true;
                }
            }
        }


        for (Vehicle v : fleetManager.getAllVehicles()) {
            System.out.println(v);
        }
    }
}
