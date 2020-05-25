package modelPackage;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class AllAffiliatesAvailableWeek extends AbstractTableModel {

    private ArrayList<String> columnNames;
    private ArrayList<AffiliateAvailableWeek> contents;


    public AllAffiliatesAvailableWeek(ArrayList<AffiliateAvailableWeek> affiliates){
        columnNames = new ArrayList<>();
        columnNames.add("Firstname");
        columnNames.add("Lastname");
        columnNames.add("Phone");
        contents = affiliates;
    }

    public void setContents(ArrayList<AffiliateAvailableWeek> contents) {
        this.contents = contents;
    }

    @Override
    public int getRowCount() {
        return contents.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.size();
    }

    public String getColumnName(int column){
        return columnNames.get(column);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        AffiliateAvailableWeek affiliate = contents.get(rowIndex);

        switch (columnIndex){
            case 0 : return affiliate.getFirstName();
            case 1 : return affiliate.getLastName();
            case 2 : if (affiliate.getPhone() != null){
                return affiliate.getPhone();
            }
            else {
                return null;
            }
            default : return null;
        }
    }

    @Override
    public Class getColumnClass(int columnIndex){
        Class c;
        switch (columnIndex){
            case 0 : c = String.class;
                break;
            case 1 : c = String.class;
                break;
            default : c = String.class;
        }
        return c;
    }


}
