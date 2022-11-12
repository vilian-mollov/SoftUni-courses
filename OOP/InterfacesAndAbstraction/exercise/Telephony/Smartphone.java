package InterfacesAndAbstraction.exercise.Telephony;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Smartphone implements Callable, Browsable {

    private List<String> numbers;
    private List<String> urls;

    public Smartphone() {
        this.numbers = new ArrayList<>();
        this.urls = new ArrayList<>();
    }


    @Override
    public String browse(String site) {
        boolean isValid = validateSite(site);

        if(!isValid){
        throw new IllegalArgumentException("Invalid URL!");
        }

        this.urls.add(site);
        return "Browsing: " + site;
    }

    @Override
    public String call(String number) {
        number = number.replace(" " , "");
        boolean isValid = validateNumber(number);
        if(!isValid){
            throw new IllegalArgumentException("Invalid number!");
        }

        this.numbers.add(number);
        return "Calling... " + number;
    }

    private boolean validateNumber(String number) {
        Pattern p = Pattern.compile("^(359|0)[89][789]\\d{7}$");
        Matcher matcher = p.matcher(number);
        return matcher.find();
    }

    private boolean validateSite(String site) {
        Pattern p = Pattern.compile("^http(s)?:\\/\\/www.[a-zA-Z]+.(com)?(bg)?(org)?(net)?(edu)?(\\/)?");
        Matcher matcher = p.matcher(site);
        return matcher.find();
    }
}
