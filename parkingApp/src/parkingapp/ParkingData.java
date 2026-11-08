package parkingapp;

abstract class Vehicle {
    private String plateNumber;
    private String ownerName;
    private String spotId;
    private String notes;

    public Vehicle(String plateNumber, String ownerName, String spotId, String notes) {
        this.plateNumber = plateNumber;
        this.ownerName = ownerName;
        this.spotId = spotId;
        this.notes = notes;
    }

