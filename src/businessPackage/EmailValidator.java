package businessPackage;

import java.util.regex.*;

public class EmailValidator {

    private Pattern pattern;
    private Matcher matcher;

    private static final String EMAIL_PATTERN =
            "^((?!\\.)[\\w-_.]*[^.])(@\\w+)(\\.\\w+(\\.\\w+)?[^.\\W])$";

    public EmailValidator(){

        pattern = Pattern.compile(EMAIL_PATTERN);

    }

    public boolean validate(String email){

        matcher = pattern.matcher(email);
        return matcher.matches();
    }


}
