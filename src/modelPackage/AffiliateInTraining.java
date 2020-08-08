package modelPackage;

public class AffiliateInTraining {

    private String firstName;
    private String lastName;
    private String phone;
    private String rankingName;

    public AffiliateInTraining(String firstName, String lastName, String rankingName){
        this.firstName = firstName;
        this.lastName = lastName;
        this.rankingName = rankingName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
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

    public String toString(){
        StringBuilder affiliateInTraining = new StringBuilder("");
        affiliateInTraining.append(firstName + " " + lastName + " - ");
        if(phone != null){
            affiliateInTraining.append(phone + " - ");
        }
        affiliateInTraining.append(rankingName);

        return affiliateInTraining.toString();
    }
}
