package pages;

import pojo.CustomerObject;
import utils.Constants;

import javax.swing.table.AbstractTableModel;
import java.util.List;

class CustomerTableModel extends AbstractTableModel {

    private String[] columnNames = {
            "Last Name",
            "First Name",
            "Address",
            "Type",
            "Collection Day",
            "Description",
            "Waist",
            "Hip",
            "Shoulder",
            "Bust",
            "Skirt Length",
            "Gown Length",
            "Shoulder To Waist",
            "Across Back",
            "Bp",
            "Np"
    };
    private List<CustomerObject> newCustomerObject;


    public CustomerTableModel(List<CustomerObject> newCustomerObject) { this.newCustomerObject = newCustomerObject; }

    @Override
    public int getColumnCount() { return columnNames.length; }

    @Override
    public int getRowCount() { return newCustomerObject.size(); }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }

    @Override
    public Object getValueAt(int row, int col) {

        CustomerObject someCustomerObject = newCustomerObject.get(row);

        switch (col) {
            case Constants.LAST_NAME_COL:
                return someCustomerObject.getLastName();
            case Constants.FIRST_NAME_COL:
                return someCustomerObject.getFirstName();
            case Constants.ADDRESS_COL:
                return someCustomerObject.getAddress();
            case Constants.TYPE_COL:
                return someCustomerObject.getType();
            case Constants.COLLECTION_DAY_COL:
                return someCustomerObject.getDate();
            case Constants.DESCRIPTION_COL:
                return someCustomerObject.getDescription();
            case Constants.WAIST_COL:
                return someCustomerObject.getWaist();
            case Constants.HIP_COL:
                return someCustomerObject.getHip();
            case Constants.SHOULDER_COL:
                return someCustomerObject.getShoulder();
            case Constants.BUST_COL:
                return someCustomerObject.getBust();
            case Constants.BLOUSE_COL:
                return someCustomerObject.getBlouse();
            case Constants.SKIRT_LENGTH_COL:
                return someCustomerObject.getSkirtLength();
            case Constants.GOWN_LENGTH_COL:
                return someCustomerObject.getGownLength();
            case Constants.ACROSS_BACK_COL:
                return someCustomerObject.getAcrossBack();
            case Constants.UNDER_BUST_COL:
                return someCustomerObject.getUnderBust();
            case Constants.SHOULDER_TO_WAIST_COL:
                return someCustomerObject.getShoulderToWaist();
            case Constants.BP_COL:
                return someCustomerObject.getbp();
            case Constants.NP_COL:
                return someCustomerObject.getnp();
            case Constants.ID_COL:
                return someCustomerObject.getId();
            case Constants.OBJECT_COL:
                return someCustomerObject;
            default:
                return someCustomerObject.getLastName();
        }
    }

    @Override
    public Class getColumnClass(int c) { return getValueAt(0, c).getClass(); }
}
