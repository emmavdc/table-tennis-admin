package businessPackage;

import dataAccessPackage.RankingDBAccess;
import exceptionPackage.RankingAccessException;
import modelPackage.AffiliateRanking;
import modelPackage.Ranking;

import java.util.ArrayList;

public class RankingManager {

    private RankingDBAccess rankingDao;

    public RankingManager(){
        rankingDao = new RankingDBAccess();

    }

    public ArrayList<Ranking> getAllRankings() throws RankingAccessException{
        return rankingDao.getAllRankings();
    }

    public ArrayList<AffiliateRanking> getRankingsByAffiliateId(int affiliateId) throws RankingAccessException{
        return rankingDao.getRankingsByAffiliateId(affiliateId);
    }

    public void insertAffiliateRanking(AffiliateRanking affiliateRanking) throws RankingAccessException{
        rankingDao.insertAffiliateRanking(affiliateRanking);
    }

    public void updateAffiliateRanking(AffiliateRanking affiliateRanking) throws RankingAccessException{
        rankingDao.updateAffiliateRanking(affiliateRanking);
    }

    public void deleteAffiliateRanking(int affiliateRankingId) throws RankingAccessException{
        rankingDao.deleteAffiliateRanking(affiliateRankingId);
    }

}
