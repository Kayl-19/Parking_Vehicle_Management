# Parking Vehicle Management System

A Java desktop application for managing parked vehicles, built as a NetBeans project for IT20 (Data Structures and Algorithms) and IT24 (GUI programming).

## IT20: data structure

- `CustomDoublyLinkedList` is a doubly linked list written from scratch, without `java.util` collections.
- Records are found with a manual linear search by plate number, spot ID, owner name or vehicle type.
- `Vehicle` is an abstract class with `Car`, `Motorcycle` and `CustomVehicle` subclasses.

## Project layout

- `parkingApp/src/parkingapp/ParkingData.java`: vehicle classes and the linked list

## Checking the linked list

The linked list can be tested without the GUI:

```
javac -d out parkingApp/src/parkingapp/ParkingData.java parkingApp/test/parkingapp/LinkedListCheck.java
java -cp out parkingapp.LinkedListCheck
```

## IT24: GUI

`ParkingApp` is a Swing `JFrame` with a NetBeans form (`ParkingApp.form`), so its layout can be edited in the Design view.

- Park a vehicle with plate number, owner, spot ID, type and notes.
- Unpark by selecting a row in the table or typing a plate number.
- Search by plate, spot, owner or type, and use Show All to restore the full table.
- Add new vehicle types at runtime from the type combo box or the Manage/Add button.
- Required fields and invalid choices show validation dialogs, and the status label reports the last action.

## Running

Open the `parkingApp` folder as a project in NetBeans and run it. The main class is `parkingapp.ParkingApp`.
