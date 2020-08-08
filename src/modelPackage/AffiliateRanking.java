package modelPackage;

public class AffiliateRanking {

    private Integer affiliateRankingID;
    private String name;
    private String gender;
    private Integer season;
    private Integer affiliateID;
    private Affiliate affiliate;
    private Integer rankingID;
    private Ranking ranking;


    public AffiliateRanking(Integer affiliateRankingID, String name, String gender, Integer season, Integer affiliateID, Integer rankingID){
        this.affiliateRankingID = affiliateRankingID;
        this.name = name;
        this.gender = gender;
        this.season = season;
        this.affiliateID = affiliateID;
        this.rankingID = rankingID;
    }

    public Integer getAffiliateRankingID() {
        return affiliateRankingID;
    }

    public Integer getRankingID() {
        return rankingID;
    }

    public Ranking getRanking() {
        return ranking;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public Integer getAffiliateID() {
        return affiliateID;
    }

    public Affiliate getAffiliate() {
        return affiliate;
    }

    public Integer getSeason() {
        return season;
    }

    public void setAffiliate(Affiliate affiliate) {
        this.affiliate = affiliate;
    }
    public void setRanking(Ranking ranking) {
        this.ranking = ranking;
    }
    public String toString(){
        StringBuilder ranking = new StringBuilder("");
        ranking.append(name);

        return ranking.toString();
    }


}
