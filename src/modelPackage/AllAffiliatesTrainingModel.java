package modelPackage;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class AllAffiliatesTrainingModel extends AbstractTableModel {

    private ArrayList<String> columnNames;
    private ArrayList<AffiliateInTraining> contents;

    public AllAffiliatesTrainingModel(ArrayList<AffiliateInTraining> affiliateInTrainings){
        columnNames = new ArrayList<>();
        columnNames.add("Firstname");
        columnNames.add("Lastname");
        columnNames.add("Phone");
        columnNames.add("Ranking name");
        contents = affiliateInTrainings;
    }

    public void setContents(ArrayList<AffiliateInTraining> contents) {
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
        AffiliateInTraining affiliateInTraining = contents.get(rowIndex);

        switch(columnIndex){
            case 0 : return affiliateInTraining.getFirstName();
            case 1 : return affiliateInTraining.getLastName();
            case 2: {
                if (affiliateInTraining.getPhone() != null){
                    return affiliateInTraining.getPhone();
                }
                else {
                    return null;
                }
            }
            case 3 : return affiliateInTraining.getRankingName();
            default : return null;
        }
    }

    @Override
    public Class getColumnClass(int columnIndex){
        Class c;
        switch (columnIndex){
            case 0 : c =  String.class;
                break;
            case 1: c = String.class;
                break;
            case 2: c =  String.class;
                break;
            default: c =  String.class;

        }
        return c;
    }

}
