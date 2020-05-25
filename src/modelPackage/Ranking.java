package modelPackage;

public class Ranking {

    private Integer rankingID;
    private String name;

    public Ranking(Integer rankingID, String name){
        setRankingID(rankingID);
        setName(name);
    }

    public Integer getRankingID() {
        return rankingID;
    }

    public String getName() {
        return name;
    }

    public void setRankingID(Integer rankingID) {
        this.rankingID = rankingID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString(){
        StringBuilder ranking = new StringBuilder("");
        ranking.append(name);

        return ranking.toString();
    }


}
