package menu.view;

import java.util.List;
import java.util.StringJoiner;
import menu.model.Coach;
import menu.model.Coaches;

public class OutputFormatter {

    private static final String MENU_FORMAT = "[ %s | %s | %s | %s | %s | %s ]";
    private static final String CATEGORY_FORMAT = "[ 카테고리 | %s | %s | %s | %s | %s ]";

    public static String resultFormat(List<String> categories, Coaches coaches) {
        StringJoiner sj = new StringJoiner(System.lineSeparator());

        formatingCategories(categories, sj);
        formatingMenus(coaches, sj);

        return sj.toString();
    }

    private static void formatingMenus(Coaches coaches, StringJoiner sj) {
        for (Coach coach : coaches.getCoaches()) {
            String menuFormat = String.format(MENU_FORMAT,
                    coach.getName(),
                    coach.getRecommendMenu().get(0),
                    coach.getRecommendMenu().get(1),
                    coach.getRecommendMenu().get(2),
                    coach.getRecommendMenu().get(3),
                    coach.getRecommendMenu().get(4));

            sj.add(menuFormat);
        }
    }

    private static void formatingCategories(List<String> categories, StringJoiner sj) {
        String categoryFormat = String.format(CATEGORY_FORMAT,
                categories.get(0),
                categories.get(1),
                categories.get(2),
                categories.get(3),
                categories.get(4));

        sj.add(categoryFormat);
    }
}
