package menu.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import menu.exception.ErrorMessage;

public class Coaches {

    private static final int MIN_COACH_SIZE = 2;
    private static final int MAX_COACH_SIZE = 5;

    private final List<Coach> coaches;

    public Coaches(List<Coach> coaches) {
        validateSize(coaches);
        validateDuplicate(coaches);
        this.coaches = coaches;
    }

    public List<Coach> getCoaches() {
        return new ArrayList<>(coaches);
    }

    private void validateDuplicate(List<Coach> coaches) {
        HashSet<Coach> nonDuplicateCoachSet = new HashSet<>(coaches);
        if (nonDuplicateCoachSet.size() != coaches.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_COACH.getErrorMessage());
        }
    }

    private void validateSize(List<Coach> coaches) {
        if (coaches.size() < MIN_COACH_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.MIN_COACH_SIZE.getErrorMessage());
        }
        if (coaches.size() > MAX_COACH_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.MAX_COACH_SIZE.getErrorMessage());
        }
    }
}
