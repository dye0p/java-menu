package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import menu.model.Coach;
import menu.model.Coaches;
import menu.model.Menu;

public class RecommendService {

    private final Coaches coaches;
    private final List<String> categories = new ArrayList<>(); //한 주의 추천 카테고리

    public RecommendService(Coaches coaches) {
        this.coaches = coaches;
    }

    // 코치, 카테고리, 메뉴
    public void recommend() {
        //월~금 반복
        for (int i = 0; i < 5; i++) {
            //랜덤으로 번호를 생성해 카테고리를 가져온다.
            String category = recommendCategory();

            //각 코치가 먹을 음식을 정한다.
            //카테고리에 해당하는 메뉴 리스트를 가져온다.
            List<String> menus = Menu.getMenusBy(category);
            for (Coach coach : coaches.getCoaches()) {
                coach.recommendFrom(menus);
            }
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

    public Coaches getCoaches() {
        return coaches;
    }
}
