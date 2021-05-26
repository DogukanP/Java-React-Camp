package com.padel.HRMS;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FakeMernis {
    public static boolean validate(String idNumber) {

        String regex = "^[0-9]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(idNumber);

        if(idNumber.length() > 11) {
            return false;
        }

        else if(matcher.matches() && !idNumber.startsWith("0")) {
            return true;
        }



        else {
            return false;
        }

    }
}
