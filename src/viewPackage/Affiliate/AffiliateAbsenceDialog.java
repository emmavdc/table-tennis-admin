package viewPackage.Affiliate;

import controllerPackage.AbsenceController;
import exceptionPackage.AbsenceAccessException;
import modelPackage.Absence;
import modelPackage.Affiliate;
import utils.Constants;
import utils.Formating;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AffiliateAbsenceDialog extends JDialog {


    private Formating formatingHelper;
    private JLabel title, week1Label, week2Label, week3Label, week4Label, week5Label,
            week6Label, week7Label, week8Label, week9Label, week10Label, week11Label, week12Label, week13Label, week14Label,
            week15Label, week16Label, week17Label, week18Label, week19Label, week20Label, week21Label, week22Label;
    private JTextField week1, week2, week3, week4, week5, week6, week7, week8, week9, week10, week11, week12, week13,
            week14, week15, week16, week17, week18, week19, week20, week21, week22;
    private JPanel topPanel, bottomPanel, centerPanel;
    private JButton saveButton, closeButton;
    private Affiliate affiliate;
    private AbsenceController controller;
    private AffiliateForm parent;


    public AffiliateAbsenceDialog(AffiliateForm parent,Affiliate affiliate) {

        this.affiliate = affiliate;
        this.parent = parent;

        setTitle("Absence");
        setModal(true);
        setUndecorated(true);
        getRootPane().setBorder(BorderFactory.createLineBorder(new Color(54,90,168),3));
        setSize(900, 700);
        setLocationRelativeTo(null); //null=center
        setLayout(new BorderLayout());

        formatingHelper = new Formating();

        this.affiliate = affiliate;
        controller = new AbsenceController();

        topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        add(topPanel, BorderLayout.NORTH);
        title = new JLabel("Weeks Absence");
        formatingHelper.formatTitleLabel(title);
        topPanel.add(title);

        centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(24, 2, 2, 5));
        add(centerPanel, BorderLayout.CENTER);

        bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout());
        add(bottomPanel, BorderLayout.SOUTH);
        saveButton = new JButton("Save");
        saveButton.addActionListener(new SaveListener());
        bottomPanel.add(saveButton);
        closeButton = new JButton("Close");
        closeButton.addActionListener(new CloseListener());
        bottomPanel.add(closeButton);


        week1Label = new JLabel("week 1");
        week1Label.setHorizontalAlignment(SwingConstants.RIGHT);
        centerPanel.add(week1Label);
        week1 = new JTextField(3);
        centerPanel.add(week1);

        week2Label = new JLabel("week 2");
        week2Label.setHorizontalAlignment(SwingConstants.RIGHT);
        centerPanel.add(week2Label);
        week2 = new JTextField(3);
        centerPanel.add(week2);

        week3Label = new JLabel("week 3");
        week3Label.setHorizontalAlignment(SwingConstants.RIGHT);
        centerPanel.add(week3Label);
        week3 = new JTextField(3);
        centerPanel.add(week3);

        week4Label = new JLabel("week 4");
        week4Label.setHorizontalAlignment(SwingConstants.RIGHT);
        centerPanel.add(week4Label);
        week4 = new JTextField(3);
        centerPanel.add(week4);

        week5Label = new JLabel("week 5");
        week5Label.setHorizontalAlignment(SwingConstants.RIGHT);
        centerPanel.add(week5Label);
        week5 = new JTextField(3);
        centerPanel.add(week5);

        week6Label = new JLabel("week 6");
        week6Label.setHorizontalAlignment(SwingConstants.RIGHT);
        centerPanel.add(week6Label);
        week6 = new JTextField(3);
        centerPanel.add(week6);

        week7Label = new JLabel("week 7");
        week7Label.setHorizontalAlignment(SwingConstants.RIGHT);
        centerPanel.add(week7Label);
        week7 = new JTextField(3);
        centerPanel.add(week7);

        week8Label = new JLabel("week 8");
        week8Label.setHorizontalAlignment(SwingConstants.RIGHT);
        centerPanel.add(week8Label);
        week8 = new JTextField(3);
        centerPanel.add(week8);

        week9Label = new JLabel("week 9");
        week9Label.setHorizontalAlignment(SwingConstants.RIGHT);
        centerPanel.add(week9Label);
        week9 = new JTextField(3);
        centerPanel.add(week9);

        week10Label = new JLabel("week 10");
        week10Label.setHorizontalAlignment(SwingConstants.RIGHT);
        centerPanel.add(week10Label);
        week10 = new JTextField(3);
        centerPanel.add(week10);

        week11Label = new JLabel("week 11");
        week11Label.setHorizontalAlignment(SwingConstants.RIGHT);
        centerPanel.add(week11Label);
        week11 = new JTextField(3);
        centerPanel.add(week11);

        week12Label = new JLabel("week 12");
        week12Label.setHorizontalAlignment(SwingConstants.RIGHT);
        centerPanel.add(week12Label);
        week12 = new JTextField(3);
        centerPanel.add(week12);

        week13Label = new JLabel("week 13");
        week13Label.setHorizontalAlignment(SwingConstants.RIGHT);
        centerPanel.add(week13Label);
        week13 = new JTextField(3);
        centerPanel.add(week13);

        week14Label = new JLabel("week 14");
        week14Label.setHorizontalAlignment(SwingConstants.RIGHT);
        centerPanel.add(week14Label);
        week14 = new JTextField(3);
        centerPanel.add(week14);

        week15Label = new JLabel("week 15");
        week15Label.setHorizontalAlignment(SwingConstants.RIGHT);
        centerPanel.add(week15Label);
        week15 = new JTextField(3);
        centerPanel.add(week15);

        week16Label = new JLabel("week 16");
        week16Label.setHorizontalAlignment(SwingConstants.RIGHT);
        centerPanel.add(week16Label);
        week16 = new JTextField(3);
        centerPanel.add(week16);

        week17Label = new JLabel("week 17");
        week17Label.setHorizontalAlignment(SwingConstants.RIGHT);
        centerPanel.add(week17Label);
        week17 = new JTextField(3);
        centerPanel.add(week17);

        week18Label = new JLabel("week 18");
        week18Label.setHorizontalAlignment(SwingConstants.RIGHT);
        centerPanel.add(week18Label);
        week18 = new JTextField(3);
        centerPanel.add(week18);

        week19Label = new JLabel("week 19");
        week19Label.setHorizontalAlignment(SwingConstants.RIGHT);
        centerPanel.add(week19Label);
        week19 = new JTextField(3);
        centerPanel.add(week19);

        week20Label = new JLabel("week 20");
        week20Label.setHorizontalAlignment(SwingConstants.RIGHT);
        centerPanel.add(week20Label);
        week20 = new JTextField(3);
        centerPanel.add(week20);

        week21Label = new JLabel("week 21");
        week21Label.setHorizontalAlignment(SwingConstants.RIGHT);
        centerPanel.add(week21Label);
        week21 = new JTextField(3);
        centerPanel.add(week21);

        week22Label = new JLabel("week 22");
        week22Label.setHorizontalAlignment(SwingConstants.RIGHT);
        centerPanel.add(week22Label);
        week22 = new JTextField(3);
        centerPanel.add(week22);

        // empty row
        centerPanel.add(new JLabel(Constants.EMPTY_STRING));

        setAbsenceText();

    }

    private void setAbsenceText(){
        for(Absence absence : affiliate.getAffiliateAbsences()){
            if(absence.getWeekNumber() == 1) week1.setText(absence.getDescription());
            if(absence.getWeekNumber() == 2) week2.setText(absence.getDescription());
            if(absence.getWeekNumber() == 3) week3.setText(absence.getDescription());
            if(absence.getWeekNumber() == 4) week4.setText(absence.getDescription());
            if(absence.getWeekNumber() == 5) week5.setText(absence.getDescription());
            if(absence.getWeekNumber() == 6) week6.setText(absence.getDescription());
            if(absence.getWeekNumber() == 7) week7.setText(absence.getDescription());
            if(absence.getWeekNumber() == 8) week8.setText(absence.getDescription());
            if(absence.getWeekNumber() == 9) week9.setText(absence.getDescription());
            if(absence.getWeekNumber() == 10) week10.setText(absence.getDescription());
            if(absence.getWeekNumber() == 11) week11.setText(absence.getDescription());
            if(absence.getWeekNumber() == 12) week12.setText(absence.getDescription());
            if(absence.getWeekNumber() == 13) week13.setText(absence.getDescription());
            if(absence.getWeekNumber() == 14) week14.setText(absence.getDescription());
            if(absence.getWeekNumber() == 15) week15.setText(absence.getDescription());
            if(absence.getWeekNumber() == 16) week16.setText(absence.getDescription());
            if(absence.getWeekNumber() == 17) week17.setText(absence.getDescription());
            if(absence.getWeekNumber() == 18) week18.setText(absence.getDescription());
            if(absence.getWeekNumber() == 19) week19.setText(absence.getDescription());
            if(absence.getWeekNumber() == 20) week20.setText(absence.getDescription());
            if(absence.getWeekNumber() == 21) week21.setText(absence.getDescription());
            if(absence.getWeekNumber() == 22) week22.setText(absence.getDescription());
        }
    }

    private ArrayList<Absence> getAbsences(){

        ArrayList<Absence> absences = new ArrayList<>();
        if(week1.getText().length() > 0){
            absences.add(new Absence(null, 1, week1.getText(), affiliate.getAffiliateID()));
        }
        if(week2.getText().length() > 0){
            absences.add(new Absence(null, 2, week2.getText(), affiliate.getAffiliateID()));
        }
        if(week3.getText().length() > 0){
            absences.add(new Absence(null, 3, week3.getText(), affiliate.getAffiliateID()));
        }
        if(week4.getText().length() > 0){
            absences.add(new Absence(null, 4, week4.getText(), affiliate.getAffiliateID()));
        }
        if(week5.getText().length() > 0){
            absences.add(new Absence(null, 5, week5.getText(), affiliate.getAffiliateID()));
        }
        if(week6.getText().length() > 0){
            absences.add(new Absence(null, 6, week6.getText(), affiliate.getAffiliateID()));
        }
        if(week7.getText().length() > 0){
            absences.add(new Absence(null, 7, week7.getText(), affiliate.getAffiliateID()));
        }
        if(week8.getText().length() > 0){
            absences.add(new Absence(null, 8, week8.getText(), affiliate.getAffiliateID()));
        }
        if(week9.getText().length() > 0){
            absences.add(new Absence(null, 9, week9.getText(), affiliate.getAffiliateID()));
        }
        if(week10.getText().length() > 0){
            absences.add(new Absence(null, 10, week10.getText(), affiliate.getAffiliateID()));
        }
        if(week11.getText().length() > 0){
            absences.add(new Absence(null, 11, week11.getText(), affiliate.getAffiliateID()));
        }
        if(week12.getText().length() > 0){
            absences.add(new Absence(null, 12, week12.getText(), affiliate.getAffiliateID()));
        }
        if(week13.getText().length() > 0){
            absences.add(new Absence(null, 13, week13.getText(), affiliate.getAffiliateID()));
        }
        if(week14.getText().length() > 0){
            absences.add(new Absence(null, 14, week14.getText(), affiliate.getAffiliateID()));
        }
        if(week15.getText().length() > 0){
            absences.add(new Absence(null, 15, week15.getText(), affiliate.getAffiliateID()));
        }
        if(week16.getText().length() > 0){
            absences.add(new Absence(null, 16, week16.getText(), affiliate.getAffiliateID()));
        }
        if(week17.getText().length() > 0){
            absences.add(new Absence(null, 17, week17.getText(), affiliate.getAffiliateID()));
        }
        if(week18.getText().length() > 0){
            absences.add(new Absence(null, 18, week18.getText(), affiliate.getAffiliateID()));
        }
        if(week19.getText().length() > 0){
            absences.add(new Absence(null, 19, week19.getText(), affiliate.getAffiliateID()));
        }
        if(week20.getText().length() > 0){
            absences.add(new Absence(null, 20, week20.getText(), affiliate.getAffiliateID()));
        }
        if(week21.getText().length() > 0){
            absences.add(new Absence(null, 21, week21.getText(), affiliate.getAffiliateID()));
        }
        if(week22.getText().length() > 0){
            absences.add(new Absence(null, 22, week22.getText(), affiliate.getAffiliateID()));
        }

        return absences;
    }

    private void refreshAffiliateData() throws AbsenceAccessException {
        affiliate.setAffiliateAbsences(controller.getAbsencesByAffiliateId(affiliate.getAffiliateID()));
    }

    private class SaveListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                controller.insertAbsences(getAbsences(), affiliate.getAffiliateID());
                refreshAffiliateData();
                JOptionPane.showMessageDialog(null, "Absences weeks updated!","Absence management", JOptionPane.INFORMATION_MESSAGE);
            } catch (AbsenceAccessException absenceAccessException) {
                absenceAccessException.printStackTrace();
            }
        }
    }

    private class CloseListener implements  ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            parent.closeAbsenceDialog();
        }
    }

}


