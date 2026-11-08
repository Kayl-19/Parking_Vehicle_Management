package parkingapp;

/**
 * Plain-Java console check for CustomDoublyLinkedList (no JUnit needed).
 *
 * Compile: javac -d out parkingApp/src/parkingapp/ParkingData.java parkingApp/test/parkingapp/LinkedListCheck.java
 * Run:     java -cp out parkingapp.LinkedListCheck
 */
public class LinkedListCheck {

    private static int failures = 0;

    private static void check(String name, boolean ok) {
        System.out.println((ok ? "PASS  " : "FAIL  ") + name);
        if (!ok) {
            failures++;
        }
    }

    private static CustomDoublyLinkedList sampleList() {
        CustomDoublyLinkedList list = new CustomDoublyLinkedList();
        list.add(new Car("ABC-1234", "John Doe", "A-01", "Sedan"));
        list.add(new Motorcycle("XYZ-9876", "Jane Smith", "B-12", "150cc"));
        list.add(new CustomVehicle("TRK-5555", "Mark Wilson", "C-09", "Truck", "Heavy"));
        return list;
    }

    private static void checkAddAndArray() {
        CustomDoublyLinkedList list = new CustomDoublyLinkedList();
        check("new list is empty", list.getSize() == 0 && list.toArray().length == 0);

        list = sampleList();
        Vehicle[] all = list.toArray();
        check("add() increases size to 3", list.getSize() == 3);
        check("toArray() keeps insertion order",
                all[0].getPlateNumber().equals("ABC-1234")
                && all[1].getPlateNumber().equals("XYZ-9876")
                && all[2].getPlateNumber().equals("TRK-5555"));
        check("vehicle types come from subclasses",
                all[0].getVehicleType().equals("Car")
                && all[1].getVehicleType().equals("Motorcycle")
                && all[2].getVehicleType().equals("Truck"));
    }

    public static void main(String[] args) {
        checkAddAndArray();
        finish();
    }

    private static void finish() {
        System.out.println(failures == 0 ? "All checks passed." : failures + " check(s) failed.");
        if (failures > 0) {
            System.exit(1);
        }
    }
}
