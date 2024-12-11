package menu.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import menu.exception.ErrorMessage;

public class Coaches {

    private final List<Coach> coaches;

    public Coaches(List<Coach> coaches) {
        validateSize(coaches);
        validateDuplicate(coaches);
        this.coaches = coaches;
    }

    private void validateDuplicate(List<Coach> coaches) {
        HashSet<Coach> nonDuplicateCoachSet = new HashSet<>(coaches);
        if (nonDuplicateCoachSet.size() != coaches.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_COACH.getErrorMessage());
        }
    }

    private void validateSize(List<Coach> coaches) {
        if (coaches.size() < 2) {
            throw new IllegalArgumentException(ErrorMessage.MIN_COACH_SIZE.getErrorMessage());
        }

        if (coaches.size() > 5) {
            throw new IllegalArgumentException(ErrorMessage.MAX_COACH_SIZE.getErrorMessage());
        }
    }

    public List<Coach> getCoaches() {
        return new ArrayList<>(coaches);
    }
}
