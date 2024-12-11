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
}
