package modelPackage;

public class Equipment {

    private Integer reference;
    private String description;

    public Equipment(Integer reference, String description){
        setReference(reference);
        setDescription(description);
    }

    public Integer getReference() {
        return reference;
    }

    public String getDescription() {
        return description;
    }

    public void setReference(Integer reference) {
        this.reference = reference;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toString(){
        StringBuilder equipment = new StringBuilder("");
        equipment.append(description);

        return equipment.toString();
    }
}
