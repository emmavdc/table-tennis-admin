package businessPackage;

import dataAccessPackage.TrainingDBAccess;
import dataAccessPackage.TrainingDataAccess;
import exceptionPackage.TrainingAccessException;
import modelPackage.TrainingGroup;

import java.util.ArrayList;

public class TrainingManager {

    private TrainingDataAccess trainingDAO;


    public TrainingManager(){

        trainingDAO = new TrainingDBAccess();
    }

    public ArrayList<TrainingGroup> getAllTrainingGroups() throws TrainingAccessException{

        return trainingDAO.getAllTrainingGroups();
    }


}
