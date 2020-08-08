package viewPackage;

import controllerPackage.SearchesController;
import controllerPackage.TrainingController;
import exceptionPackage.SearchAccessException;
import exceptionPackage.TrainingAccessException;
import modelPackage.*;
import utils.Constants;
import utils.Formating;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;

public class TrainingGroupSelectionPanel extends JPanel {

    private TrainingController controller;
    private SearchesController searchesController;
    private MainWindow parent;
    private AllAffiliatesTrainingModel model;
    private JLabel trainingGroupLabel, titleLabel, seasonLabel, trainingGroupValidationLabel;
    private JButton selectButton, closeButton;
    private JComboBox trainingGroupComboBox;
    private JTable table;
    private JScrollPane scrollPane;
    private Formating formatingHelper;
    private JPanel tablePanel,topPanel, bottomPanel, comboPanel;
    private int lastYear, currentYear;

    public TrainingGroupSelectionPanel(MainWindow parent){

        setLayout(new BorderLayout());
        this.parent = parent;
        controller = new TrainingController();
        searchesController = new SearchesController();

        // *****************************
        // TOP
        //*****************************

        topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(5,1,2,5));
        titleLabel = new JLabel("Affiliates according a training group");
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

        trainingGroupLabel = new JLabel("Training groups :");
        trainingGroupLabel.setHorizontalAlignment(SwingConstants.LEFT);
        comboPanel.add(trainingGroupLabel);

        try {
            trainingGroupComboBox = new JComboBox(controller.getAllTrainingGroups().toArray());
            trainingGroupComboBox.setSelectedIndex(-1);
            trainingGroupComboBox.setMaximumRowCount(5);
            comboPanel.add(trainingGroupComboBox);
        } catch (TrainingAccessException e) {
            e.printStackTrace();
        }

        trainingGroupValidationLabel = new JLabel(Constants.EMPTY_STRING);
        trainingGroupValidationLabel.setHorizontalAlignment(SwingConstants.LEFT);
        trainingGroupValidationLabel.setForeground(Color.RED);
        comboPanel.add(trainingGroupValidationLabel);

        selectButton = new JButton("Select");
        selectButton.addActionListener(new SelectListener());
        comboPanel.add(selectButton);


        // third fourth and fifth row in the top panel
        topPanel.add(comboPanel);
        topPanel.add(new JLabel(Constants.EMPTY_STRING));
        topPanel.add(new JLabel(Constants.EMPTY_STRING));


        add(topPanel, BorderLayout.NORTH);

        // *****************************
        // CONTENT
        //*****************************

        model = new AllAffiliatesTrainingModel(new ArrayList<AffiliateInTraining>()) ;
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

    public void reset() {

        trainingGroupComboBox.setSelectedIndex(-1);
        model.setContents(new ArrayList<AffiliateInTraining>());
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

            TrainingGroup trainingGroup = (TrainingGroup) trainingGroupComboBox.getSelectedItem();

            if(trainingGroup == null){
                trainingGroupValidationLabel.setText("please choose a training group !!!");
            }
            else{
                // obtain current Year
                Calendar c = Calendar.getInstance();
                int currentYear  = c.get(Calendar.YEAR);
                int currentMonth = c.get(Calendar.MONTH);
                int currentSeason;
                // new table tennis season begins in SEPTEMBER !
                if(currentMonth < Calendar.SEPTEMBER) currentSeason = currentYear - 1;
                else currentSeason = currentYear;

                try {
                    model.setContents(searchesController.getAllAffiliatesInTraining(trainingGroup.getTrainingGroupID(),currentSeason));
                    model.fireTableDataChanged();
                } catch (SearchAccessException searchAccessException) {
                    searchAccessException.printStackTrace();
                }
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
