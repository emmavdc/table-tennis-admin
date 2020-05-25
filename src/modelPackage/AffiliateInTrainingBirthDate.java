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
        setFirstName(firstName);
        setLastName(lastName);
        setBirthDate(birthDate);
        setPlayCompetition(playCompetition);
        setRankingName(rankingName);
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

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public void setRankingName(String rankingName) {
        this.rankingName = rankingName;
    }


}
