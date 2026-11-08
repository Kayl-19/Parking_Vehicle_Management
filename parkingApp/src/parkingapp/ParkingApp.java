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

    @SuppressWarnings("unchecked")
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        searchPanel = new javax.swing.JPanel();
        lblSearch = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnShowAll = new javax.swing.JButton();
        lblStatus = new javax.swing.JLabel();
        formPanel = new javax.swing.JPanel();
        lblPlate = new javax.swing.JLabel();
        txtPlate = new javax.swing.JTextField();
        lblOwner = new javax.swing.JLabel();
        txtOwner = new javax.swing.JTextField();
        lblSpot = new javax.swing.JLabel();
        txtSpot = new javax.swing.JTextField();
        lblType = new javax.swing.JLabel();
        cbType = new javax.swing.JComboBox<>();
        lblNotes = new javax.swing.JLabel();
        txtNotes = new javax.swing.JTextField();
        btnAddType = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        scrollRecords = new javax.swing.JScrollPane();
        tableRecords = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Parking Vehicle Management System");

        searchPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Search Vehicle"));
        searchPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 10));

        lblSearch.setText("Plate / Spot / Owner / Type:");
        searchPanel.add(lblSearch);

        txtSearch.setColumns(15);
        searchPanel.add(txtSearch);

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        searchPanel.add(btnSearch);

        btnShowAll.setText("Show All");
        btnShowAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowAllActionPerformed(evt);
            }
        });
        searchPanel.add(btnShowAll);

