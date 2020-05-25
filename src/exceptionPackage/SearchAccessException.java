package exceptionPackage;

public class SearchAccessException extends Exception {

    public String getMessage() {

        return "there is a problem when getting the data from the db ";
    }


}
