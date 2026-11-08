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

class Car extends Vehicle {
    public Car(String plateNumber, String ownerName, String spotId, String notes) {
        super(plateNumber, ownerName, spotId, notes);
    }

    @Override
    public String getVehicleType() {
        return "Car";
    }
}

class Motorcycle extends Vehicle {
    public Motorcycle(String plateNumber, String ownerName, String spotId, String notes) {
        super(plateNumber, ownerName, spotId, notes);
    }

    @Override
    public String getVehicleType() {
        return "Motorcycle";
    }
}

class CustomVehicle extends Vehicle {
    private String customType;

    public CustomVehicle(String plateNumber, String ownerName, String spotId, String customType, String notes) {
        super(plateNumber, ownerName, spotId, notes);
        this.customType = customType;
    }

    @Override
    public String getVehicleType() {
        return customType;
    }
}

class Node {
    Vehicle data;
    Node prev;
    Node next;

    public Node(Vehicle data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

