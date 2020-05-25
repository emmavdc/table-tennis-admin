package exceptionPackage;

public class AbsenceAccessException extends Exception {

    public String getMessage() {
        return "There is a problem when getting the data from absence db ";
    }

}
