package org.java.vehiclefleet;

public abstract class Vehicle {
    private int licensePlateNumber;
    private int registrationYear;

    public Vehicle(int licensePlateNumber, int registrationYear) {
        this.licensePlateNumber = licensePlateNumber;
        this.registrationYear = registrationYear;
    }

    public int getLicensePlateNumber() {
        return licensePlateNumber;
    }

    public void setLicensePlateNumber(int licensePlateNumber) {
        this.licensePlateNumber = licensePlateNumber;
    }

    public int getRegistrationYear() {
        return registrationYear;
    }

    public void setRegistrationYear(int registrationYear) {
        this.registrationYear = registrationYear;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "licensePlateNumber=" + licensePlateNumber +
                ", registrationYear=" + registrationYear +
                '}';
    }
}
