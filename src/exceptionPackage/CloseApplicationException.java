package exceptionPackage;

public class CloseApplicationException extends Exception {
    public String getMessage() {
        return "There is a problem with the closing of the application";
    }
}
