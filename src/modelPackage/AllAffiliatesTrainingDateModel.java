package modelPackage;

import javax.swing.table.AbstractTableModel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class AllAffiliatesTrainingDateModel extends AbstractTableModel {
    private ArrayList<String> columnNames;
    private ArrayList<AffiliateInTrainingBirthDate> contents;

    public AllAffiliatesTrainingDateModel(ArrayList<AffiliateInTrainingBirthDate> affiliateInTrainingsBirthDate){
        columnNames = new ArrayList<>();
        columnNames.add("Firstname");
        columnNames.add("Lastname");
        columnNames.add("Birth date");
        columnNames.add("play competition");
        columnNames.add("Phone");
        columnNames.add("Ranking name");
        contents = affiliateInTrainingsBirthDate;
    }

    public void setContents(ArrayList<AffiliateInTrainingBirthDate> contents) {
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
        AffiliateInTrainingBirthDate affiliateInTrainingBirthDate = contents.get(rowIndex);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        switch (columnIndex){
            case 0 : return affiliateInTrainingBirthDate.getFirstName();
            case 1 : return affiliateInTrainingBirthDate.getLastName();
            case 2 : return dateFormat.format(affiliateInTrainingBirthDate.getBirthDate().getTime());
            case 3 : return affiliateInTrainingBirthDate.getPlayCompetition();
            case 4 :{
                if (affiliateInTrainingBirthDate.getPhone() != null){
                    return affiliateInTrainingBirthDate.getPhone();
                }
                else {
                    return null;
                }
            }
            case 5 :return affiliateInTrainingBirthDate.getRankingName();
            default: return null;

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
            case 2 : c = String.class;
                break;
            case 3 : c = Boolean.class;
                break;
            case  4 : c= String.class;
                break;
            default: c= String.class;
        }
        return c;
    }





}
