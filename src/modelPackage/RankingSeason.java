package modelPackage;

public class RankingSeason {
    private Integer season;
    private String rankingName;

    public RankingSeason(Integer season, String rankingName){
        this.season = season;
        this.rankingName = rankingName;
    }

    public Integer getSeason() {
        return season;
    }

    public String getRankingName() {
        return rankingName;
    }

}
