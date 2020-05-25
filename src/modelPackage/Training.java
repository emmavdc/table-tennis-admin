package modelPackage;

public class Training {

    private Integer trainingGroupId;
    private Integer affiliateId;

    public Training(Integer trainingId, Integer affiliateId) {
        setAffiliateId(affiliateId);
        setTrainingGroupId(trainingId);
    }

    public Integer getAffiliateId() {
        return affiliateId;
    }

    public Integer getTrainingGroupId() {
        return trainingGroupId;
    }

    public void setAffiliateId(Integer affiliateId) {
        this.affiliateId = affiliateId;
    }

    public void setTrainingGroupId(Integer trainingGroupId) {
        this.trainingGroupId = trainingGroupId;
    }
}
