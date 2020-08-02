package viewPackage;

import controllerPackage.RankingController;
import controllerPackage.SearchesController;
import exceptionPackage.RankingAccessException;
import exceptionPackage.SearchAccessException;
import modelPackage.*;
import utils.Formating;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;

public class AvailableWeekPanel extends JPanel {

    private RankingController rankingController;
    private SearchesController searchesController;
    private MainWindow parent;
    private AllAffiliatesAvailableWeek model;
    private JLabel rankingLabel, weekLabel, titleLabel, seasonLabel, weekValidationLabel, rankingValidationLabel;
    private JButton selectButton, closeButton;
    private JComboBox rankingComboBox, weekComboBox;
    private JTable table;
    private JScrollPane scrollPane;
    private JPanel tablePanel, topPanel, comboPanel, bottomPanel;
    private Formating formatingHelper;
    private int lastYear, currentYear;



    public AvailableWeekPanel(MainWindow parent){

        this.parent = parent;

        setLayout(new BorderLayout());
        this.parent = parent;
        rankingController = new RankingController();
        searchesController = new SearchesController();

        // *****************************
        // TOP
        //*****************************

        topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(5,1,2,5));
        titleLabel = new JLabel("Available affiliates of a ranking for a week competition");
        formatingHelper = new Formating();
        formatingHelper.formatTitleLabel(titleLabel);
        // first row in the top panel
        topPanel.add(titleLabel);

        setCurrentSeason();
        seasonLabel = new JLabel("Season " + lastYear + "-" + currentYear);
        formatingHelper.formatTitleLabel(seasonLabel);
        // second row in the top panel
        topPanel.add(seasonLabel);


        comboPanel = new JPanel();
        comboPanel.setLayout(new FlowLayout());

        rankingLabel = new JLabel("Ranking :");
        rankingLabel.setHorizontalAlignment(SwingConstants.LEFT);
        comboPanel.add(rankingLabel);

        try {
            rankingComboBox = new JComboBox(rankingController.getAllRankings().toArray());
            rankingComboBox.setMaximumRowCount(5);
            comboPanel.add(rankingComboBox);
        } catch (RankingAccessException e) {
            e.printStackTrace();
        }

        rankingValidationLabel = new JLabel("");
        rankingValidationLabel.setHorizontalAlignment(SwingConstants.LEFT);
        rankingValidationLabel.setForeground(Color.RED);
        comboPanel.add(rankingValidationLabel);

        weekLabel = new JLabel("Week :");
        weekLabel.setHorizontalAlignment(SwingConstants.LEFT);
        comboPanel.add(weekLabel);


        String[]weeks = {"1","2","3","4", "5", "7", "8", "9","10","11","12","13","14","15","16","17","18","19","20","21","22"};
        weekComboBox = new JComboBox(weeks);
        weekComboBox.setMaximumRowCount(5);
        comboPanel.add(weekComboBox);

        weekValidationLabel = new JLabel("");
        weekValidationLabel.setHorizontalAlignment(SwingConstants.LEFT);
        weekValidationLabel.setForeground(Color.RED);
        comboPanel.add(weekValidationLabel);


        selectButton = new JButton("Select");
        selectButton.addActionListener(new SelectListener());
        comboPanel.add(selectButton);


        // third fourth and fifth row in the top panel
        topPanel.add(comboPanel);
        topPanel.add(new JLabel(""));
        topPanel.add(new JLabel(""));


        add(topPanel, BorderLayout.NORTH);

        // *****************************
        // CONTENT
        //*****************************

        model = new AllAffiliatesAvailableWeek(new ArrayList<AffiliateAvailableWeek>());
        table = new JTable(model);
        scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);


        // *****************************
        // BOTTOM
        //*****************************

        bottomPanel = new JPanel();
        closeButton = new JButton("Close");
        closeButton.addActionListener(new CloseListener());
        bottomPanel.add(closeButton);

        add(bottomPanel, BorderLayout.SOUTH);
    }

    public void reset(){
        rankingComboBox.setSelectedIndex(-1);
        weekComboBox.setSelectedIndex(-1);
        model.setContents(new ArrayList<AffiliateAvailableWeek>());
        model.fireTableDataChanged();
    }

    private void setCurrentSeason(){
        Calendar c = Calendar.getInstance();
        int currentMonth = c.get(Calendar.MONTH);
        this.lastYear  = c.get(Calendar.YEAR)-1;
        this.currentYear = c.get(Calendar.YEAR);

        // new table tennis season begins in SEPTEMBER !
        if(currentMonth >= Calendar.SEPTEMBER){
            this.lastYear = this.currentYear;
            this.currentYear++;
        }
    }

    private class SelectListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(tablePanel != null) remove(tablePanel);
            Ranking ranking = (Ranking) rankingComboBox.getSelectedItem();
            int weekNumber;
            try{
                weekNumber = Integer.parseInt((String) weekComboBox.getSelectedItem());
            } catch (NumberFormatException numberFormatException) {
                weekNumber = -1;
            }

            if(weekNumber != -1 && ranking != null){
                Calendar c = Calendar.getInstance();
                int currentYear = c.get(Calendar.YEAR);
                int currentMonth = c.get(Calendar.MONTH);
                int currentSeason;
                // new table tennis season begins in SEPTEMBER !
                if (currentMonth < Calendar.SEPTEMBER) currentSeason = currentYear - 1;
                else currentSeason = currentYear;

                try{
                    model.setContents(searchesController.getAllAffiliatesAvailableWeek(weekNumber, ranking.getName(), currentSeason));
                    model.fireTableDataChanged();
                }
                catch (SearchAccessException s){
                }
            }
            else{
                if(weekNumber == -1) weekValidationLabel.setText("please select a week!!");
                if(ranking == null) rankingValidationLabel.setText("please select ranking!!");
            }

        }
    }

    private class CloseListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            parent.closeCurrentForm();
        }
    }

}
