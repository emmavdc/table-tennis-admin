package modelPackage;

public class Ranking {

    private Integer rankingID;
    private String name;

    public Ranking(Integer rankingID, String name){
        this.rankingID = rankingID;
        this.name = name;
    }

    public Integer getRankingID() {
        return rankingID;
    }

    public String getName() {
        return name;
    }

    public String toString(){
        StringBuilder ranking = new StringBuilder("");
        ranking.append(name);

        return ranking.toString();
    }


}
