package modelPackage;

public class AffiliateAvailableWeek {

    private String firstName;
    private String lastName;
    private String phone;


    public AffiliateAvailableWeek(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
