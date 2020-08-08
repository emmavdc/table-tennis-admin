package modelPackage;

public class Room {

    private Integer number;
    private String streetName;
    private String streetNumber;
    private Integer postalCode;
    private String locality;

    public Room(Integer number, String streetName, String streetNumber, Integer postalCode, String locality){
        this.number = number;
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.postalCode = postalCode;
        this.locality = locality;
    }

    public Integer getNumber() {
        return number;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public Integer getPostalCode() {
        return postalCode;
    }

    public String getLocality() {
        return locality;
    }
}
