package modelPackage;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class RankingsDialogModel extends AbstractTableModel {

    private ArrayList<String> columnNames;
    private ArrayList<RankingSeason> contents;

    public RankingsDialogModel(ArrayList<RankingSeason> rankings){
        columnNames = new ArrayList<>();
        columnNames.add("Season");
        columnNames.add("Ranking");
        contents = rankings;
    }

    public void setContents(ArrayList<RankingSeason> contents) {
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
        RankingSeason rankingSeason = contents.get(rowIndex);

        switch (columnIndex){
            case 0 : return rankingSeason.getSeason();
            case 1: return rankingSeason.getRankingName();
            default: return null;
        }
    }
    @Override
    public Class getColumnClass(int columnIndex){
        Class c;
        switch (columnIndex){
            default : c = Integer.class;
        }
        return c;
    }
}
