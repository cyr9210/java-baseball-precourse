package baseball.domain;

public class Result {

    private final int ball;
    private final int strike;

    public Result(int containsCount, int strikeCount) {
        this.ball = containsCount - strikeCount;
        this.strike = strikeCount;
    }

    public static Result Nothing() {
        return new Result(0, 0);
    }

    public boolean isNothing() {
        return ball == 0 && strike == 0;
    }

    public boolean isOnlyBall() {
        return ball > 0 && strike == 0;
    }

    public boolean isOnlyStrike() {
        return strike > 0 && ball == 0;
    }

    public boolean isContainsStrikeBall() {
        return strike > 0 && ball > 0;
    }

    public boolean isMatch() {
        return strike == 3;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }
}
