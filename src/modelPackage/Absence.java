package modelPackage;

public class Absence {

    private Integer absenceID;
    private Integer weekNumber;
    private String description;
    private Integer affiliateID;
    private Affiliate affiliate;

    public Absence(Integer absenceID, Integer weekNumber, String description, Integer affiliateID){
        this.absenceID = absenceID;
        this.weekNumber =  weekNumber;
        this.description = description;
        this.affiliateID = affiliateID;
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

    public void setAffiliate(Affiliate affiliate) {
        this.affiliate = affiliate;
    }

    public String toString(){
        StringBuilder absence = new StringBuilder("");
        absence.append(weekNumber + "-" +description);

        return absence.toString();
    }
}
