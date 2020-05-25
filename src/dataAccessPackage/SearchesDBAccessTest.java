package dataAccessPackage;

import exceptionPackage.SearchAccessException;
import modelPackage.AffiliateInTraining;
import modelPackage.AffiliateInTrainingBirthDate;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

class SearchesDBAccessTest {

    @Test
    void getAllAffiliatesInTraining() throws SearchAccessException {

        SearchesDBAccess searchesDBAccess = new SearchesDBAccess();

        ArrayList<AffiliateInTraining> allAffiliateInTraining = searchesDBAccess.getAllAffiliatesInTraining(1,2019);

        for(AffiliateInTraining affiliateInTraining : allAffiliateInTraining){

            System.out.println(affiliateInTraining);

        }
    }

    @Test
    void getAllAffiliatesInTrainingAccordingBirthDate()  throws SearchAccessException {

        SearchesDBAccess searchesDBAccess = new SearchesDBAccess();

        String startDate = "12/01/2000";
        String endDate = "12/12/2020";


        ArrayList<AffiliateInTrainingBirthDate> allAffiliateInTrainingBirthDate = searchesDBAccess.getAllAffiliatesInTrainingAccordingBirthDate(1,2019, startDate, endDate);

        for(AffiliateInTrainingBirthDate affiliateInTrainingBirthDate : allAffiliateInTrainingBirthDate){

            System.out.println(affiliateInTrainingBirthDate.getFirstName());

        }


    }
}