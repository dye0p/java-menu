package menu.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import menu.exception.ErrorMessage;

public class Coach {

    private static final int INDEX = 0;
    private static final int MAX_NAME_SIZE = 4;
    private static final int MIN_NAME_SIZE = 2;

    private final String name;
    private NonEat nonEat;
    private final List<String> recommendMenu = new ArrayList<>();

    public Coach(String name) {
        validateSize(name);
        this.name = name;
    }

    public void recommendFrom(List<String> menus) {
        //메뉴 리스트를 섞고 첫 번째 메뉴를 가져온다.
        String firstMenu = shuffleMenu(menus);
        if (canNotRecommend(firstMenu)) {
            recommendFrom(menus);
        }
        recommendMenu.add(firstMenu);
    }

    private String shuffleMenu(List<String> menus) {
        return Randoms.shuffle(menus).get(INDEX);
    }

    private boolean canNotRecommend(String firstMenu) {
        return recommendMenu.contains(firstMenu) || nonEat.isContain(firstMenu);
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

    public List<String> getRecommendMenu() {
        return new ArrayList<>(recommendMenu);
    }

    private void validateSize(String name) {
        if (name.length() > MAX_NAME_SIZE || name.length() < MIN_NAME_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.NAME_SIZE.getErrorMessage());
        }
    }
}
