package modelPackage;

public class RankingSeason {
    private Integer season;
    private String rankingName;

    public RankingSeason(Integer season, String rankingName){
        setSeason(season);
        setRankingName(rankingName);
    }

    public Integer getSeason() {
        return season;
    }

    public String getRankingName() {
        return rankingName;
    }

    public void setSeason(Integer season) {
        this.season = season;
    }

    public void setRankingName(String rankingName) {
        this.rankingName = rankingName;
    }

}
