package pages;

import dao.CustomerDAO;
import pojo.CustomerObject;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.util.Date;

public class NewCustomer extends JDialog {

    private JTextField waisttf;
    private JTextField shouldertf;
    private JTextField busttf;
    private JTextField hiptf;
    private JTextField blousetf;
    private JTextField skirtlenttf;
    private JTextField gownlenttf;
    private JTextField acrossbacktf;
    private JTextField shoulderTowaisttf;
    private JTextField underbusttf;
    private JTextField bptf;
    private JTextField nptf;
    private JLabel lblHip;
    private JLabel lblShoulder;
    private JLabel lblBust;
    private JLabel lblBlouse;
    private JLabel lblSkirtLength;
    private JLabel lblGownLenght;
    private JLabel lblShoulderTo;
    private JLabel lblAcrossBack;
    private JLabel lblUnderbust;
    private JLabel lblBp;
    private JLabel lblNp;
    private JTextField fnametf;
    private JTextField lnametf;
    private JComboBox<String> typecboxtf;
    private JTextField addresstf;
    private JTextField descriptiontf;
    private JLabel lblDate;
    private JLabel lblDescription;
    private JTextField custIdtf;

    //declare date function
    JDateChooser colldate;
    Date collectDate;
    private CustomerDAO customerDAO;

    private SearchDialog theSearchDialog;
    private CustomerObject newCustomerObject = null;
    private boolean updateMode = false;

    /**
     * @param searchDialog
     * @param theCustomerDAO
     * @param someCustomerObject
     * @param theUpdateMode
     */
    public NewCustomer(SearchDialog searchDialog, CustomerDAO theCustomerDAO, CustomerObject someCustomerObject, boolean theUpdateMode) {
        this();
        customerDAO = theCustomerDAO;
        theSearchDialog = searchDialog;

        newCustomerObject = someCustomerObject;

        updateMode = theUpdateMode;

        if (updateMode) {
            setTitle("Update Employee");

            populateGui(newCustomerObject);
        }
    }

    /**
     * @param someCustomerObject
     */
    private void populateGui(CustomerObject someCustomerObject) {

        custIdtf.setText(String.valueOf(someCustomerObject.getId()));
        lnametf.setText(someCustomerObject.getLastName());
        fnametf.setText(someCustomerObject.getFirstName());
        addresstf.setText(someCustomerObject.getAddress());
        typecboxtf.setToolTipText(someCustomerObject.getType());
        colldate.setDate(someCustomerObject.getDate());
        descriptiontf.setText(someCustomerObject.getDescription());
        waisttf.setText(String.valueOf(someCustomerObject.getWaist()));
        hiptf.setText(String.valueOf(someCustomerObject.getHip()));
        shouldertf.setText(String.valueOf(someCustomerObject.getShoulder()));
        busttf.setText(String.valueOf(someCustomerObject.getBust()));
        blousetf.setText(String.valueOf(someCustomerObject.getBlouse()));
        skirtlenttf.setText(String.valueOf(someCustomerObject.getSkirtLength()));
        gownlenttf.setText(String.valueOf(someCustomerObject.getGownLength()));
        acrossbacktf.setText(String.valueOf(someCustomerObject.getAcrossBack()));
        underbusttf.setText(String.valueOf(someCustomerObject.getUnderBust()));
        shoulderTowaisttf.setText(String.valueOf(someCustomerObject.getShoulderToWaist()));
        bptf.setText(String.valueOf(someCustomerObject.getbp()));
        nptf.setText(String.valueOf(someCustomerObject.getnp()));

    }

    public NewCustomer() {
        super();
        setTitle("Add New Customer");
        getContentPane().setLayout(null);
        JButton save = new JButton("Save");
        save.addActionListener((ActionEvent arg0) -> saveEmployee());
        save.setBounds(35, 462, 89, 23);
        getContentPane().add(save);

        JButton clear = new JButton("Clear");
        clear.addActionListener((ActionEvent arg0) -> clear());
        clear.setBounds(179, 462, 89, 23);
        getContentPane().add(clear);

        JButton back = new JButton("Back");
        back.addActionListener((ActionEvent arg0) -> {
            setVisible(false);
            dispose();
        });
        back.setBounds(323, 462, 89, 23);
        getContentPane().add(back);

        waisttf = new JTextField();
        waisttf.setBounds(345, 42, 86, 20);
        getContentPane().add(waisttf);
        waisttf.setColumns(10);

        shouldertf = new JTextField();
        shouldertf.setColumns(10);
        shouldertf.setBounds(345, 104, 86, 20);
        getContentPane().add(shouldertf);

        busttf = new JTextField();
        busttf.setColumns(10);
        busttf.setBounds(345, 135, 86, 20);
        getContentPane().add(busttf);

        hiptf = new JTextField();
        hiptf.setColumns(10);
        hiptf.setBounds(345, 73, 86, 20);
        getContentPane().add(hiptf);

        blousetf = new JTextField();
        blousetf.setColumns(10);
        blousetf.setBounds(345, 164, 86, 20);
        getContentPane().add(blousetf);

        skirtlenttf = new JTextField();
        skirtlenttf.setColumns(10);
        skirtlenttf.setBounds(345, 195, 86, 20);
        getContentPane().add(skirtlenttf);

        gownlenttf = new JTextField();
        gownlenttf.setColumns(10);
        gownlenttf.setBounds(345, 226, 86, 20);
        getContentPane().add(gownlenttf);

        shoulderTowaisttf = new JTextField();
        shoulderTowaisttf.setColumns(10);
        shoulderTowaisttf.setBounds(345, 257, 86, 20);
        getContentPane().add(shoulderTowaisttf);

        acrossbacktf = new JTextField();
        acrossbacktf.setColumns(10);
        acrossbacktf.setBounds(345, 288, 86, 20);
        getContentPane().add(acrossbacktf);

        underbusttf = new JTextField();
        underbusttf.setColumns(10);
        underbusttf.setBounds(345, 319, 86, 20);
        getContentPane().add(underbusttf);

        bptf = new JTextField();
        bptf.setColumns(10);
        bptf.setBounds(345, 350, 86, 20);
        getContentPane().add(bptf);

        nptf = new JTextField();
        nptf.setColumns(10);
        nptf.setBounds(345, 381, 86, 20);
        getContentPane().add(nptf);

        JLabel lblWaist = new JLabel("Waist:");
        lblWaist.setToolTipText("Waist:");
        lblWaist.setBounds(273, 42, 66, 20);
        getContentPane().add(lblWaist);

        lblHip = new JLabel("Hip:");
        lblHip.setToolTipText("Hip:");
        lblHip.setBounds(273, 73, 66, 20);
        getContentPane().add(lblHip);

        lblShoulder = new JLabel("Shoulder:");
        lblShoulder.setToolTipText("Shoulder:");
        lblShoulder.setBounds(273, 104, 66, 20);
        getContentPane().add(lblShoulder);

        lblBust = new JLabel("Bust:");
        lblBust.setToolTipText("Bust:");
        lblBust.setBounds(273, 135, 66, 20);
        getContentPane().add(lblBust);

        lblBlouse = new JLabel("Blouse:");
        lblBlouse.setToolTipText("Blouse:");
        lblBlouse.setBounds(273, 164, 66, 20);
        getContentPane().add(lblBlouse);

        lblSkirtLength = new JLabel("Skirt Length:");
        lblSkirtLength.setToolTipText("Skirt Length:");
        lblSkirtLength.setBounds(273, 195, 66, 20);
        getContentPane().add(lblSkirtLength);

        lblGownLenght = new JLabel("Gown Length:");
        lblGownLenght.setToolTipText("Gown Length");
        lblGownLenght.setBounds(273, 226, 66, 20);
        getContentPane().add(lblGownLenght);

        lblShoulderTo = new JLabel("Shoulder To Waist: ");
        lblShoulderTo.setToolTipText("Shoulder To Waist: ");
        lblShoulderTo.setBounds(273, 257, 66, 20);
        getContentPane().add(lblShoulderTo);

        lblAcrossBack = new JLabel("Across Back:");
        lblAcrossBack.setToolTipText("Across Back: ");
        lblAcrossBack.setBounds(273, 288, 66, 20);
        getContentPane().add(lblAcrossBack);

        lblUnderbust = new JLabel("UnderBust:");
        lblUnderbust.setToolTipText("UnderBust:");
        lblUnderbust.setBounds(273, 319, 66, 20);
        getContentPane().add(lblUnderbust);

        lblBp = new JLabel("BP:");
        lblBp.setBounds(273, 350, 66, 20);
        getContentPane().add(lblBp);

        lblNp = new JLabel("NP:");
        lblNp.setBounds(273, 381, 66, 20);
        getContentPane().add(lblNp);

        fnametf = new JTextField();
        fnametf.setBounds(100, 42, 131, 20);
        getContentPane().add(fnametf);
        fnametf.setColumns(10);

        lnametf = new JTextField();
        lnametf.setColumns(10);
        lnametf.setBounds(100, 73, 131, 20);
        getContentPane().add(lnametf);

        typecboxtf = new JComboBox<>();
        typecboxtf.addItem("Shirt");
        typecboxtf.addItem("Blouse");
        typecboxtf.addItem("Trouser");
        typecboxtf.addItem("Skirt");
        typecboxtf.addItem("Gown");
        typecboxtf.addItem("Traditionals");
        typecboxtf.setBounds(100, 132, 131, 23);
        getContentPane().add(typecboxtf);

        JLabel lblFirstName = new JLabel("First Name:");
        lblFirstName.setBounds(10, 48, 80, 14);
        getContentPane().add(lblFirstName);

        JLabel lblLastName = new JLabel("Last Name:");
        lblLastName.setBounds(10, 76, 80, 14);
        getContentPane().add(lblLastName);

        JLabel lblAddress = new JLabel("Address:");
        lblAddress.setBounds(10, 107, 80, 14);
        getContentPane().add(lblAddress);

        JLabel lblType = new JLabel("Type:");
        lblType.setBounds(10, 138, 80, 14);
        getContentPane().add(lblType);

        addresstf = new JTextField();
        addresstf.setColumns(10);
        addresstf.setBounds(100, 104, 131, 20);
        getContentPane().add(addresstf);

        descriptiontf = new JTextField();
        descriptiontf.setColumns(10);
        descriptiontf.setBounds(100, 208, 131, 82);
        getContentPane().add(descriptiontf);

        lblDate = new JLabel("Collection Date:");
        lblDate.setBounds(10, 167, 80, 14);
        getContentPane().add(lblDate);

        lblDescription = new JLabel("Description:");
        lblDescription.setBounds(10, 229, 80, 14);
        getContentPane().add(lblDescription);

        colldate = new JDateChooser();
        colldate.setBounds(100, 167, 131, 20);
        getContentPane().add(colldate);

        custIdtf = new JTextField();
        custIdtf.setBounds(239, 11, 86, 20);
        getContentPane().add(custIdtf);
        custIdtf.setColumns(10);

        JLabel lblId = new JLabel("Customer ID:");
        lblId.setBounds(125, 14, 89, 14);
        getContentPane().add(lblId);

        colldate.addPropertyChangeListener("date", (PropertyChangeEvent event) -> collectDate = (Date) event.getNewValue());
    }

    protected void saveEmployee() {

        // get the employee info from gui
        int id = Integer.parseInt(custIdtf.getText());
        String lastName = lnametf.getText();
        String firstName = fnametf.getText();
        String address = addresstf.getText();
        String type = typecboxtf.getSelectedItem().toString();
        java.sql.Date collectionDay = new java.sql.Date(collectDate.getTime());
        String description = descriptiontf.getText();
        float waist = Float.parseFloat(waisttf.getText());
        float hip = Float.parseFloat(hiptf.getText());
        float shoulder = Float.parseFloat(shouldertf.getText());
        float bust = Float.parseFloat(busttf.getText());
        float blouse = Float.parseFloat(blousetf.getText());
        float skirtLength = Float.parseFloat(skirtlenttf.getText());
        float gownLength = Float.parseFloat(gownlenttf.getText());
        float acrossBack = Float.parseFloat(acrossbacktf.getText());
        float underBust = Float.parseFloat(underbusttf.getText());
        float shoulderToWaist = Float.parseFloat(shoulderTowaisttf.getText());
        float bp = Float.parseFloat(bptf.getText());
        float np = Float.parseFloat(nptf.getText());

        CustomerObject someCustomerObject;

        try {
            if (updateMode) {

                someCustomerObject = newCustomerObject;
                someCustomerObject.setId(id);
                someCustomerObject.setLastName(lastName);
                someCustomerObject.setFirstName(firstName);
                someCustomerObject.setAddress(address);
                someCustomerObject.setType(type);
                someCustomerObject.setDate(collectionDay);
                someCustomerObject.setDescription(description);
                someCustomerObject.setWaist(waist);
                someCustomerObject.setHip(hip);
                someCustomerObject.setShoulder(shoulder);
                someCustomerObject.setBust(bust);
                someCustomerObject.setBlouse(blouse);
                someCustomerObject.setSkirtLength(skirtLength);
                someCustomerObject.setGownLength(gownLength);
                someCustomerObject.setUnderBust(underBust);
                someCustomerObject.setShoulderToWaist(shoulderToWaist);
                someCustomerObject.setAcrossBack(acrossBack);
                someCustomerObject.setbp(bp);
                someCustomerObject.setnp(np);

            } else {
                someCustomerObject = new CustomerObject(
                        id,
                        lastName,
                        firstName,
                        address,
                        type,
                        collectionDay,
                        description,
                        waist,
                        hip,
                        shoulder,
                        bust,
                        blouse,
                        skirtLength,
                        gownLength,
                        underBust,
                        shoulderToWaist,
                        acrossBack,
                        bp,
                        np
                );
            }

            // save to the database
            if (updateMode) {
                customerDAO = new CustomerDAO();
                customerDAO.updateCustomer(someCustomerObject);
            } else {

                // save to the database
                customerDAO = new CustomerDAO();
                customerDAO.addCustomer(someCustomerObject);
            }

            // close dialog
            setVisible(false);

            dispose();

            // refresh gui list
            theSearchDialog = new SearchDialog();
            theSearchDialog.refreshCustomersView();

            // show success message
            JOptionPane.showMessageDialog(theSearchDialog,
                    "Customer saved successfully.", "Customer Saved",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception exc) {
            JOptionPane.showMessageDialog(theSearchDialog,
                    "Error saving Customer: " + exc.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }

    }

    private void clear() {

        custIdtf.setText("");
        lnametf.setText("");
        fnametf.setText("");
        addresstf.setText("");
        typecboxtf.setToolTipText("");
        colldate.setDate(null);
        descriptiontf.setText("");
        waisttf.setText("");
        hiptf.setText("");
        shouldertf.setText("");
        busttf.setText("");
        blousetf.setText("");
        skirtlenttf.setText("");
        gownlenttf.setText("");
        acrossbacktf.setText("");
        underbusttf.setText("");
        shoulderTowaisttf.setText("");
        bptf.setText("");
        nptf.setText("");
    }
}
		
