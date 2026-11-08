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

    public String getPlateNumber() { return plateNumber; }
    public void setPlateNumber(String plateNumber) { this.plateNumber = plateNumber; }

    public String getOwnerName() { return ownerName; }
    public void setOwnerName(String ownerName) { this.ownerName = ownerName; }

    public String getSpotId() { return spotId; }
    public void setSpotId(String spotId) { this.spotId = spotId; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }

    public abstract String getVehicleType();
}

