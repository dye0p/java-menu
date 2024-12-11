package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import menu.model.Coaches;
import menu.model.DayOfWeek;
import menu.model.Menu;

public class RecommendService {

    private static final int MAX_RECOMMEND_CATEGORY_COUNT = 2;
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 5;

    private final Coaches coaches;
    private final List<String> categories = new ArrayList<>();

    public RecommendService(Coaches coaches) {
        this.coaches = coaches;
    }

    public void recommend() {
        for (DayOfWeek dayOfWeek : DayOfWeek.values()) {
            String category = recommendCategory();

            List<String> menus = Menu.getMenusBy(category);
            coaches.recommendMenu(menus);
        }
    }

    private String recommendCategory() {
        String category = getRandomCategory();

        long sameCategoryCount = calculateSameCategory(category);
        if (canRecommendCategory(sameCategoryCount)) {
            categories.add(category);
            return category;
        }

        return recommendCategory();
    }

    private boolean canRecommendCategory(long sameCategoryCount) {
        return sameCategoryCount < MAX_RECOMMEND_CATEGORY_COUNT;
    }

    private long calculateSameCategory(String category) {
        return categories.stream()
                .filter(value -> value.equals(category))
                .count();
    }

    private String getRandomCategory() {
        int randomNumber = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
        return Menu.getCategoryBy(randomNumber);
    }

    public List<String> getCategories() {
        return categories;
    }
}
