package dataAccessPackage;

import exceptionPackage.TrainingAccessException;
import modelPackage.TrainingGroup;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;


class TrainingDBAccessTest {

    @Test
    void getAllTrainingGroups() throws TrainingAccessException {

        TrainingDBAccess trainingDao = new TrainingDBAccess();

        ArrayList<TrainingGroup> allTrainingGroups = trainingDao.getAllTrainingGroups();

        for(TrainingGroup trainingGroup : allTrainingGroups){

            System.out.println(trainingGroup);

        }
    }
}