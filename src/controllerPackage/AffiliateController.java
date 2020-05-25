package controllerPackage;


import businessPackage.AffiliateManager;
import exceptionPackage.AbsenceAccessException;
import exceptionPackage.AffiliateAccessException;
import exceptionPackage.RankingAccessException;
import modelPackage.Affiliate;
import modelPackage.ValidationResult;

import java.util.ArrayList;

public class AffiliateController {

    private AffiliateManager affiliateManager;

    public AffiliateController(){
        affiliateManager = new AffiliateManager();
    }

    public ArrayList<ValidationResult> insertAffiliate(Affiliate affiliate) throws AffiliateAccessException {

        return affiliateManager.insertAffiliate(affiliate);
    }

    public ArrayList<ValidationResult> updateAffiliate (Affiliate affiliate)throws AffiliateAccessException{

        return affiliateManager.updateAffiliate(affiliate);
    }

    public void deleteAffiliate(int id)throws AffiliateAccessException{

        affiliateManager.deleteAffiliate(id);
    }

    public ArrayList<Affiliate> getAllAffiliates() throws AffiliateAccessException{

        return affiliateManager.getAllAffiliates();
    }

    public Affiliate getAffiliate(int id) throws AffiliateAccessException, RankingAccessException, AbsenceAccessException {
        return affiliateManager.getAffiliate(id);
    }

}
