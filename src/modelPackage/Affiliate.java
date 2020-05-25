package modelPackage;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Affiliate {

    private Integer affiliateID;
    private String firstName;
    private String lastName;
    private String gender;
    private GregorianCalendar birthDate;
    private Boolean playCompetition;
    private String phone;
    private String email;
    private Integer equipment;
    private ArrayList<Training> trainings;
    private ArrayList<AffiliateRanking> affiliateRankings;
    private ArrayList<Absence> affiliateAbsences;



    public Affiliate(Integer affiliateID, String firstName, String lastName,
                     String gender, GregorianCalendar birthDate, Boolean playCompetition, Integer equipment){

        setAffiliateID(affiliateID);
        setFirstName(firstName);
        setLastName(lastName);
        setGender(gender);
        setBirthDate(birthDate);
        setPlayCompetition(playCompetition);
        setEquipment(equipment);
    }

    // getters

    public Integer getAffiliateID() {
        return affiliateID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    public GregorianCalendar getBirthDate() {
        return birthDate;
    }

    public Boolean getPlayCompetition() {
        return playCompetition;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public Integer getEquipment() {
        return equipment;
    }

    public ArrayList<Training> getTrainings() {
        return trainings;
    }

    public ArrayList<AffiliateRanking> getAffiliateRankings() {
        return affiliateRankings;
    }

    public ArrayList<Absence> getAffiliateAbsences() {
        return affiliateAbsences;
    }

    //setters

    public void setAffiliateID(Integer affiliateID) {
        this.affiliateID = affiliateID;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGender(String gender) {
        this.gender = gender.toUpperCase();
    }

    public void setBirthDate(GregorianCalendar birthDate) {
        this.birthDate = birthDate;
    }

    public void setPlayCompetition(Boolean playCompetition) {
        this.playCompetition = playCompetition;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEquipment(Integer equipment) {
        this.equipment = equipment;
    }

    public void setTrainings(ArrayList<Training> trainings) {
        this.trainings = trainings;
    }

    public void setAffiliateRankings(ArrayList<AffiliateRanking> affiliateRankings) {
        this.affiliateRankings = affiliateRankings;
    }

    public void setAffiliateAbsences(ArrayList<Absence> affiliateAbsences) {
        this.affiliateAbsences = affiliateAbsences;
    }

    public String toString(){
        StringBuilder equipment = new StringBuilder("");
        equipment.append(firstName + " " + lastName);

        return equipment.toString();
    }




}
