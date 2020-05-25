package dataAccessPackage;

import exceptionPackage.SearchAccessException;
import modelPackage.AffiliateAvailableWeek;
import modelPackage.AffiliateInTraining;
import modelPackage.AffiliateInTrainingBirthDate;

import java.util.ArrayList;

public interface SearchesDataAccess {

    public ArrayList<AffiliateInTraining> getAllAffiliatesInTraining(int trainingGroupId, int currentSeason) throws SearchAccessException;

    public ArrayList<AffiliateInTrainingBirthDate> getAllAffiliatesInTrainingAccordingBirthDate(int trainingGroupId, int currentSeason, String startDate, String endDate) throws SearchAccessException;

    public ArrayList<AffiliateAvailableWeek> getAllAffiliatesAvailableWeek(int weekNumber, String rankingName, int season) throws SearchAccessException;

}
