package parkingapp;

abstract class Vehicle {
    private String plateNumber;
    private String ownerName;
    private String spotId;
    private String notes;
    private long entryTime = System.currentTimeMillis();

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

    public long getEntryTime() { return entryTime; }
    public void setEntryTime(long entryTime) { this.entryTime = entryTime; }

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

class CustomDoublyLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public CustomDoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void add(Vehicle vehicle) {
        Node newNode = new Node(vehicle);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    public boolean removeByPlate(String plateNumber) {
        if (head == null || plateNumber == null || plateNumber.trim().isEmpty()) {
            return false;
        }

        Node current = head;
        while (current != null) {
            if (current.data != null && current.data.getPlateNumber() != null &&
                current.data.getPlateNumber().equalsIgnoreCase(plateNumber.trim())) {

                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next;
                }

                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev;
                }

                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public Vehicle search(String query) {
        if (head == null || query == null || query.trim().isEmpty()) {
            return null;
        }

        String cleanQuery = query.trim();
        Node current = head;
        while (current != null) {
            if (current.data != null) {
                if ((current.data.getPlateNumber() != null && current.data.getPlateNumber().equalsIgnoreCase(cleanQuery)) ||
                    (current.data.getSpotId() != null && current.data.getSpotId().equalsIgnoreCase(cleanQuery)) ||
                    (current.data.getOwnerName() != null && current.data.getOwnerName().equalsIgnoreCase(cleanQuery)) ||
                    (current.data.getVehicleType() != null && current.data.getVehicleType().equalsIgnoreCase(cleanQuery))) {
                    return current.data;
                }
            }
            current = current.next;
        }
        return null;
    }

    public Vehicle[] toArray() {
        Vehicle[] array = new Vehicle[size];
        Node current = head;
        int index = 0;
        while (current != null) {
            array[index++] = current.data;
            current = current.next;
        }
        return array;
    }

    public int getSize() {
        return size;
    }
}
