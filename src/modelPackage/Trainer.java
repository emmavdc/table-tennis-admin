package modelPackage;

public class Trainer {

    private Integer trainerID;
    private String firstName;
    private String lastName;
    private String phone;

    public Trainer(Integer trainerID, String firstName, String lastName){

        setTrainerID(trainerID);
        setFirstName(firstName);
        setLastName(lastName);
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

    public void setTrainerID(Integer trainerID) {
        this.trainerID = trainerID;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
