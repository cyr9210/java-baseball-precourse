package baseball.service;

import baseball.domain.Numbers;

public class GameService {

    public void check(Numbers answer, Numbers inputNumbers) {
        int containsCount = answer.getContainsCount(inputNumbers);
        int strikeCount = answer.getStrikeCount(inputNumbers);
    }
}
