package exceptionPackage;

public class EquipmentAccessException extends Exception{

    public String getMessage() {

        return "There is a problem when getting the data from equipmnent db";
    }
}
