package menu.view;

import java.util.List;
import menu.model.Coaches;

public class OutputView {

    private static final String NEXT_LINE = System.lineSeparator();

    public void printWellComeMessage() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }

    public void printResult(List<String> categories, Coaches coaches) {
        String resultFormat = OutputFormatter.resultFormat(categories, coaches);

        System.out.println(NEXT_LINE + "메뉴 추천 결과입니다.");
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        System.out.println(resultFormat);

        printEnd();
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }

    private void printEnd() {
        System.out.println(NEXT_LINE + "추천을 완료했습니다.");
    }
}
