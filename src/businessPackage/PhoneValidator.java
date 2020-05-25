package businessPackage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneValidator {

    private Pattern pattern;
    private Matcher matcher;

    private static final String PHONE_PATTERN =
            "^(?:(\\+?\\d{1,3}) )?(?:([\\(]?\\d+[\\)]?)[ -])?(\\d{1,5}[\\- ]?\\d{1,5})$";


    public PhoneValidator(){

        pattern = Pattern.compile(PHONE_PATTERN);

    }

    public boolean validate(String phoneNumber){

        matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }
}
