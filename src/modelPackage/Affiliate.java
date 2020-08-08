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

        this.affiliateID = affiliateID;
        this.firstName = firstName;
        this.lastName = lastName;
        setGender(gender);
        this.birthDate = birthDate;
        this.playCompetition = playCompetition;
        this.equipment = equipment;
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

    public void setGender(String gender) {
        this.gender = gender.toUpperCase();
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
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
