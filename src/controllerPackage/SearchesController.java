package controllerPackage;

import businessPackage.SearchesManager;
import exceptionPackage.SearchAccessException;
import modelPackage.AffiliateAvailableWeek;
import modelPackage.AffiliateInTraining;
import modelPackage.AffiliateInTrainingBirthDate;

import java.util.ArrayList;

public class SearchesController {

    private SearchesManager searchesManager;

    public SearchesController(){
        searchesManager = new SearchesManager();
    }

    public ArrayList<AffiliateInTraining> getAllAffiliatesInTraining(int trainingGroupId, int currentSeason) throws SearchAccessException{
        return searchesManager.getAllAffiliatesInTraining(trainingGroupId, currentSeason);
    }

    public ArrayList<AffiliateInTrainingBirthDate> getAllAffiliatesInTrainingAccordingBirthDate(int trainingGroupId, int currentSeason, String startDate, String endDate) throws SearchAccessException{
        return searchesManager.getAllAffiliatesInTrainingAccordingBirthDate(trainingGroupId, currentSeason, startDate, endDate);
    }

    public ArrayList<AffiliateAvailableWeek> getAllAffiliatesAvailableWeek(int weekNumber, String rankingName, int season) throws SearchAccessException{
        return searchesManager.getAllAffiliatesAvailableWeek(weekNumber, rankingName, season);
    }

}
