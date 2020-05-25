package modelPackage;

public class Absence {

    private Integer absenceID;
    private Integer weekNumber;
    private String description;
    private Integer affiliateID;
    private Affiliate affiliate;

    public Absence(Integer absenceID, Integer weekNumber, String description, Integer affiliateID){
        setAbsenceID(absenceID);
        setWeekNumber(weekNumber);
        setDescription(description);
        setAffiliateID(affiliateID);
    }

    // Getters

    public Integer getWeekNumber() {
        return weekNumber;
    }

    public String getDescription() {
        return description;
    }

    public Integer getAffiliateID() {
        return affiliateID;
    }

    public Affiliate getAffiliate() {
        return affiliate;
    }
    // Setters

    public void setAbsenceID(Integer absenceID) {
        this.absenceID = absenceID;
    }

    public void setWeekNumber(Integer weekNumber) {
        this.weekNumber = weekNumber;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAffiliateID(Integer affiliateID) {
        this.affiliateID = affiliateID;
    }

    public void setAffiliate(Affiliate affiliate) {
        this.affiliate = affiliate;
    }

    public String toString(){
        StringBuilder absence = new StringBuilder("");
        absence.append(weekNumber + "-" +description);

        return absence.toString();
    }
}
