package modelPackage;

import java.util.GregorianCalendar;

public class AffiliateInTrainingBirthDate {

    private String firstName;
    private String lastName;
    private GregorianCalendar birthDate;
    private Boolean playCompetition;
    private String phone;
    private String rankingName;

    public AffiliateInTrainingBirthDate(String firstName, String lastName, GregorianCalendar birthDate,
                                        Boolean playCompetition, String rankingName){
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.playCompetition = playCompetition;
        this.rankingName = rankingName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
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

    public String getRankingName() {
        return rankingName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


}
