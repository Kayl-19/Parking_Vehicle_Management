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

    private void addRecord() {
        String plate = txtPlate.getText().trim();
        String owner = txtOwner.getText().trim();
        String spot = txtSpot.getText().trim();
        String selectedType = (String) cbType.getSelectedItem();
        String notes = txtNotes.getText().trim();

        if (selectedType == null || selectedType.equals("+ Add New Type...")) {
            JOptionPane.showMessageDialog(this, "Please select or add a valid vehicle type.",
                    "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (plate.isEmpty() || owner.isEmpty() || spot.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Plate Number, Owner Name, and Spot ID are required fields.",
                    "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (notes.isEmpty()) {
            notes = "N/A";
        }

        if (selectedType.equals("Car")) {
            parkingList.add(new Car(plate, owner, spot, notes));
        } else if (selectedType.equals("Motorcycle")) {
            parkingList.add(new Motorcycle(plate, owner, spot, notes));
        } else {
            parkingList.add(new CustomVehicle(plate, owner, spot, selectedType, notes));
        }

        refreshTableData(parkingList.toArray());
        clearInputs();
        lblStatus.setText(" Status: Parked " + selectedType + " (" + plate + ")");
        lblStatus.setForeground(new Color(0, 128, 0));
    }

    private void deleteRecord() {
        int selectedRow = tableRecords.getSelectedRow();
        String plateToRemove;

        if (selectedRow != -1) {
            plateToRemove = tableModel.getValueAt(selectedRow, 0).toString();
        } else {
            plateToRemove = txtPlate.getText().trim();
        }

        if (plateToRemove.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Select a row or enter a Plate Number to unpark.",
                    "Selection Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        boolean removed = parkingList.removeByPlate(plateToRemove);
        if (removed) {
            refreshTableData(parkingList.toArray());
            clearInputs();
            lblStatus.setText(" Status: Unparked Vehicle " + plateToRemove);
            lblStatus.setForeground(Color.BLUE);
        } else {
            JOptionPane.showMessageDialog(this, "Plate Number not found in system.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void performSearch() {
        String query = txtSearch.getText().trim();
        if (query.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter a search query.",
                    "Input Required", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Vehicle result = parkingList.search(query);
        if (result != null) {
            refreshTableData(new Vehicle[]{result});
            lblStatus.setText(" Status: Found vehicle '" + query + "'");
            lblStatus.setForeground(new Color(0, 128, 0));
        } else {
            tableModel.setRowCount(0);
            lblStatus.setText(" Status: No match found for '" + query + "'");
            lblStatus.setForeground(Color.RED);
        }
    }

    private void clearInputs() {
        txtPlate.setText("");
        txtOwner.setText("");
        txtSpot.setText("");
        txtNotes.setText("");
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ParkingApp().setVisible(true);
            }
        });
    }

    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAddType;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnShowAll;
    private javax.swing.JComboBox<String> cbType;
    private javax.swing.JPanel formPanel;
    private javax.swing.JLabel lblNotes;
    private javax.swing.JLabel lblOwner;
    private javax.swing.JLabel lblPlate;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JLabel lblSpot;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblType;
    private javax.swing.JScrollPane scrollRecords;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JTable tableRecords;
    private javax.swing.JTextField txtNotes;
    private javax.swing.JTextField txtOwner;
    private javax.swing.JTextField txtPlate;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtSpot;
}