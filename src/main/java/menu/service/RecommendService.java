package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import menu.model.Coaches;
import menu.model.DayOfWeek;
import menu.model.Menu;

public class RecommendService {

    private final Coaches coaches;
    private final List<String> categories = new ArrayList<>();

    public RecommendService(Coaches coaches) {
        this.coaches = coaches;
    }

    // 코치, 카테고리, 메뉴
    public void recommend() {
        //월~금 반복
        for (DayOfWeek dayOfWeek : DayOfWeek.values()) {
            //랜덤으로 번호를 생성해 카테고리를 가져온다.
            String category = recommendCategory();

            //각 코치가 먹을 음식을 정한다.
            List<String> menus = Menu.getMenusBy(category);
            coaches.recommendMenu(menus);
        }
    }

    private String recommendCategory() {
        String category = getRandomCategory();

        //일주일의 카테고리 목록에 포함이 되어 있다면 카운트 +1
        long sameCategoryCount = categories.stream()
                .filter(value -> value.equals(category))
                .count();

        //2회 미만이라면 add
        if (sameCategoryCount < 2) {
            categories.add(category);
            return category;
        }

        return recommendCategory();
    }

    private String getRandomCategory() {
        int randomNumber = Randoms.pickNumberInRange(1, 5);
        return Menu.getCategoryBy(randomNumber);
    }

    public List<String> getCategories() {
        return categories;
    }
}
