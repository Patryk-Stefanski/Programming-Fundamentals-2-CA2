import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Utilities {

    static boolean onlyContainsNumbers(String text) {
        return (text.matches("[0-9]+"));
    }

    static String max20Chars(String string) {
        return (string.length() <= 20) ? string : string.substring(0, 20);
    }

    static String max2Chars(String string) {
        return (string.length() <= 2) ? string : string.substring(0, 2);
    }

    static boolean validEmail(String email) {
        return (email.contains("@") && email.contains("."));
    }


    static boolean validDoubleNonNegative(double number) {
        return (number >= 0);
    }

    static boolean validHourlyRate(double number) {
        return (number >= 9.80);
    }

    static double validSalesWorkerBonus(double percentage) {
        if (percentage <= 20 && percentage >= 0) {
            percentage = percentage / 100;
        }
        else{
            percentage=0;
        }
        return percentage;
    }

    static double validAdminWorkerBonus(double percentage) {
        if (percentage >= 0) {
            percentage = percentage / 100;
        }
        else{
            percentage=0;
        }
        return percentage;
    }


    static boolean validIndex(int index, ArrayList list) {
        return (index >= 0 && index < list.size());
    }


    static String validPPS(String PPS) {
        //A PPS Number is always 7 numbers followed by either one or two letters.
        String ValidPPS = "INVALID";
        if (PPS.length() > 7 && onlyContainsNumbers(PPS.substring(0, 7))) {
            ValidPPS = PPS.substring(0, 7) + max2Chars(PPS.substring(7));
        }
        return ValidPPS;
    }

}