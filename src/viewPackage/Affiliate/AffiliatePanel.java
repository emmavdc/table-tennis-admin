package viewPackage.Affiliate;

import controllerPackage.EquipmentController;
import controllerPackage.TrainingController;
import exceptionPackage.EquipmentAccessException;
import exceptionPackage.TrainingAccessException;
import modelPackage.*;
import utils.Formating;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.Collectors;

public class AffiliatePanel extends JPanel {

    private AffiliateFormMode mode;
    private JLabel affiliateIdLabel, affiliateIdValidationLabel, firstNameLabel, firstNameValidationLabel
                    , lastNameLabel, lastNameValidationLabel, genderLabel, genderValidationLabel, birthDateLabel
                    , birthDateValidationLabel, phoneLabel, phoneValidationLabel, emailLabel, emailValidationLabel
                    , playCompetitionLabel, equipmentLabel, equipmentValidationLabel, trainingGroupLabel, trainingGroupValidationLabel
                    , manRankingLabel, womanRankingLabel, manRanking, womanRanking, modeLabel;

    private JTextField affiliateId, firstName, lastName, phone, email;
    private JFormattedTextField birthDate;
    private JComboBox genderComboBox, equipmentComboBox, trainingGroup1ComboBox, trainingGroup2ComboBox;
    private JCheckBox playCompetitionCheckBox;
    private EquipmentController equipmentController;
    private TrainingController trainingController;
    private ArrayList<Equipment> equipments;
    private ArrayList<TrainingGroup> trainingGroups;
    private Formating formatingHelper;

    public AffiliatePanel() throws EquipmentAccessException, TrainingAccessException {

        formatingHelper = new Formating();

        this.setBorder(new EmptyBorder(20, 30, 20, 30));
        this.setLayout(new GridLayout(27, 2, 2, 5));

        modeLabel = new JLabel("Affiliate / Creation");
        formatingHelper.formatTitleLabel(modeLabel);

        this.add(modeLabel);
        this.add(new JLabel(""));

        affiliateIdLabel = new JLabel("Affiliate Id :");
        affiliateIdLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        this.add(affiliateIdLabel);
        affiliateId = new JTextField(7);
        affiliateId.setColumns(7);
        this.add(affiliateId);
        //first column is empty
        this.add(new JLabel(""));
        affiliateIdValidationLabel = new JLabel("");
        affiliateIdValidationLabel.setForeground(Color.RED);
        this.add(affiliateIdValidationLabel);


        firstNameLabel = new JLabel("First name :");
        firstNameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        this.add(firstNameLabel);
        firstName = new JTextField(30);
        this.add(firstName);
        //first column is empty
        this.add(new JLabel(""));
        firstNameValidationLabel = new JLabel("");
        firstNameValidationLabel.setForeground(Color.RED);
        this.add(firstNameValidationLabel);

        lastNameLabel = new JLabel("Last name :");
        lastNameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        this.add(lastNameLabel);
        lastName = new JTextField(30);
        this.add(lastName);
        //first column is empty
        this.add(new JLabel(""));
        lastNameValidationLabel = new JLabel("");
        lastNameValidationLabel.setForeground(Color.RED);
        this.add(lastNameValidationLabel);

        genderLabel = new JLabel("Gender :");
        genderLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        this.add(genderLabel);
        String[] values = {"man", "woman"};
        genderComboBox = new JComboBox(values);
        genderComboBox.setSelectedIndex(-1);
        genderComboBox.setMaximumRowCount(3);
        this.add(genderComboBox);
        this.add(new JLabel(""));
        genderValidationLabel = new JLabel();
        genderValidationLabel.setForeground(Color.RED);
        this.add(genderValidationLabel);

        birthDateLabel = new JLabel("Birth date (DD/MM/YYYY) :");
        birthDateLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        this.add(birthDateLabel);

        MaskFormatter birthDateMask = null;
        try {
            birthDateMask = new MaskFormatter("##/##/####");
            birthDateMask.setPlaceholderCharacter('_');
        } catch (ParseException e) {
        }
        birthDate = new JFormattedTextField(birthDateMask);
        add(birthDate);
        //first column is empty
        this.add(new JLabel(""));
        birthDateValidationLabel = new JLabel("");
        birthDateValidationLabel.setForeground(Color.RED);
        this.add(birthDateValidationLabel);

        phoneLabel = new JLabel("Phone :");
        phoneLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        this.add(phoneLabel);
        phone = new JTextField(30);
        this.add(phone);
        //first column is empty
        this.add(new JLabel(""));
        phoneValidationLabel = new JLabel("");
        phoneValidationLabel.setForeground(Color.RED);
        this.add(phoneValidationLabel);

        emailLabel = new JLabel("Email :");
        emailLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        this.add(emailLabel);
        email = new JTextField(30);
        this.add(email);
        //first column is empty
        this.add(new JLabel(""));
        emailValidationLabel = new JLabel("");
        emailValidationLabel.setForeground(Color.RED);
        this.add(emailValidationLabel);

        playCompetitionLabel = new JLabel("Play Competition :");
        playCompetitionLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        this.add(playCompetitionLabel);
        playCompetitionCheckBox = new JCheckBox();
        this.add(playCompetitionCheckBox);

        this.add(new JLabel(""));
        this.add(new JLabel(""));

        equipmentLabel = new JLabel("Equipment :");
        equipmentLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        this.add(equipmentLabel);
        equipmentController = new EquipmentController();
        equipments = equipmentController.getAllEquipments();
        equipmentComboBox = new JComboBox(equipments.toArray());
        equipmentComboBox.setSelectedIndex(-1);
        equipmentComboBox.setMaximumRowCount(5);
        this.add(equipmentComboBox);

        this.add(new JLabel(""));
        equipmentValidationLabel = new JLabel("");
        equipmentValidationLabel.setForeground(Color.RED);
        this.add(equipmentValidationLabel);

        trainingGroupLabel = new JLabel("Training Groups :");
        trainingGroupLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        this.add(trainingGroupLabel);

        trainingController = new TrainingController();
        trainingGroups = trainingController.getAllTrainingGroups();

        trainingGroup1ComboBox = new JComboBox(trainingGroups.toArray());
        trainingGroup1ComboBox.insertItemAt("", 0);
        trainingGroup1ComboBox.setSelectedIndex(0);
        trainingGroup1ComboBox.setMaximumRowCount(5);
        this.add(trainingGroup1ComboBox);
        this.add(new JLabel(""));

        trainingGroup2ComboBox = new JComboBox(trainingGroups.toArray());
        trainingGroup2ComboBox.insertItemAt("", 0);
        trainingGroup2ComboBox.setSelectedIndex(0);
        trainingGroup2ComboBox.setMaximumRowCount(5);
        this.add(trainingGroup2ComboBox);
        this.add(new JLabel(""));
        trainingGroupValidationLabel = new JLabel("");
        trainingGroupValidationLabel.setForeground(Color.RED);
        this.add(trainingGroupValidationLabel);

        manRankingLabel = new JLabel("Man Ranking :");
        manRankingLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        manRankingLabel.setVisible(false);
        this.add(manRankingLabel);

        manRanking = new JLabel("");
        this.add(manRanking);

        this.add(new JLabel(""));
        this.add(new JLabel(""));

        womanRankingLabel = new JLabel("Woman Ranking :");
        womanRankingLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        womanRankingLabel.setVisible(false);
        this.add(womanRankingLabel);

        womanRanking = new JLabel("");
        this.add(womanRanking);

    }

    public void reset() {
        affiliateId.setText("");
        affiliateId.setEnabled(true);
        firstName.setText("");
        lastName.setText("");
        email.setText("");
        phone.setText("");
        birthDate.setText("");
        genderComboBox.setSelectedIndex(-1);
        equipmentComboBox.setSelectedIndex(-1);
        trainingGroup1ComboBox.setSelectedIndex(0);
        trainingGroup2ComboBox.setSelectedIndex(0);
        womanRanking.setText("");
        manRanking.setText("");
        manRankingLabel.setVisible(false);
        womanRankingLabel.setVisible(false);
        resetValidation();
    }

    public void resetValidation() {
        affiliateIdValidationLabel.setText("");
        firstNameValidationLabel.setText("");
        lastNameValidationLabel.setText("");
        emailValidationLabel.setText("");
        phoneValidationLabel.setText("");
        birthDateValidationLabel.setText("");
        trainingGroupValidationLabel.setText("");
        genderValidationLabel.setText("");
        equipmentValidationLabel.setText("");
    }

    public Affiliate getAffiliate() {

        Affiliate affiliate;

        int affiliateIdNumber;
        try {
            affiliateIdNumber = Integer.parseInt(affiliateId.getText());
        } catch (Exception e) {
            //if the id is not numeric then set a bad value which will be validated to false into the business layer
            affiliateIdNumber = -1;
        }

        GregorianCalendar gregorianBirthDate;

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            gregorianBirthDate = new GregorianCalendar();
            gregorianBirthDate.setTime(simpleDateFormat.parse(birthDate.getText()));
        } catch (ParseException e) {
            gregorianBirthDate = null;
        }

        String selectedGender="";
        if (genderComboBox.getSelectedIndex()!=-1) {
            selectedGender = genderComboBox.getSelectedItem().toString().substring(0, 1);
        }

        Integer selectedEquipment=null;
        if (equipmentComboBox.getSelectedIndex()!=-1) {
            selectedEquipment = ((Equipment)equipmentComboBox.getSelectedItem()).getReference();
        }
        affiliate = new Affiliate(affiliateIdNumber, firstName.getText(), lastName.getText(),
                selectedGender, gregorianBirthDate,
                playCompetitionCheckBox.isSelected(), selectedEquipment);

        affiliate.setPhone(phone.getText());
        affiliate.setEmail(email.getText());

        affiliate.setTrainings(new ArrayList<Training>());

        int trainingId;
        if (trainingGroup1ComboBox.getSelectedIndex() != 0) {
            trainingId = ((TrainingGroup) trainingGroup1ComboBox.getSelectedItem()).getTrainingGroupID();
            affiliate.getTrainings().add(new Training(trainingId, affiliate.getAffiliateID()));
        }
        if (trainingGroup2ComboBox.getSelectedIndex() != 0) {
            trainingId = ((TrainingGroup) trainingGroup2ComboBox.getSelectedItem()).getTrainingGroupID();
            affiliate.getTrainings().add(new Training(trainingId, affiliate.getAffiliateID()));
        }

        return affiliate;
    }

    public void setAffiliate(Affiliate affiliate) {
        moveAffiliateToPanel(affiliate);
    }

    private void moveAffiliateToPanel(Affiliate affiliate) {
        affiliateId.setText(affiliate.getAffiliateID().toString());
        firstName.setText(affiliate.getFirstName());
        lastName.setText(affiliate.getLastName());
        switch (affiliate.getGender()) {
            case "M":
                genderComboBox.setSelectedItem("man");
                break;
            case "W":
                genderComboBox.setSelectedItem("woman");
                break;
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        birthDate.setText(simpleDateFormat.format(affiliate.getBirthDate().getTime()));

        if (affiliate.getPhone() != null) {
            phone.setText(affiliate.getPhone());
        }
        if (affiliate.getEmail() != null) {
            email.setText(affiliate.getEmail());
        }

        playCompetitionCheckBox.setSelected(affiliate.getPlayCompetition());

        Equipment equipmentToSelect =
                equipments.stream()
                        .filter((e) -> e.getReference() == affiliate.getEquipment())
                        .findFirst()
                        .orElse(null);

        equipmentComboBox.setSelectedItem(equipmentToSelect);

        TrainingGroup trainingGroupToSelect;
        trainingGroup1ComboBox.setSelectedIndex(0);
        trainingGroup2ComboBox.setSelectedIndex(0);
        if (affiliate.getTrainings() != null) {

            switch (affiliate.getTrainings().size()) {
                case 1:
                    trainingGroupToSelect =
                            trainingGroups.stream()
                                    .filter((tg) -> tg.getTrainingGroupID() == affiliate.getTrainings().get(0).getTrainingGroupId())
                                    .findFirst()
                                    .orElse(null);
                    trainingGroup1ComboBox.setSelectedItem(trainingGroupToSelect);
                    break;
                case 2:
                    trainingGroupToSelect =
                            trainingGroups.stream()
                                    .filter((tg) -> tg.getTrainingGroupID() == affiliate.getTrainings().get(0).getTrainingGroupId())
                                    .findFirst()
                                    .orElse(null);
                    trainingGroup1ComboBox.setSelectedItem(trainingGroupToSelect);
                    trainingGroupToSelect =
                            trainingGroups.stream()
                                    .filter((tg) -> tg.getTrainingGroupID() == affiliate.getTrainings().get(1).getTrainingGroupId())
                                    .findFirst()
                                    .orElse(null);
                    trainingGroup2ComboBox.setSelectedItem(trainingGroupToSelect);
                    break;
            }
        }

        manRankingLabel.setVisible(true);

        if (affiliate.getGender().equalsIgnoreCase("W")) {
            womanRankingLabel.setVisible(true);
        }

        if (affiliate.getAffiliateRankings() != null) {
            List<AffiliateRanking> manRankings = affiliate.getAffiliateRankings()
                    .stream()
                    .filter(r->r.getGender().equalsIgnoreCase("m"))
                    .sorted(Comparator.comparingInt(AffiliateRanking::getSeason).reversed())
                    .collect(Collectors.toList());
            List<AffiliateRanking> womanRankings = affiliate.getAffiliateRankings()
                    .stream()
                    .filter(r->r.getGender().equalsIgnoreCase("w"))
                    .sorted(Comparator.comparingInt(AffiliateRanking::getSeason).reversed())
                    .collect(Collectors.toList());

            if (manRankings.size()>0) {
                manRanking.setText(manRankings.get(0).getName());
            }
            if (womanRankings.size()>0) {
                womanRanking.setText(womanRankings.get(0).getName());
            }
        }
    }

    private void lockPanel(boolean mode) {

        for (Component component : this.getComponents()) {
            component.setEnabled(!mode);
        }
    }


    public void setValidationResult(ArrayList<ValidationResult> validationResults) {
        for (ValidationResult validationResult : validationResults) {
            if (validationResult.getElementValidated() == "AFFILIATEID") {
                affiliateIdValidationLabel.setText(validationResult.getMessage());
            }
            if (validationResult.getElementValidated() == "FIRSTNAME") {
                firstNameValidationLabel.setText(validationResult.getMessage());
            }
            if (validationResult.getElementValidated() == "LASTNAME") {
                lastNameValidationLabel.setText(validationResult.getMessage());
            }
            if (validationResult.getElementValidated() == "PHONE") {
                phoneValidationLabel.setText(validationResult.getMessage());
            }
            if (validationResult.getElementValidated() == "EMAIL") {
                emailValidationLabel.setText(validationResult.getMessage());
            }
            if (validationResult.getElementValidated() == "BIRTHDATE") {
                birthDateValidationLabel.setText(validationResult.getMessage());
            }
            if (validationResult.getElementValidated() == "TRAININGS") {
                trainingGroupValidationLabel.setText(validationResult.getMessage());
            }
            if (validationResult.getElementValidated() == "GENDER") {
                genderValidationLabel.setText(validationResult.getMessage());
            }
            if (validationResult.getElementValidated() == "EQUIPMENT") {
                equipmentValidationLabel.setText(validationResult.getMessage());
            }
        }
    }

    public void setMode(AffiliateFormMode mode) {
        this.mode = mode;
        switch (mode) {
            case NEW:
                resetValidation();
                lockPanel(false);
                modeLabel.setText("Affiliate / Insert");
                break;
            case UPDATE:
                lockPanel(false);
                affiliateId.setEnabled(false);
                modeLabel.setText("Affiliate / Update");
                break;
            case DELETE:
                lockPanel(true);
                modeLabel.setText("Affiliate / Delete");
                break;
        }
    }

}
