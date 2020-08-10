package viewPackage.Affiliate;

import commonValidator.EmailValidator;
import commonValidator.NameValidator;
import commonValidator.PhoneValidator;
import controllerPackage.EquipmentController;
import controllerPackage.TrainingController;
import exceptionPackage.EquipmentAccessException;
import exceptionPackage.TrainingAccessException;
import modelPackage.*;
import utils.Constants;
import commonValidator.DateValidator;
import utils.Formating;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
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
    private NameValidator nameValidator;
    private EmailValidator emailValidator;
    private PhoneValidator phoneValidator;


    public AffiliatePanel() throws EquipmentAccessException, TrainingAccessException {


        nameValidator = new NameValidator();
        emailValidator = new EmailValidator();
        phoneValidator = new PhoneValidator();

        formatingHelper = new Formating();

        // vertical and horizontal padding
        this.setBorder(new EmptyBorder(20, 30, 20, 30));
        this.setLayout(new GridLayout(27, 2, 2, 5));

        modeLabel = new JLabel("Affiliate / Creation");
        formatingHelper.formatTitleLabel(modeLabel);

        this.add(modeLabel);
        this.add(new JLabel(Constants.EMPTY_STRING));

        affiliateIdLabel = new JLabel("Affiliate Id :");
        affiliateIdLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        this.add(affiliateIdLabel);
        affiliateId = new JTextField(7);

        affiliateId.setColumns(7);
        this.add(affiliateId);
        //first column is empty
        this.add(new JLabel(Constants.EMPTY_STRING));
        affiliateIdValidationLabel = new JLabel(Constants.EMPTY_STRING);
        affiliateIdValidationLabel.setForeground(Color.RED);
        this.add(affiliateIdValidationLabel);


        firstNameLabel = new JLabel("First name :");
        firstNameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        this.add(firstNameLabel);
        firstName = new JTextField(30);
        // verify input
        firstName.setInputVerifier(new FirstNameInputVerifier());
        this.add(firstName);
        //first column is empty
        this.add(new JLabel(Constants.EMPTY_STRING));
        firstNameValidationLabel = new JLabel(Constants.EMPTY_STRING);
        firstNameValidationLabel.setForeground(Color.RED);
        this.add(firstNameValidationLabel);

        lastNameLabel = new JLabel("Last name :");
        lastNameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        this.add(lastNameLabel);
        lastName = new JTextField(30);
        // verify input
        lastName.setInputVerifier(new LastNameInputVerifier());
        this.add(lastName);
        //first column is empty
        this.add(new JLabel(Constants.EMPTY_STRING));
        lastNameValidationLabel = new JLabel(Constants.EMPTY_STRING);
        lastNameValidationLabel.setForeground(Color.RED);
        this.add(lastNameValidationLabel);

        genderLabel = new JLabel("Gender :");
        genderLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        this.add(genderLabel);
        String[] values = {"man", "woman"};
        genderComboBox = new JComboBox(values);
        genderComboBox.setSelectedIndex(-1);
        genderComboBox.setMaximumRowCount(3);
        // verify input
        genderComboBox.setInputVerifier(new GenderInputVerifier());
        this.add(genderComboBox);
        this.add(new JLabel(Constants.EMPTY_STRING));
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
        //verify input
        birthDate.setInputVerifier(new BirthDateInputVerifier());
        this.add(birthDate);
        //first column is empty
        this.add(new JLabel(Constants.EMPTY_STRING));
        birthDateValidationLabel = new JLabel(Constants.EMPTY_STRING);
        birthDateValidationLabel.setForeground(Color.RED);
        this.add(birthDateValidationLabel);

        phoneLabel = new JLabel("Phone :");
        phoneLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        this.add(phoneLabel);
        phone = new JTextField(30);
        //verify input
        phone.setInputVerifier(new PhoneInputVerifier());
        this.add(phone);
        //first column is empty
        this.add(new JLabel(Constants.EMPTY_STRING));
        phoneValidationLabel = new JLabel(Constants.EMPTY_STRING);
        phoneValidationLabel.setForeground(Color.RED);
        this.add(phoneValidationLabel);

        emailLabel = new JLabel("Email :");
        emailLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        this.add(emailLabel);
        email = new JTextField(30);
        //verify input
        email.setInputVerifier(new EmailInputVerifier());
        this.add(email);
        //first column is empty
        this.add(new JLabel(Constants.EMPTY_STRING));
        emailValidationLabel = new JLabel(Constants.EMPTY_STRING);
        emailValidationLabel.setForeground(Color.RED);
        this.add(emailValidationLabel);

        playCompetitionLabel = new JLabel("Play Competition :");
        playCompetitionLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        this.add(playCompetitionLabel);
        playCompetitionCheckBox = new JCheckBox();
        this.add(playCompetitionCheckBox);

        this.add(new JLabel(Constants.EMPTY_STRING));
        this.add(new JLabel(Constants.EMPTY_STRING));

        equipmentLabel = new JLabel("Equipment :");
        equipmentLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        this.add(equipmentLabel);
        equipmentController = new EquipmentController();
        equipments = equipmentController.getAllEquipments();
        equipmentComboBox = new JComboBox(equipments.toArray());
        equipmentComboBox.setSelectedIndex(-1);
        equipmentComboBox.setMaximumRowCount(5);
        //verify input
        equipmentComboBox.setInputVerifier(new EquipmentInputVerifier());
        this.add(equipmentComboBox);

        this.add(new JLabel(Constants.EMPTY_STRING));
        equipmentValidationLabel = new JLabel(Constants.EMPTY_STRING);
        equipmentValidationLabel.setForeground(Color.RED);
        this.add(equipmentValidationLabel);

        trainingGroupLabel = new JLabel("Training Groups :");
        trainingGroupLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        this.add(trainingGroupLabel);

        trainingController = new TrainingController();
        trainingGroups = trainingController.getAllTrainingGroups();

        trainingGroup1ComboBox = new JComboBox(trainingGroups.toArray());
        trainingGroup1ComboBox.insertItemAt(Constants.EMPTY_STRING, 0);
        trainingGroup1ComboBox.setSelectedIndex(0);
        trainingGroup1ComboBox.setMaximumRowCount(5);
        this.add(trainingGroup1ComboBox);
        this.add(new JLabel(Constants.EMPTY_STRING));

        trainingGroup2ComboBox = new JComboBox(trainingGroups.toArray());
        trainingGroup2ComboBox.insertItemAt(Constants.EMPTY_STRING, 0);
        trainingGroup2ComboBox.setSelectedIndex(0);
        trainingGroup2ComboBox.setMaximumRowCount(5);
        this.add(trainingGroup2ComboBox);
        this.add(new JLabel(Constants.EMPTY_STRING));
        trainingGroupValidationLabel = new JLabel(Constants.EMPTY_STRING);
        trainingGroupValidationLabel.setForeground(Color.RED);
        this.add(trainingGroupValidationLabel);

        manRankingLabel = new JLabel("Man Ranking :");
        manRankingLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        manRankingLabel.setVisible(false);
        this.add(manRankingLabel);

        manRanking = new JLabel(Constants.EMPTY_STRING);
        this.add(manRanking);

        this.add(new JLabel(Constants.EMPTY_STRING));
        this.add(new JLabel(Constants.EMPTY_STRING));

        womanRankingLabel = new JLabel("Woman Ranking :");
        womanRankingLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        womanRankingLabel.setVisible(false);
        this.add(womanRankingLabel);

        womanRanking = new JLabel(Constants.EMPTY_STRING);
        this.add(womanRanking);

    }

    public void reset() {
        affiliateId.setText(Constants.EMPTY_STRING);
        affiliateId.setEnabled(true);
        firstName.setText(Constants.EMPTY_STRING);
        lastName.setText(Constants.EMPTY_STRING);
        email.setText(Constants.EMPTY_STRING);
        phone.setText(Constants.EMPTY_STRING);
        birthDate.setText(Constants.EMPTY_STRING);
        genderComboBox.setSelectedIndex(-1);
        equipmentComboBox.setSelectedIndex(-1);
        trainingGroup1ComboBox.setSelectedIndex(0);
        trainingGroup2ComboBox.setSelectedIndex(0);
        womanRanking.setText(Constants.EMPTY_STRING);
        manRanking.setText(Constants.EMPTY_STRING);
        manRankingLabel.setVisible(false);
        womanRankingLabel.setVisible(false);
        resetValidation();
    }

    public void resetValidation() {
        affiliateIdValidationLabel.setText(Constants.EMPTY_STRING);
        firstNameValidationLabel.setText(Constants.EMPTY_STRING);
        lastNameValidationLabel.setText(Constants.EMPTY_STRING);
        emailValidationLabel.setText(Constants.EMPTY_STRING);
        phoneValidationLabel.setText(Constants.EMPTY_STRING);
        birthDateValidationLabel.setText(Constants.EMPTY_STRING);
        trainingGroupValidationLabel.setText(Constants.EMPTY_STRING);
        genderValidationLabel.setText(Constants.EMPTY_STRING);
        equipmentValidationLabel.setText(Constants.EMPTY_STRING);
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

        String selectedGender = Constants.EMPTY_STRING;
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

        if(!(phone.getText().equals(Constants.EMPTY_STRING))) affiliate.setPhone(phone.getText());
        if(!(email.getText().equals(Constants.EMPTY_STRING))) affiliate.setEmail(email.getText());


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
            if (validationResult.getElementValidated() == Constants.AFFILIATEID) {
                affiliateIdValidationLabel.setText(validationResult.getMessage());
            }
            if (validationResult.getElementValidated() == Constants.FIRSTNAME) {
                firstNameValidationLabel.setText(validationResult.getMessage());
            }
            if (validationResult.getElementValidated() == Constants.LASTNAME) {
                lastNameValidationLabel.setText(validationResult.getMessage());
            }
            if (validationResult.getElementValidated() == Constants.PHONE) {
                phoneValidationLabel.setText(validationResult.getMessage());
            }
            if (validationResult.getElementValidated() == Constants.EMAIL) {
                emailValidationLabel.setText(validationResult.getMessage());
            }
            if (validationResult.getElementValidated() == Constants.BIRTHDATE) {
                birthDateValidationLabel.setText(validationResult.getMessage());
            }
            if (validationResult.getElementValidated() == Constants.TRAININGS) {
                trainingGroupValidationLabel.setText(validationResult.getMessage());
            }
            if (validationResult.getElementValidated() == Constants.GENDER) {
                genderValidationLabel.setText(validationResult.getMessage());
            }
            if (validationResult.getElementValidated() == Constants.EQUIPMENT) {
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

    private class FirstNameInputVerifier extends InputVerifier{

        @Override
        public boolean verify(JComponent input) {
            JTextField textField = (JTextField) input;

            if(nameValidator.validate(textField.getText())){
                firstNameValidationLabel.setText("");
                return true;
            }
            else{
                firstNameValidationLabel.setText("FirstName must contain alphabetic characters");
                return  false;
            }
        }
    }

    private class LastNameInputVerifier extends InputVerifier{

        @Override
        public boolean verify(JComponent input) {
            JTextField textField = (JTextField) input;

            if(nameValidator.validate(textField.getText())){
                lastNameValidationLabel.setText("");
                return true;
            }
            else{
                lastNameValidationLabel.setText("LastName must contain alphabetic characters");
                return  false;
            }
        }
    }

    private class GenderInputVerifier extends  InputVerifier{

        @Override
        public boolean verify(JComponent input) {
            if(genderComboBox.getSelectedIndex()!=-1){
                genderValidationLabel.setText("");
                return true;
            }
            else{
                genderValidationLabel.setText("Select a gender!");
                return false;
            }
        }
    }

    private class BirthDateInputVerifier extends InputVerifier{
        @Override
        public boolean verify(JComponent input) {
            JTextField textField = (JTextField) input;

            Calendar c = Calendar.getInstance();
            int year  = c.get(Calendar.YEAR) - 4;

            GregorianCalendar javaDate = DateValidator.validateDate(textField.getText());

            if(javaDate != null){

                if(javaDate.get(Calendar.YEAR) <= 1900 || javaDate.get(Calendar.YEAR) > year){
                    birthDateValidationLabel.setText("birthDate should be >1900 and <= " + year);
                    return false;
                }
                birthDateValidationLabel.setText(Constants.EMPTY_STRING);
                return true;
            }
            else{
                birthDateValidationLabel.setText("Wrong date format");
                return false;
            }
        }
    }

    private class PhoneInputVerifier extends InputVerifier{
        @Override
        public boolean verify(JComponent input) {
            JTextField textField = (JTextField) input;

            if(textField.getText().length() != 0){

                if(textField.getText().length()  >= 15){
                    phoneValidationLabel.setText("Phone should be < 15 digits !");
                    return false;
                }
                else {
                    if(!(phoneValidator.validate(textField.getText()))){
                        phoneValidationLabel.setText("Wrong phone format");
                        return false;
                    }
                    else{
                        phoneValidationLabel.setText("");
                        return true;
                    }
                }
            }
            else{
                phoneValidationLabel.setText("");
                return true;
            }
        }
    }

    private class EmailInputVerifier extends InputVerifier{
        @Override
        public boolean verify(JComponent input) {
            JTextField textField = (JTextField) input;

            if(textField.getText().length() != 0){
                if(emailValidator.validate(textField.getText())){
                    emailValidationLabel.setText("");
                    return true;
                }
                else{
                    emailValidationLabel.setText("Wrong email format");
                    return  false;
                }
            }
            else{
                emailValidationLabel.setText("");
                return true;
            }
        }
    }

    private class EquipmentInputVerifier extends InputVerifier{
        @Override
        public boolean verify(JComponent input) {
            if(equipmentComboBox.getSelectedIndex()!=-1){
                equipmentValidationLabel.setText("");
                return true;
            }
            else{
                equipmentValidationLabel.setText("Select an equipment!");
                return false;
            }
        }
    }


}
