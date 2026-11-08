package parkingapp;

import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ParkingApp extends javax.swing.JFrame {

    private final CustomDoublyLinkedList parkingList = new CustomDoublyLinkedList();
    private DefaultTableModel tableModel;
    private DefaultComboBoxModel<String> typeModel;

    public ParkingApp() {
        initComponents();

        tableModel = (DefaultTableModel) tableRecords.getModel();
        typeModel = (DefaultComboBoxModel<String>) cbType.getModel();
        setLocationRelativeTo(null);

        parkingList.add(new Car("ABC-1234", "John Doe", "A-01", "Sedan - Blue"));
        parkingList.add(new Motorcycle("XYZ-9876", "Jane Smith", "B-12", "150cc Helmet Included"));
        parkingList.add(new CustomVehicle("TRK-5555", "Mark Wilson", "C-09", "Truck", "Heavy Duty"));

        refreshTableData(parkingList.toArray());
    }

