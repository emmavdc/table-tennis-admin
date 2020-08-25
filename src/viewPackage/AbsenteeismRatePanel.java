package viewPackage;

import controllerPackage.AbsenceController;
import exceptionPackage.AbsenceAccessException;
import exceptionPackage.AffiliateAccessException;
import utils.Constants;
import utils.ExceptionHandler;
import utils.Formating;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

public class AbsenteeismRatePanel extends JPanel {

    private AbsenceController controller;
    private MainWindow parent;
    private JLabel titleLabel, averageSeasonLabel,seasonLabel, week1Label, week2Label, week3Label, week4Label, week5Label,
            week6Label, week7Label, week8Label, week9Label, week10Label, week11Label, week12Label, week13Label, week14Label,
            week15Label, week16Label, week17Label, week18Label, week19Label, week20Label, week21Label, week22Label;
    private JButton closeButton;
    private Formating formatingHelper;
    private JPanel topPanel, bottomPanel, contentPanel;
    private double [] averagePerWeek;
    private double averageSeason;
    private int lastYear, currentYear;


    public AbsenteeismRatePanel(MainWindow parent) throws AffiliateAccessException, AbsenceAccessException {

        setLayout(new BorderLayout());
        this.parent = parent;
        controller = new AbsenceController();
        averagePerWeek = new double[22];
        averageSeason = 0;

        averagePerWeek =  controller.absenteeismRateWeek();
        averageSeason = controller.averageAbsenteeismRate();

        // ----- TOP ----- //

        topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(2,1,2,5));
        titleLabel = new JLabel("  Absenteeism rate");
        formatingHelper = new Formating();
        formatingHelper.formatTitleLabel(titleLabel);
        topPanel.add(titleLabel);
        // first row in the top panel
        add(topPanel, BorderLayout.NORTH);

        setCurrentSeason();
        seasonLabel = new JLabel("  Season " + lastYear + "-" + currentYear);
        formatingHelper.formatTitleLabel(seasonLabel);
        // second row in the top panel
        topPanel.add(seasonLabel);

        // ----- CONTENT ----- //

        contentPanel = new JPanel();
        contentPanel.setLayout(new GridLayout(25, 1, 2, 5));

        // empty row
        contentPanel.add(new JLabel(Constants.EMPTY_STRING));

        averageSeasonLabel = new JLabel(Constants.EMPTY_STRING);
        averageSeasonLabel.setText("     Average season : " + String.valueOf(averageSeason) + " %");
        contentPanel.add(averageSeasonLabel);

        week1Label = new JLabel(Constants.EMPTY_STRING);
        week1Label.setText("     Week 1 : " + String.valueOf(averagePerWeek[0] + " %"));
        contentPanel.add(week1Label);

        week2Label = new JLabel(Constants.EMPTY_STRING);
        week2Label.setText("     Week 2 : " + String.valueOf(averagePerWeek[1] + " %"));
        contentPanel.add(week2Label);

        week3Label = new JLabel(Constants.EMPTY_STRING);
        week3Label.setText("     Week 3 : " + String.valueOf(averagePerWeek[2] + " %"));
        contentPanel.add(week3Label);

        week4Label = new JLabel(Constants.EMPTY_STRING);
        week4Label.setText("     Week 4 : " + String.valueOf(averagePerWeek[3] + " %"));
        contentPanel.add(week4Label);

        week5Label = new JLabel(Constants.EMPTY_STRING);
        week5Label.setText("     Week 5  : " + String.valueOf(averagePerWeek[4] + " %"));
        contentPanel.add(week5Label);

        week6Label = new JLabel(Constants.EMPTY_STRING);
        week6Label.setText("     Week 6 : " + String.valueOf(averagePerWeek[5] + " %"));
        contentPanel.add(week6Label);

        week7Label = new JLabel(Constants.EMPTY_STRING);
        week7Label.setText("     Week 7 : " + String.valueOf(averagePerWeek[6] + " %"));
        contentPanel.add(week7Label);

        week8Label = new JLabel(Constants.EMPTY_STRING);
        week8Label.setText("     Week 8 : " + String.valueOf(averagePerWeek[7] + " %"));
        contentPanel.add(week8Label);

        week9Label = new JLabel(Constants.EMPTY_STRING);
        week9Label.setText("     Week 9 : " + String.valueOf(averagePerWeek[8] + " %"));
        contentPanel.add(week9Label);

        week10Label = new JLabel(Constants.EMPTY_STRING);
        week10Label.setText("     Week 10 : " + String.valueOf(averagePerWeek[9] + " %"));
        contentPanel.add(week10Label);

        week11Label = new JLabel(Constants.EMPTY_STRING);
        week11Label.setText("     Week 11 : " + String.valueOf(averagePerWeek[10] + " %"));
        contentPanel.add(week11Label);

        week12Label = new JLabel(Constants.EMPTY_STRING);
        week12Label.setText("     Week 12 : " + String.valueOf(averagePerWeek[11] + "%"));
        contentPanel.add(week12Label);

        week13Label = new JLabel(Constants.EMPTY_STRING);
        week13Label.setText("     Week 13 : " + String.valueOf(averagePerWeek[12] + " %"));
        contentPanel.add(week13Label);

        week14Label = new JLabel(Constants.EMPTY_STRING);
        week14Label.setText("     Week 14 : " + String.valueOf(averagePerWeek[13] + " %"));
        contentPanel.add(week14Label);

        week15Label = new JLabel(Constants.EMPTY_STRING);
        week15Label.setText("     Week 15 : " + String.valueOf(averagePerWeek[14] + "%"));
        contentPanel.add(week15Label);

        week16Label = new JLabel(Constants.EMPTY_STRING);
        week16Label.setText("     Week 16 : " + String.valueOf(averagePerWeek[15] + " %"));
        contentPanel.add(week16Label);

        week17Label = new JLabel(Constants.EMPTY_STRING);
        week17Label.setText("     Week 17 : " + String.valueOf(averagePerWeek[16] + " %"));
        contentPanel.add(week17Label);

        week18Label = new JLabel(Constants.EMPTY_STRING);
        week18Label.setText("     Week 18 : " + String.valueOf(averagePerWeek[17] + " %"));
        contentPanel.add(week18Label);

        week19Label = new JLabel(Constants.EMPTY_STRING);
        week19Label.setText("     Week 19 : " + String.valueOf(averagePerWeek[18] + " %"));
        contentPanel.add(week19Label);

        week20Label = new JLabel(Constants.EMPTY_STRING);
        week20Label.setText("     Week 20 : " + String.valueOf(averagePerWeek[19] + " %"));
        contentPanel.add(week20Label);

        week21Label = new JLabel(Constants.EMPTY_STRING);
        week21Label.setText("     Week 21 : " + String.valueOf(averagePerWeek[20] + " %"));
        contentPanel.add(week21Label);

        week22Label = new JLabel(Constants.EMPTY_STRING);
        week22Label.setText("     Week 22 : " + String.valueOf(averagePerWeek[21] + " %"));
        contentPanel.add(week22Label);

        // empty row
        contentPanel.add(new JLabel(Constants.EMPTY_STRING));

        add(contentPanel, BorderLayout.CENTER);


        // ----- BOTTOM ----- //

        bottomPanel = new JPanel();
        closeButton = new JButton("Close");
        closeButton.addActionListener(new CloseListener());
        bottomPanel.add(closeButton);

        add(bottomPanel, BorderLayout.SOUTH);



    }

    public void reset() {
        try {
            this.averagePerWeek =  controller.absenteeismRateWeek();
            averageSeason = controller.averageAbsenteeismRate();
        } catch (Exception e) {
            ExceptionHandler.exitAfterUnhandledException(e);
        }
        averageSeasonLabel.setText("     Average season : " + String.valueOf(averageSeason) + " %");
        week1Label.setText("     Week 1 : " + String.valueOf(averagePerWeek[0] + " %"));
        week2Label.setText("     Week 2 : " + String.valueOf(averagePerWeek[1] + " %"));
        week3Label.setText("     Week 3 : " + String.valueOf(averagePerWeek[2] + " %"));
        week4Label.setText("     Week 4 : " + String.valueOf(averagePerWeek[3] + " %"));
        week5Label.setText("     Week 5  : " + String.valueOf(averagePerWeek[4] + " %"));
        week6Label.setText("     Week 6 : " + String.valueOf(averagePerWeek[5] + " %"));
        week7Label.setText("     Week 7 : " + String.valueOf(averagePerWeek[6] + " %"));
        week8Label.setText("     Week 8 : " + String.valueOf(averagePerWeek[7] + " %"));
        week9Label.setText("     Week 9 : " + String.valueOf(averagePerWeek[8] + " %"));
        week10Label.setText("     Week 10 : " + String.valueOf(averagePerWeek[9] + " %"));
        week11Label.setText("     Week 11 : " + String.valueOf(averagePerWeek[10] + " %"));
        week12Label.setText("     Week 12 : " + String.valueOf(averagePerWeek[11] + "%"));
        week13Label.setText("     Week 13 : " + String.valueOf(averagePerWeek[12] + " %"));
        week14Label.setText("     Week 14 : " + String.valueOf(averagePerWeek[13] + " %"));
        week15Label.setText("     Week 15 : " + String.valueOf(averagePerWeek[14] + "%"));
        week16Label.setText("     Week 16 : " + String.valueOf(averagePerWeek[15] + " %"));
        week17Label.setText("     Week 17 : " + String.valueOf(averagePerWeek[16] + " %"));
        week18Label.setText("     Week 18 : " + String.valueOf(averagePerWeek[17] + " %"));
        week19Label.setText("     Week 19 : " + String.valueOf(averagePerWeek[18] + " %"));
        week20Label.setText("     Week 20 : " + String.valueOf(averagePerWeek[19] + " %"));
        week21Label.setText("     Week 21 : " + String.valueOf(averagePerWeek[20] + " %"));
        week22Label.setText("     Week 22 : " + String.valueOf(averagePerWeek[21] + " %"));

    }

    private void setCurrentSeason(){
        Calendar c = Calendar.getInstance();
        int currentMonth = c.get(Calendar.MONTH);
        this.lastYear  = c.get(Calendar.YEAR)-1;
        this.currentYear = c.get(Calendar.YEAR);

        // new table tennis season begins in OCTOBER !
        if(currentMonth >= Calendar.OCTOBER){
            this.lastYear = this.currentYear;
            this.currentYear++;
        }
    }

    private class CloseListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            parent.closeCurrentForm();
        }
    }




}
