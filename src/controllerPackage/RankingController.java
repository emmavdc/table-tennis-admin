package controllerPackage;

import businessPackage.RankingManager;
import exceptionPackage.RankingAccessException;
import modelPackage.AffiliateRanking;
import modelPackage.Ranking;

import java.util.ArrayList;

public class RankingController {

    private RankingManager rankingManager;

    public RankingController(){
        rankingManager = new RankingManager();
    }

    public ArrayList<Ranking> getAllRankings() throws RankingAccessException {
        return rankingManager.getAllRankings();
    }

    public ArrayList<AffiliateRanking> getRankingsByAffiliateId(int affiliateId) throws RankingAccessException{
        return rankingManager.getRankingsByAffiliateId(affiliateId);
    }

    public void insertAffiliateRanking(AffiliateRanking affiliateRanking) throws RankingAccessException{
        rankingManager.insertAffiliateRanking(affiliateRanking);
    }

    public void updateAffiliateRanking(AffiliateRanking affiliateRanking) throws RankingAccessException{
        rankingManager.updateAffiliateRanking(affiliateRanking);
    }

    public void deleteAffiliateRanking(int affiliateRankingId) throws RankingAccessException{
        rankingManager.deleteAffiliateRanking(affiliateRankingId);
    }

}
