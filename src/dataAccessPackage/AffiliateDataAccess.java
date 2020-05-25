package dataAccessPackage;

import exceptionPackage.AbsenceAccessException;
import exceptionPackage.AffiliateAccessException;
import exceptionPackage.RankingAccessException;
import modelPackage.Affiliate;
import java.util.ArrayList;

public interface AffiliateDataAccess {

    public ArrayList<Affiliate>getAllAffiliates() throws AffiliateAccessException;
    public Affiliate getAffiliate(int id) throws AffiliateAccessException, RankingAccessException, AbsenceAccessException;
    public void insertAffiliate(Affiliate affiliate) throws AffiliateAccessException;
    public void updateAffiliate(Affiliate affiliate) throws AffiliateAccessException;
    public void deleteAffiliate(int id) throws AffiliateAccessException;
    public boolean existAffiliate(int id) throws AffiliateAccessException;

}
