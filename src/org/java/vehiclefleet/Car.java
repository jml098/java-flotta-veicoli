package org.java.vehiclefleet;

public class Car extends Vehicle{
    private int numberOfDoors;

    public Car(int licensePlateNumber, int registrationYear, int numberOfDoors) {
        super(licensePlateNumber, registrationYear);
        this.numberOfDoors = numberOfDoors;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }


    @Override
    public String toString() {
        String superString = super.toString();
        superString = superString.replace("Vehicle{", "");
        return "Car{" +
                "numberOfDoors=" + numberOfDoors + ", " +
                superString;
    }
}
