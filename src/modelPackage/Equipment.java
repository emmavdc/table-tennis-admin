package modelPackage;

public class Equipment {

    private Integer reference;
    private String description;

    public Equipment(Integer reference, String description){
        this.reference = reference;
        this.description = description;
    }

    public Integer getReference() {
        return reference;
    }

    public String getDescription() {
        return description;
    }

    public String toString(){
        StringBuilder equipment = new StringBuilder("");
        equipment.append(description);

        return equipment.toString();
    }
}
