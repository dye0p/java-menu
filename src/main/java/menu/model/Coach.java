package menu.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import menu.exception.ErrorMessage;

public class Coach {

    private final String name;
    private NonEat nonEat;
    private final List<String> recommendMenu = new ArrayList<>();

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

    public void recommendFrom(List<String> menus) {
        //메뉴 리스트를 섞고 첫 번째 메뉴를 가져온다.
        String firstMenu = Randoms.shuffle(menus).get(0);

        //이미 추천 했거나, 못 먹거나
        if (recommendMenu.contains(firstMenu) || nonEat.isContain(firstMenu)) {
            recommendFrom(menus);
        }
        //메뉴가 추가할 수 있는 경우 추가한다.
        recommendMenu.add(firstMenu);
    }

    public List<String> getRecommendMenu() {
        return new ArrayList<>(recommendMenu);
    }
}
