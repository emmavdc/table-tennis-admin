package businessPackage;

import dataAccessPackage.SearchesDBAccess;
import dataAccessPackage.SearchesDataAccess;
import exceptionPackage.SearchAccessException;
import modelPackage.AffiliateAvailableWeek;
import modelPackage.AffiliateInTraining;
import modelPackage.AffiliateInTrainingBirthDate;

import java.util.ArrayList;

public class SearchesManager {

    private SearchesDataAccess searchesDao;


    public  SearchesManager(){

        searchesDao = new SearchesDBAccess();
    }

    public ArrayList<AffiliateInTraining> getAllAffiliatesInTraining(int trainingGroupId, int currentSeason) throws SearchAccessException{

        return searchesDao.getAllAffiliatesInTraining(trainingGroupId, currentSeason);
    }

    public ArrayList<AffiliateInTrainingBirthDate> getAllAffiliatesInTrainingAccordingBirthDate(int trainingGroupId, int currentSeason, String startDate, String endDate) throws SearchAccessException{

        return searchesDao.getAllAffiliatesInTrainingAccordingBirthDate(trainingGroupId, currentSeason, startDate, endDate);
    }

    public ArrayList<AffiliateAvailableWeek> getAllAffiliatesAvailableWeek(int weekNumber, String rankingName, int season) throws SearchAccessException{
        return searchesDao.getAllAffiliatesAvailableWeek(weekNumber, rankingName, season);
    }


}
