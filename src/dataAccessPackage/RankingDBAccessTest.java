package dataAccessPackage;

import exceptionPackage.RankingAccessException;
import modelPackage.Ranking;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;


class RankingDBAccessTest {

    @Test
    void getAllRankings() throws RankingAccessException {

        RankingDBAccess rankingDao;
        rankingDao = new RankingDBAccess();

        ArrayList<Ranking> allRankings = rankingDao.getAllRankings();

        for(Ranking ranking : allRankings){

            System.out.println(ranking);

        }
    }
}