package parkingapp;

abstract class Vehicle {
    private String plateNumber;
    private String ownerName;
    private String spotId;
    private String notes;
    private long entryTime = System.currentTimeMillis();
    private long exitTime = 0;
    private double fee = 0;

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

    public long getExitTime() { return exitTime; }
    public double getFee() { return fee; }
    public boolean isParked() { return exitTime == 0; }

    public void recordExit(long exitTime, double fee) {
        this.exitTime = exitTime;
        this.fee = fee;
    }

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

    public Vehicle findByPlate(String plateNumber) {
        if (head == null || plateNumber == null || plateNumber.trim().isEmpty()) {
            return null;
        }

        String cleanPlate = plateNumber.trim();
        Node current = head;
        while (current != null) {
            if (current.data != null && current.data.getPlateNumber() != null
                    && current.data.getPlateNumber().equalsIgnoreCase(cleanPlate)) {
                return current.data;
            }
            current = current.next;
        }
        return null;
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

class ParkingFee {
    public static final double CAR_RATE = 50.0;
    public static final double MOTORCYCLE_RATE = 30.0;
    public static final double OTHER_RATE = 70.0;

    public static double getHourlyRate(String vehicleType) {
        if ("Car".equalsIgnoreCase(vehicleType)) {
            return CAR_RATE;
        }
        if ("Motorcycle".equalsIgnoreCase(vehicleType)) {
            return MOTORCYCLE_RATE;
        }
        return OTHER_RATE;
    }

    // Every started hour is billed, with a minimum of one hour.
    public static long billableHours(long entryTime, long exitTime) {
        long millis = exitTime - entryTime;
        long hours = (millis + 3599999L) / 3600000L;
        return Math.max(1L, hours);
    }

    public static double calculate(String vehicleType, long entryTime, long exitTime) {
        return billableHours(entryTime, exitTime) * getHourlyRate(vehicleType);
    }

    public static String formatDuration(long entryTime, long exitTime) {
        long minutes = Math.max(0L, (exitTime - entryTime) / 60000L);
        return (minutes / 60) + " h " + (minutes % 60) + " min";
    }
}
