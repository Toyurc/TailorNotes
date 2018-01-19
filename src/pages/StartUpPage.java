package pages;

import dao.CustomerDAO;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.View;
import java.awt.*;
import java.awt.event.ActionEvent;

public class StartUpPage extends JFrame {

    private JPanel contentPane;
    private JTable jTable;
    public CustomerDAO customerDAO;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                StartUpPage frame = new StartUpPage();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the frame.
     */

    public StartUpPage() {
        super("Welcome!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 520, 396);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        // create the DAO
        try {
            customerDAO = new CustomerDAO();
        } catch (Exception exc) {
            JOptionPane.showMessageDialog(this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE);
        }

        JButton update = new JButton("Search");
        update.setBounds(202, 322, 77, 23);
        update.addActionListener((ActionEvent arg0) -> {
            SearchDialog searchDialog = new SearchDialog();
            // show searchDialog
            searchDialog.setVisible(true);
            searchDialog.setSize(1080, 768);
            this.setVisible(false);
            dispose();
        });
        update.setToolTipText("Searches Customer Details");

        JButton exit = new JButton("Exit");
        exit.setBounds(367, 324, 77, 23);
        exit.addActionListener((ActionEvent arg0) -> System.exit(0));
        exit.setToolTipText("Close\r\n");
        contentPane.setLayout(null);
        contentPane.add(update);
        contentPane.add(exit);

        JButton nNew = new JButton("New");
        nNew.setBounds(39, 324, 77, 23);
        contentPane.add(nNew);
        nNew.setToolTipText("Adds New Customer");

        JPanel panel = new JPanel();
        panel.setBounds(10, 11, 474, 302);
        contentPane.add(panel);
        nNew.addActionListener((ActionEvent arg0) -> {
            // create dialog
            NewCustomer newCustomerDialog = new NewCustomer();
            // show newCustomerDialog
            newCustomerDialog.setVisible(true);
            newCustomerDialog.setSize(500, 555);
        });
    }
}
