package menu.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {

    private static final String NEXT_LINE = System.lineSeparator();

    public List<String> readCoach() {
        System.out.println(NEXT_LINE + "코치의 이름을 입력해 주세요. (, 로 구분)");

        String coaches = Console.readLine();

        return InputConverter.convertCoaches(coaches);
    }

    public List<String> readNonEat(String name) {
        String format = String.format("%s(이)가 못 먹는 메뉴를 입력해 주세요.", name);
        System.out.println(NEXT_LINE + format);

        String nonEat = Console.readLine();

        return InputConverter.convertNonEat(nonEat);
    }
}
