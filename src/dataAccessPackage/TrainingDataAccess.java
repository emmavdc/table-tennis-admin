package dataAccessPackage;

import exceptionPackage.TrainingAccessException;
import modelPackage.Training;
import modelPackage.TrainingGroup;

import java.util.ArrayList;

public interface TrainingDataAccess {

    public ArrayList<TrainingGroup> getAllTrainingGroups() throws TrainingAccessException;
    public ArrayList<Training> getTrainingsByAffiliateId(Integer affiliateId) throws TrainingAccessException;
    public void saveTrainings(ArrayList<Training> trainings, int affiliateId) throws TrainingAccessException;
}