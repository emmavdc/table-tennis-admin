package modelPackage;

public class Room {

    private Integer number;
    private String streetName;
    private String streetNumber;
    private Integer postalCode;
    private String locality;

    public Room(Integer number, String streetName, String streetNumber, Integer postalCode, String locality){
        setNumber(number);
        setStreetName(streetName);
        setStreetNumber(streetNumber);
        setPostalCode(postalCode);
        setLocality(locality);
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

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public void setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }
}
