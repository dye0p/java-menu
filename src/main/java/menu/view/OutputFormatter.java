package menu.view;

import java.util.List;
import java.util.StringJoiner;
import menu.model.Coach;
import menu.model.Coaches;

public class OutputFormatter {

    public static String resultFormat(List<String> categories, Coaches coaches) {
        StringJoiner sj = new StringJoiner(System.lineSeparator());

        String categoryFormat = String.format("[ 카테고리 | %s | %s | %s | %s | %s ]",
                categories.get(0),
                categories.get(1),
                categories.get(2),
                categories.get(3),
                categories.get(4));

        sj.add(categoryFormat);

        for (Coach coach : coaches.getCoaches()) {
            String menuFormat = String.format("[ %s | %s | %s | %s | %s | %s ]",
                    coach.getName(),
                    coach.getRecommendMenu().get(0),
                    coach.getRecommendMenu().get(1),
                    coach.getRecommendMenu().get(2),
                    coach.getRecommendMenu().get(3),
                    coach.getRecommendMenu().get(4));

            sj.add(menuFormat);
        }

        return sj.toString();
    }
}
