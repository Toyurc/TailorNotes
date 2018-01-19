package pages;

import dao.CustomerDAO;
import pojo.CustomerObject;
import utils.Constants;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class SearchDialog extends JFrame {

    private final JPanel contentPanel = new JPanel();
    private JTable table;
    private JTextField textField;
    private CustomerDAO customerDAO;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            SearchDialog dialog = new SearchDialog();
            dialog.refreshCustomersView();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog.
     */
    public SearchDialog() {
        setBounds(100, 100, 1024, 768);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setLayout(new FlowLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);

        table = new JTable();
        contentPanel.add(table);

        try {
            customerDAO = new CustomerDAO();
        } catch (Exception exc) {
            JOptionPane.showMessageDialog(this, Constants.ERROR_ + exc, Constants.ERROR, JOptionPane.ERROR_MESSAGE);
        }

        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);

        JButton update = new JButton("Update");
        update.addActionListener((ActionEvent arg0) -> {

            // get the selected item
            int row = table.getSelectedRow();

            // make sure a row is selected
            if (row < 0) {
                JOptionPane.showMessageDialog(SearchDialog.this, Constants.SELECT_CUSTOMER, Constants.ERROR,
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            // get the current employee
            CustomerObject someCustomerObject = (CustomerObject) table.getValueAt(row, Constants.OBJECT_COL);

            // create dialog
            NewCustomer newCustomerDialog = new NewCustomer(SearchDialog.this, customerDAO,
                    someCustomerObject, true);
            // show newCustomerDialog
            newCustomerDialog.setVisible(true);
            newCustomerDialog.setSize(500, 555);
        });

        JButton bttnSearch = new JButton("Search");
        bttnSearch.addActionListener((ActionEvent arg0) -> {

            try {
                String lastName = textField.getText();

                List<CustomerObject> customerObject = null;

                if (lastName != null && lastName.trim().length() > 0) {
                    customerObject = customerDAO.searchCustomer(lastName);
                } else {
                    customerObject = customerDAO.getAllCustomers();
                }

                // create the model and update the "table"
                CustomerTableModel model = new CustomerTableModel(customerObject);

                table.setModel(model);

            } catch (Exception exc) {
                JOptionPane.showMessageDialog(SearchDialog.this, Constants.ERROR_ + exc, Constants.ERROR, JOptionPane.ERROR_MESSAGE);
            }
        });

        JLabel lblLastName = new JLabel("Last Name:");
        buttonPane.add(lblLastName);

        textField = new JTextField();
        buttonPane.add(textField);
        textField.setColumns(10);

        buttonPane.add(bttnSearch);

        JButton btnDelete = new JButton("Delete");
        btnDelete.addActionListener((ActionEvent arg0) -> {

            try {
                // get the selected row
                int row = table.getSelectedRow();

                // make sure a row is selected
                if (row < 0) {
                    JOptionPane.showMessageDialog(SearchDialog.this,
                            Constants.SELECT_CUSTOMER, Constants.ERROR, JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // prompt the user
                int response = JOptionPane.showConfirmDialog(
                        SearchDialog.this, Constants.DELETE_CUSTOMER, "Confirm",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                if (response != JOptionPane.YES_OPTION) {
                    return;
                }

                // get the current employee
                CustomerObject someCustomerObject = (CustomerObject) table.getValueAt(row, Constants.OBJECT_COL);

                // delete the employee
                customerDAO.deleteCustomer(someCustomerObject.getId());

                // refresh GUI
                refreshCustomersView();

                // show success message
                JOptionPane.showMessageDialog(SearchDialog.this,
                        "Customer deleted Successfully.", "Employee Deleted",
                        JOptionPane.INFORMATION_MESSAGE);

            } catch (Exception exc) {
                JOptionPane.showMessageDialog(SearchDialog.this,
                        "Error deleting Customer: " + exc.getMessage(), "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        });
        buttonPane.add(btnDelete);

        update.setActionCommand("OK");
        buttonPane.add(update);
        getRootPane().setDefaultButton(update);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener((ActionEvent arg0) -> {
            setVisible(false);
            dispose();
        });
        cancelButton.setActionCommand("Cancel");
        buttonPane.add(cancelButton);

    }

    public void refreshCustomersView() {

        try {
            List<CustomerObject> someCustomerObject = customerDAO.getAllCustomers();

            // create the model and update the "table"
            CustomerTableModel model = new CustomerTableModel(someCustomerObject);

            table.setModel(model);
        } catch (Exception exc) {
            JOptionPane.showMessageDialog(this, "Error: " + exc, "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
