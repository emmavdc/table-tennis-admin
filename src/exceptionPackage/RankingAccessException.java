package exceptionPackage;

public class RankingAccessException extends Exception{

    public String getMessage() {

        return "There is a problem when getting the data from ranking db ";
    }

}
