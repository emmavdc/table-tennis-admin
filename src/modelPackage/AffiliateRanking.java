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

        setAffiliateRankingID(affiliateRankingID);
        setName(name);
        setGender(gender);
        setSeason(season);
        setAffiliateID(affiliateID);
        setRankingID(rankingID);
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

    public void setRankingID(Integer rankingID) {
        this.rankingID = rankingID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setSeason(Integer season) {
        this.season = season;
    }

    public void setAffiliateID(Integer affiliateID) {
        this.affiliateID = affiliateID;
    }

    public void setAffiliate(Affiliate affiliate) {
        this.affiliate = affiliate;
    }

    public void setAffiliateRankingID(Integer affiliateRankingID) {
        this.affiliateRankingID = affiliateRankingID;
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
