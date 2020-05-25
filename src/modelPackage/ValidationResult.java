package modelPackage;

public class ValidationResult {

    private String elementValidated;
    private String message;

    public ValidationResult(String elementValidated, String message) {
        this.elementValidated = elementValidated;
        this.message = message;
    }

    public String getElementValidated() { return elementValidated; }
    public String getMessage() { return message; }

}
