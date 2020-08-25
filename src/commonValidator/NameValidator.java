package commonValidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameValidator {

    private Pattern pattern;
    private Matcher matcher;

    private static final String NAME_PATTERN =
            "^[a-zéèçàïôëA-Z]{1,50}(-| )?([a-zéèçàïôëA-Z]{1,50})?$";


    public NameValidator(){

        pattern = Pattern.compile(NAME_PATTERN);

    }

    public boolean validate(String name){

        matcher = pattern.matcher(name);
        return matcher.matches();
    }


}
