package menu.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import menu.model.Coach;
import menu.model.Coaches;
import menu.model.NonEat;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {

    private final InputView inputView;
    private final OutputView outputView;

    public MenuController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        outputView.printWellComeMessage();
        Coaches coaches = tryReadCoaches();

        for (Coach coach : coaches.getCoaches()) {
            tryNonEat(coach);
        }
    }

    private void tryNonEat(Coach coach) {
        requestRead(() -> {
            List<String> nonEats = inputView.readNonEat(coach.getName());
            NonEat nonEat = new NonEat(nonEats);
            coach.updateNonEat(nonEat);
            return null;
        });
    }


    private Coaches tryReadCoaches() {
        return requestRead(() -> {
            List<String> readCoach = inputView.readCoach();
            return createCoaches(readCoach);
        });
    }

    private Coaches createCoaches(List<String> readCoach) {
        List<Coach> coaches = new ArrayList<>();
        for (String name : readCoach) {
            Coach coach = new Coach(name);
            coaches.add(coach);
        }
        return new Coaches(coaches);
    }


    private <T> T requestRead(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException exception) {
                outputView.printErrorMessage(exception.getMessage());
            }
        }
    }
}
