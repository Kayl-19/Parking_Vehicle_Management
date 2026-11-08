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

        lblStatus.setFont(new java.awt.Font("SansSerif", 1, 12));
        lblStatus.setText(" Status: Ready");
        searchPanel.add(lblStatus);

        getContentPane().add(searchPanel, java.awt.BorderLayout.NORTH);

        formPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Park New Vehicle"));
        formPanel.setLayout(new java.awt.GridBagLayout());

        lblPlate.setText("Plate Number:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        formPanel.add(lblPlate, gridBagConstraints);

        txtPlate.setColumns(12);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        formPanel.add(txtPlate, gridBagConstraints);

        lblOwner.setText("Owner Name:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        formPanel.add(lblOwner, gridBagConstraints);

        txtOwner.setColumns(12);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        formPanel.add(txtOwner, gridBagConstraints);

        lblSpot.setText("Spot ID:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        formPanel.add(lblSpot, gridBagConstraints);

        txtSpot.setColumns(12);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        formPanel.add(txtSpot, gridBagConstraints);

        lblType.setText("Vehicle Type:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        formPanel.add(lblType, gridBagConstraints);

        cbType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Car", "Motorcycle", "Truck", "+ Add New Type..." }));
        cbType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTypeActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        formPanel.add(cbType, gridBagConstraints);

        lblNotes.setText("Notes/Details:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        formPanel.add(lblNotes, gridBagConstraints);

        txtNotes.setColumns(12);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        formPanel.add(txtNotes, gridBagConstraints);

        btnAddType.setText("+ Manage/Add Vehicle Type");
        btnAddType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddTypeActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        formPanel.add(btnAddType, gridBagConstraints);

        btnAdd.setText("Park Vehicle");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        formPanel.add(btnAdd, gridBagConstraints);

        btnDelete.setText("Unpark Selected/Plate");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        formPanel.add(btnDelete, gridBagConstraints);

        getContentPane().add(formPanel, java.awt.BorderLayout.WEST);

        scrollRecords.setPreferredSize(new java.awt.Dimension(560, 420));

        tableRecords.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Plate Number", "Owner Name", "Spot ID", "Type", "Notes / Details"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollRecords.setViewportView(tableRecords);

        getContentPane().add(scrollRecords, java.awt.BorderLayout.CENTER);

        pack();
    }

    private void cbTypeActionPerformed(java.awt.event.ActionEvent evt) {
        String selected = (String) cbType.getSelectedItem();
        if (selected != null && selected.equals("+ Add New Type...")) {
            promptAddNewType();
        }
    }

    private void btnAddTypeActionPerformed(java.awt.event.ActionEvent evt) {
        promptAddNewType();
    }

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {
        addRecord();
    }

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {
        deleteRecord();
    }

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {
        performSearch();
    }

    private void btnShowAllActionPerformed(java.awt.event.ActionEvent evt) {
        refreshTableData(parkingList.toArray());
    }

    private void promptAddNewType() {
        String newType = JOptionPane.showInputDialog(this,
                "Enter new Vehicle Type (e.g., Van, Scooter, Bus):",
                "Add Vehicle Type", JOptionPane.QUESTION_MESSAGE);

        if (newType != null && !newType.trim().isEmpty()) {
            newType = newType.trim();

            for (int i = 0; i < typeModel.getSize(); i++) {
                if (typeModel.getElementAt(i).equalsIgnoreCase(newType)) {
                    cbType.setSelectedItem(typeModel.getElementAt(i));
                    return;
                }
            }

            int insertIndex = typeModel.getSize() - 1;
            typeModel.insertElementAt(newType, insertIndex);
            cbType.setSelectedItem(newType);
            lblStatus.setText(" Status: Added new vehicle type '" + newType + "'");
            lblStatus.setForeground(new Color(0, 128, 0));
        } else {
            cbType.setSelectedIndex(0);
        }
    }

    private void refreshTableData(Vehicle[] vehicles) {
        tableModel.setRowCount(0);
        for (Vehicle v : vehicles) {
            tableModel.addRow(new Object[]{
                v.getPlateNumber(),
                v.getOwnerName(),
                v.getSpotId(),
                v.getVehicleType(),
                v.getNotes()
            });
        }
    }

