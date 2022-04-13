package baseball.controller;

import baseball.domain.Numbers;
import baseball.domain.Result;

public class GameController {

    private final Numbers answer;

    public GameController(Numbers answer) {
        this.answer = answer;
    }

    public Result game(Numbers inputNumbers) {
        int containsCount = answer.getContainsCount(inputNumbers);
        if (containsCount == 0) {
            return Result.Nothing();
        }

        int strikeCount = answer.getStrikeCount(inputNumbers);
        return new Result(containsCount, strikeCount);
    }

}
