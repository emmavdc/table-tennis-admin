package viewPackage;

import controllerPackage.SearchesController;
import controllerPackage.TrainingController;
import exceptionPackage.SearchAccessException;
import exceptionPackage.TrainingAccessException;
import modelPackage.AffiliateInTrainingBirthDate;
import modelPackage.AllAffiliatesTrainingDateModel;
import modelPackage.TrainingGroup;
import utils.Constants;
import utils.Formating;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class TrainingGroupDateSelectionPanel extends JPanel {

    private TrainingController controller;
    private SearchesController searchesController;
    private MainWindow parent;
    private AllAffiliatesTrainingDateModel model;
    private JLabel trainingGroupLabel, startDateLabel, endDateLabel, dateValidationLabel, titleLabel, seasonLabel, trainingGroupValidationLabel;
    private JButton selectButton, closeButton;
    private JComboBox trainingGroupComboBox;
    private JTable table;
    private JScrollPane scrollPane;
    private JFormattedTextField  startDateFormatted, endDateFormatted;
    private String startDate, endDate;
    private JPanel topPanel, comboPanel,bottomPanel;
    private Formating formatingHelper;
    private int lastYear, currentYear;


    public TrainingGroupDateSelectionPanel(MainWindow parent){
        this.parent = parent;

        setLayout(new BorderLayout());
        this.parent = parent;
        controller = new TrainingController();
        searchesController = new SearchesController();

        // *****************************
        // TOP
        //*****************************

        topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(5,1,2,5));
        titleLabel = new JLabel("Affiliates of an age group according a training group");
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

        startDateLabel = new JLabel("Start date :");
        startDateLabel.setHorizontalAlignment(SwingConstants.LEFT);
        comboPanel.add(startDateLabel);
        MaskFormatter startDateMask = null;
        try {
            startDateMask = new MaskFormatter("##/##/####");
            startDateMask.setPlaceholderCharacter('_');
        } catch (ParseException e) {
        }
        startDateFormatted = new JFormattedTextField(startDateMask);
        comboPanel.add(startDateFormatted);

        endDateLabel = new JLabel("End date :");
        endDateLabel.setHorizontalAlignment(SwingConstants.LEFT);
        comboPanel.add(endDateLabel);
        MaskFormatter endDateMask = null;
        try {
            endDateMask = new MaskFormatter("##/##/####");
            endDateMask.setPlaceholderCharacter('_');
        } catch (ParseException e) {
        }
        endDateFormatted = new JFormattedTextField(endDateMask);
        comboPanel.add(endDateFormatted);

        dateValidationLabel = new JLabel(Constants.EMPTY_STRING);
        dateValidationLabel.setHorizontalAlignment(SwingConstants.LEFT);
        dateValidationLabel.setForeground(Color.RED);
        comboPanel.add(dateValidationLabel);


        trainingGroupLabel = new JLabel("Training groups :");
        trainingGroupLabel.setHorizontalAlignment(SwingConstants.LEFT);
        comboPanel.add(trainingGroupLabel);
        controller = new TrainingController();
        searchesController = new SearchesController();

        try {
            trainingGroupComboBox = new JComboBox(controller.getAllTrainingGroups().toArray(new TrainingGroup[0]));
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
        model = new AllAffiliatesTrainingDateModel(new ArrayList<AffiliateInTrainingBirthDate>());
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
        model.setContents(new ArrayList<AffiliateInTrainingBirthDate>());
        model.fireTableDataChanged();
        startDateFormatted.setText(Constants.EMPTY_STRING);
        endDateFormatted.setText(Constants.EMPTY_STRING);

        dateValidationLabel.setText(Constants.EMPTY_STRING);
        trainingGroupValidationLabel.setText(Constants.EMPTY_STRING);

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

    private class SelectListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            startDate = startDateFormatted.getText();
            endDate = endDateFormatted.getText();
            dateValidationLabel.setText(Constants.EMPTY_STRING);
            trainingGroupValidationLabel.setText(Constants.EMPTY_STRING);

            GregorianCalendar gregorianStartDate;
            GregorianCalendar gregorianEndDate;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            try {
                gregorianStartDate = new GregorianCalendar();
                gregorianStartDate.setTime(simpleDateFormat.parse(startDateFormatted.getText()));
                gregorianEndDate = new GregorianCalendar();
                gregorianEndDate.setTime(simpleDateFormat.parse(endDateFormatted.getText()));
            } catch (ParseException dateException) {
                gregorianStartDate = null;
                gregorianEndDate = null;
            }
            TrainingGroup trainingGroup = (TrainingGroup) trainingGroupComboBox.getSelectedItem();

            if(gregorianStartDate != null && gregorianEndDate != null && trainingGroup != null){

                Calendar c = Calendar.getInstance();
                int currentYear = c.get(Calendar.YEAR);
                int currentMonth = c.get(Calendar.MONTH);
                int currentSeason;
                // new table tennis season begins in SEPTEMBER !
                if (currentMonth < Calendar.SEPTEMBER) currentSeason = currentYear - 1;
                else currentSeason = currentYear;

                try {
                    model.setContents(searchesController.getAllAffiliatesInTrainingAccordingBirthDate(trainingGroup.getTrainingGroupID(), currentSeason, startDate, endDate));
                    model.fireTableDataChanged();
                } catch (SearchAccessException searchAccessException) {
                    searchAccessException.printStackTrace();
                }
            }
            else {
                if(gregorianStartDate == null || gregorianEndDate == null) dateValidationLabel.setText("Wrong Date Format !!!");
                if(trainingGroup == null) trainingGroupValidationLabel.setText("please select a training group!!");
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
