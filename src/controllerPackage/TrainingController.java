package controllerPackage;

import businessPackage.TrainingManager;
import exceptionPackage.TrainingAccessException;
import modelPackage.TrainingGroup;

import java.util.ArrayList;

public class TrainingController {

    private TrainingManager trainingManager;

    public TrainingController(){
        trainingManager = new TrainingManager();
    }

    public ArrayList<TrainingGroup> getAllTrainingGroups() throws TrainingAccessException {

        return trainingManager.getAllTrainingGroups();
    }
}
