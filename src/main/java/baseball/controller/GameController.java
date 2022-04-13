package baseball.controller;

import baseball.domain.Numbers;
import baseball.service.GameService;
import baseball.service.InputService;

public class GameController {

    private static final GameService gameService = new GameService();
    private static final InputService inputService = new InputService();

    private final Numbers answer;

    public GameController(Numbers answer) {
        this.answer = answer;
    }

    public void game() {

    }



}
