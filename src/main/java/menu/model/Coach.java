package menu.model;

import java.util.Objects;
import menu.exception.ErrorMessage;

public class Coach {

    private final String name;
    private NonEat nonEat;

    public Coach(String name) {
        if (name.length() > 4 || name.length() < 2) {
            throw new IllegalArgumentException(ErrorMessage.NAME_SIZE.getErrorMessage());
        }

        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Coach coach = (Coach) o;
        return Objects.equals(name, coach.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    public String getName() {
        return name;
    }

    public void updateNonEat(NonEat nonEat) {
        this.nonEat = nonEat;
    }
}
