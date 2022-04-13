package baseball.domain;

public class Number {

    private final int number;

    public Number(int number) {
        if (number < 1 || number > 9) {
            throw new IllegalArgumentException("1~9 사이의 숫자여야 합니다.");
        }
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
