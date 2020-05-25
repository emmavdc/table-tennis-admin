package exceptionPackage;

public class TrainingAccessException extends Exception{

    public String getMessage() {
        return "There is a problem when getting the data from training Group db ";
    }
}
