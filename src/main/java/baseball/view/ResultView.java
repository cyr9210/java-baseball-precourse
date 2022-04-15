package baseball.view;

import baseball.domain.Result;

public class ResultView {

    private static final String BALL_MESSAGE = "볼";
    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String NOTHING = "낫싱";
    private static final String BLANK = " ";

    public void printResult(Result result) {
        System.out.println(getResultMessage(result));
    }

    private String getResultMessage(Result result) {
        if (result.isNothing()) {
            return NOTHING;
        }
        StringBuilder builder = new StringBuilder();
        if (result.isContainsBall()) {
            builder.append(result.getBall()).append(BALL_MESSAGE).append(BLANK);
        }
        if (result.isContainsStrike()) {
            builder.append(result.getStrike()).append(STRIKE_MESSAGE);
        }
        return builder.toString();
    }

}
