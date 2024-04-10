package org.booking.core.entities;

public class Booking {
    private static int counter = 0;
    private final int id;
    private String clientName;
    private String carType;

    public Booking(String clientName, String carType) {
        this.id = counter + 1;
        this.clientName = clientName;
        this.carType = carType;
    }

    // getters and setters
    public int getId() {
        return id;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }
}