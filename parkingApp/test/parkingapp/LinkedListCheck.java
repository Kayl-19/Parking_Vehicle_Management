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

    private static void checkRemove() {
        CustomDoublyLinkedList list = sampleList();
        check("remove middle node", list.removeByPlate("xyz-9876") && list.getSize() == 2);
        check("middle node is gone", list.search("XYZ-9876") == null);
        check("neighbours stay linked",
                list.toArray()[0].getPlateNumber().equals("ABC-1234")
                && list.toArray()[1].getPlateNumber().equals("TRK-5555"));

        check("remove head node", list.removeByPlate("ABC-1234") && list.getSize() == 1);
        check("remove tail node (last one)", list.removeByPlate("TRK-5555") && list.getSize() == 0);
        check("list is empty again", list.toArray().length == 0);

        list.add(new Car("NEW-0001", "Ann", "D-01", "Hatchback"));
        check("add() works after emptying the list", list.getSize() == 1);

        check("remove missing plate returns false", !list.removeByPlate("NOPE-000"));
        check("remove blank plate returns false", !list.removeByPlate("  "));
        check("remove null plate returns false", !list.removeByPlate(null));
    }

    private static void checkSearch() {
        CustomDoublyLinkedList list = sampleList();
        check("search by plate", list.search("abc-1234") != null);
        check("search by spot", list.search("B-12").getOwnerName().equals("Jane Smith"));
        check("search by owner", list.search("mark wilson").getPlateNumber().equals("TRK-5555"));
        check("search by type", list.search("Motorcycle").getPlateNumber().equals("XYZ-9876"));
        check("search with no match returns null", list.search("nothing") == null);
        check("search with blank query returns null", list.search("   ") == null);
        check("search on empty list returns null", new CustomDoublyLinkedList().search("ABC-1234") == null);
    }

    private static void checkExitRecord() {
        Vehicle v = new Car("EXI-0001", "Ann", "A-02", "Test");
        check("new vehicle is parked with no exit or fee", v.isParked() && v.getExitTime() == 0 && v.getFee() == 0);
        check("entry time is set on creation", v.getEntryTime() > 0);
        v.setEntryTime(5000L);
        check("entry time can be changed", v.getEntryTime() == 5000L);
        v.recordExit(9000L, 50.0);
        check("recordExit() stores exit time and fee", !v.isParked() && v.getExitTime() == 9000L && v.getFee() == 50.0);
    }

    private static void checkFindByPlate() {
        CustomDoublyLinkedList list = sampleList();
        check("findByPlate() ignores case", list.findByPlate("xyz-9876") != null);
        check("findByPlate() returns the matching vehicle", list.findByPlate("TRK-5555").getOwnerName().equals("Mark Wilson"));
        check("findByPlate() does not match an owner name", list.findByPlate("John Doe") == null);
        check("findByPlate() missing plate returns null", list.findByPlate("NOPE-000") == null);
        check("findByPlate() blank returns null", list.findByPlate("  ") == null);
        check("findByPlate() null returns null", list.findByPlate(null) == null);
        check("findByPlate() on empty list returns null", new CustomDoublyLinkedList().findByPlate("ABC-1234") == null);
    }

    public static void main(String[] args) {
        checkAddAndArray();
        checkRemove();
        checkSearch();
        checkExitRecord();
        checkFindByPlate();
        finish();
    }

    private static void finish() {
        System.out.println(failures == 0 ? "All checks passed." : failures + " check(s) failed.");
        if (failures > 0) {
            System.exit(1);
        }
    }
}
