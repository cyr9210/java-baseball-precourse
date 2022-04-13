package baseball.view;

import baseball.domain.Result;

public class ResultView {

    private static final String ONLY_BALL_MESSAGE = "%s볼";
    private static final String ONLY_STRIKE_MESSAGE = "%s스트라이크";
    private static final String BALL_STRIKE_MESSAGE = "%s볼 %s스트라이크";
    private static final String NOTHING = "낫싱";

    public void printResult(Result result) {
        if (result.isNothing()) {
            System.out.println(NOTHING);
        }
        if (result.isContainsStrikeBall()) {
            System.out.println(String.format(BALL_STRIKE_MESSAGE, result.getBall(), result.getStrike()));
        }
        if (result.isOnlyBall()) {
            System.out.println(String.format(ONLY_BALL_MESSAGE, result.getBall()));
        }
        if (result.isOnlyStrike()) {
            System.out.println(String.format(ONLY_STRIKE_MESSAGE, result.getStrike()));
        }
    }

}
