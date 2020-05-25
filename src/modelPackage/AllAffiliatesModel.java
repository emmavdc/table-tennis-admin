package modelPackage;

import javax.swing.table.AbstractTableModel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


public class AllAffiliatesModel extends AbstractTableModel {

    private ArrayList<String> columnNames;
    private ArrayList<Affiliate> contents;

    public AllAffiliatesModel(ArrayList<Affiliate> affiliates){
        columnNames = new ArrayList<>();
        columnNames.add("Affiliate Id");
        columnNames.add("Firstname");
        columnNames.add("Lastname");
        columnNames.add("Gender");
        columnNames.add("Birth date");
        columnNames.add("Phone");
        columnNames.add("Email");
        columnNames.add("Play competition");
        columnNames.add("Equipment");
        contents = affiliates;
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
        Affiliate affiliate = contents.get(rowIndex);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        switch (columnIndex){
            case 0 : return affiliate.getAffiliateID();
            case 1 : return affiliate.getFirstName();
            case 2 : return affiliate.getLastName();
            case 3 : return affiliate.getGender();
            case 4 : return dateFormat.format(affiliate.getBirthDate().getTime());
            case 5 : {
                if (affiliate.getPhone() != null){
                    return affiliate.getPhone();
                }
                else {
                    return null;
                }
            }
            case 6 : {
                if (affiliate.getEmail() != null){
                    return affiliate.getEmail();
                }
                else {
                    return null;
                }
            }
            case 7 : return affiliate.getPlayCompetition();
            case 8 : return affiliate.getEquipment();
            default : return null;
        }
    }

    @Override
    public Class getColumnClass(int columnIndex) {
        Class c;
        switch(columnIndex){
            case 0 : c = Integer.class;
                    break;
            case 1 : c = String.class;
                break;
            case 2 : c = String.class;
                break;
            case 3 : c = String.class;
                break;
            case 4 : c = String.class;
                break;
            case 5 : c = String.class;
                break;
            case 6 : c = String.class;
                break;
            case 7 : c = Boolean.class;
                break;
            default : c = Equipment.class;

        }
        return c;
    }


}
