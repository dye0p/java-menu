package menu.model;

import java.util.List;
import menu.exception.ErrorMessage;

public class NonEat {

    private final List<String> nonEat;

    public NonEat(List<String> nonEat) {
        validateSize(nonEat);
        this.nonEat = nonEat;
    }

    private void validateSize(List<String> nonEat) {
        if (nonEat.size() > 2) {
            throw new IllegalArgumentException(ErrorMessage.NON_EAT_SIZE.getErrorMessage());
        }
    }
}
