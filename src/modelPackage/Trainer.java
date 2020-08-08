package modelPackage;

public class Trainer {

    private Integer trainerID;
    private String firstName;
    private String lastName;
    private String phone;

    public Trainer(Integer trainerID, String firstName, String lastName){
        this.trainerID = trainerID;
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
