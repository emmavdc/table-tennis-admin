package modelPackage;

public class Training {

    private Integer trainingGroupId;
    private Integer affiliateId;

    public Training(Integer trainingGroupId, Integer affiliateId) {
        this.trainingGroupId = trainingGroupId;
        this.affiliateId = affiliateId;
    }

    public Integer getAffiliateId() {
        return affiliateId;
    }

    public Integer getTrainingGroupId() {
        return trainingGroupId;
    }

}
