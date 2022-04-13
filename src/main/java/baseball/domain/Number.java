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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final Number number1 = (Number) o;

        return number == number1.number;
    }

}
