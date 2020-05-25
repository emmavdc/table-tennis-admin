package dataAccessPackage;

import exceptionPackage.RankingAccessException;
import modelPackage.AffiliateRanking;
import modelPackage.Ranking;

import java.util.ArrayList;

public interface RankingDataAccess {

    public ArrayList<Ranking> getAllRankings() throws RankingAccessException;

    public ArrayList<AffiliateRanking> getRankingsByAffiliateId(int affiliateId) throws RankingAccessException;

    public void insertAffiliateRanking(AffiliateRanking affiliateRanking) throws RankingAccessException;

    public void updateAffiliateRanking(AffiliateRanking affiliateRanking) throws RankingAccessException;

    public  void deleteAffiliateRanking(int affiliateRankingId) throws RankingAccessException;;


}
