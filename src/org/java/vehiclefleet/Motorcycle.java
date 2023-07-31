package org.java.vehiclefleet;

public class Motorcycle extends Vehicle {
    private boolean stand;

    public Motorcycle(int licensePlateNumber, int registrationYear, boolean stand) {
        super(licensePlateNumber, registrationYear);
        this.stand = stand;
    }


    public boolean hasStand() {
        return stand;
    }

    public void setStand(boolean stand) {
        this.stand = stand;
    }


    @Override
    public String toString() {
        String superString = super.toString();
        superString = superString.replace("Vehicle{", "");
        return "Motorcycle{" +
                "stand=" + stand + ", " +
                superString;
    }
}
