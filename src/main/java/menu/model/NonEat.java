package menu.model;

import java.util.HashSet;
import java.util.List;
import menu.exception.ErrorMessage;

public class NonEat {

    private final List<String> nonEat;

    public NonEat(List<String> nonEat) {
        validate(nonEat);
        validateDuplicate(nonEat);
        validateSize(nonEat);
        this.nonEat = nonEat;
    }

    private void validate(List<String> nonEat) {
        if (!nonEat.contains("")) {
            Menu.validateContain(nonEat);
        }
    }

    private void validateSize(List<String> nonEat) {
        if (nonEat.size() > 2) {
            throw new IllegalArgumentException(ErrorMessage.NON_EAT_SIZE.getErrorMessage());
        }
    }

    private void validateDuplicate(List<String> nonEat) {
        HashSet<String> nonDuplicateNonEatSet = new HashSet<>(nonEat);
        if (nonDuplicateNonEatSet.size() != nonEat.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_MENU.getErrorMessage());
        }
    }
}
