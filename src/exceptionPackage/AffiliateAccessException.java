package exceptionPackage;

public class AffiliateAccessException extends Exception {

    public String getMessage() {

        return "there is a problem when getting the data from affiliate db";
    }
}
