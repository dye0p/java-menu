package menu.view;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.PatternSyntaxException;
import menu.exception.ErrorMessage;

public class InputConverter {

    public static List<String> convertCoaches(String inputCoaches) {
        return convertToListBy(inputCoaches);
    }

    private static List<String> convertToListBy(String inputCoaches) {
        try {
            String[] splitCoaches = inputCoaches.trim().split(",");
            return appendToList(splitCoaches);
        } catch (PatternSyntaxException exception) {
            throw new IllegalArgumentException(ErrorMessage.DELIMITER_NON.getErrorMessage());
        }
    }

    private static List<String> appendToList(String[] splitCoaches) {
        List<String> coaches = new ArrayList<>();
        for (String splitCoach : splitCoaches) {
            coaches.add(splitCoach.trim());
        }
        return coaches;
    }
}
