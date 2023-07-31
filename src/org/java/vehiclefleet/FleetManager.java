package org.java.vehiclefleet;

import org.java.vehiclefleet.exceptions.LicensePlateConflictException;
import org.java.vehiclefleet.exceptions.VehicleNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class FleetManager {
    private final List<Vehicle> vehicles;

    public FleetManager() {
        this.vehicles = new ArrayList<>();
    }


    public List<Vehicle> getAllVehicles() {
        return vehicles;
    }

    public void add(Vehicle vehicle) throws LicensePlateConflictException {
        if (existsByLicensePlateNumber(vehicle.getLicensePlateNumber())) {
            throw new LicensePlateConflictException(
                    "There is already a vehicle with license plate number" +
                            vehicle.getLicensePlateNumber() +
                            " in this fleet.");
        }

        vehicles.add(vehicle);
    }

    public Vehicle getByLicensePlateNumber(int licensePlateNumber) throws VehicleNotFoundException {
        for (Vehicle v: vehicles) {
            if (v.getLicensePlateNumber() == licensePlateNumber) return v;
        }

        throw new VehicleNotFoundException(
                "There's no vehicle with license plate number " +
                        licensePlateNumber +
                        " in this fleet.");
    }

    public boolean existsByLicensePlateNumber(int licensePlateNumber) {
        for (Vehicle v: vehicles) {
            if (v.getLicensePlateNumber() == licensePlateNumber) return true;
        }

        return false;
    }

    public int countByType(String type) {
        int count = 0;
        for (Vehicle v: vehicles) {
            if (v.getClass().getSimpleName().equalsIgnoreCase(type)) count++;
        }
        return count;
    }
}
