package businessPackage;


import commonValidator.EmailValidator;
import commonValidator.NameValidator;
import commonValidator.PhoneValidator;
import dataAccessPackage.AffiliateDBAccess;
import dataAccessPackage.AffiliateDataAccess;
import exceptionPackage.AbsenceAccessException;
import exceptionPackage.AffiliateAccessException;
import exceptionPackage.RankingAccessException;
import modelPackage.Affiliate;
import modelPackage.ValidationResult;
import utils.Constants;

import java.util.ArrayList;
import java.util.Calendar;

public class AffiliateManager {

    private AffiliateDataAccess affiliateDAO;
    private EmailValidator emailValidator;
    private PhoneValidator phoneValidator;
    private NameValidator nameValidator;
    private int year;


    public AffiliateManager() {
        affiliateDAO = new AffiliateDBAccess();
        emailValidator = new EmailValidator();
        phoneValidator = new PhoneValidator();
        nameValidator = new NameValidator();
        Calendar c = Calendar.getInstance();
        this.year  = c.get(Calendar.YEAR) - 4;
    }

    public ArrayList<ValidationResult> insertAffiliate(Affiliate affiliate) throws AffiliateAccessException {

        ArrayList<ValidationResult> validationResult;
        validationResult = validate(affiliate);

        //Check if the affiliate already exists
        if (affiliateDAO.existAffiliate(affiliate.getAffiliateID())) {
            validationResult.add(new ValidationResult("AFFILIATEID", "This affiliate already exists!"));
        }

        //if there is no validation error we can insert into the database
        if (validationResult.size() == 0) {
            affiliateDAO.insertAffiliate(affiliate);
        }
        return validationResult;
    }

    public ArrayList<ValidationResult> updateAffiliate(Affiliate affiliate) throws AffiliateAccessException{

        ArrayList<ValidationResult> validationResult;
        validationResult = validate(affiliate);

        //if there is no validation error we can insert into the database
        if (validationResult.size() == 0) {
            affiliateDAO.updateAffiliate(affiliate);
        }
        return validationResult;
    }

    public void deleteAffiliate(int id)throws AffiliateAccessException{
        affiliateDAO.deleteAffiliate(id);
    }

    private ArrayList<ValidationResult> validate(Affiliate affiliate) {

        ArrayList<ValidationResult> validationResult = new ArrayList<ValidationResult>();

        if (affiliate.getAffiliateID() <= 0 || affiliate.getAffiliateID() > 9999999) {
            validationResult.add(new ValidationResult(Constants.AFFILIATEID, Constants.AFFILIATEID_SIZE_ERROR));
        }
        if(!(nameValidator.validate(affiliate.getFirstName()))){
            validationResult.add(new ValidationResult(Constants.FIRSTNAME, Constants.FIRSTNAME_ERROR));
        }
        if(!(nameValidator.validate(affiliate.getLastName()))){
            validationResult.add(new ValidationResult(Constants.LASTNAME, Constants.LASTNAME_ERROR));
        }
        if(affiliate.getPhone() != null && affiliate.getPhone().length() != 0){

            if(affiliate.getPhone().length() >= 15){
                validationResult.add(new ValidationResult(Constants.PHONE, Constants.PHONE_SIZE_ERROR));
            }
            else {
                if(!(phoneValidator.validate(affiliate.getPhone()))){
                    validationResult.add(new ValidationResult(Constants.PHONE, Constants.PHONE_FORMAT_ERROR));
                }
            }
        }
        if( affiliate.getEmail() != null && affiliate.getEmail().length() != 0){
            if(!(emailValidator.validate(affiliate.getEmail()))){
                validationResult.add(new ValidationResult(Constants.EMAIL, Constants.EMAIL_FORMAT_ERROR));
            }
        }

        if(affiliate.getBirthDate() == null) {
            validationResult.add(new ValidationResult(Constants.BIRTHDATE, Constants.DATE_FORMAT_ERROR));
        }
        else{
            if(affiliate.getBirthDate().get(Calendar.YEAR) <= 1900 || affiliate.getBirthDate().get(Calendar.YEAR) > year){
                validationResult.add(new ValidationResult(Constants.BIRTHDATE, "birthDate should be >1900 and <= " + year));
            }
        }

        if(affiliate.getTrainings().size() == 2) {
            if (affiliate.getTrainings().get(0).getTrainingGroupId().intValue()
                    == affiliate.getTrainings().get(1).getTrainingGroupId().intValue()) {
                validationResult.add(new ValidationResult(Constants.TRAININGS, Constants.TRAINING_GROUP_ERROR));
            }
        }
        if (affiliate.getGender().isEmpty()) {
            validationResult.add(new ValidationResult(Constants.GENDER, Constants.GENDER_ERROR));
        }
        if (affiliate.getEquipment() == null) {
            validationResult.add(new ValidationResult(Constants.EQUIPMENT, Constants.EQUIPMENT_ERROR));
        }
        return validationResult;
    }

    public ArrayList<Affiliate> getAllAffiliates() throws AffiliateAccessException{

        return affiliateDAO.getAllAffiliates();
    }

    public Affiliate getAffiliate(int id) throws AffiliateAccessException, RankingAccessException, AbsenceAccessException {

        return affiliateDAO.getAffiliate(id);
    }

}
