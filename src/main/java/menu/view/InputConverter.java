package menu.view;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.PatternSyntaxException;
import menu.exception.ErrorMessage;

public class InputConverter {

    public static List<String> convertCoaches(String inputCoaches) {
        return convertToListBy(inputCoaches);
    }

    public static List<String> convertNonEat(String nonEat) {
        return convertToListBy(nonEat);
    }

    private static List<String> convertToListBy(String input) {
        try {
            String[] splitCoaches = input.trim().split(",");
            return appendToList(splitCoaches);
        } catch (PatternSyntaxException exception) {
            throw new IllegalArgumentException(ErrorMessage.DELIMITER_NON.getErrorMessage());
        }
    }

    private static List<String> appendToList(String[] inputs) {
        List<String> list = new ArrayList<>();
        for (String input : inputs) {
            list.add(input.trim());
        }
        return list;
    }
}
