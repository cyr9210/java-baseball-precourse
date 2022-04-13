package baseball.domain;

import baseball.generator.NumberGenerator;
import camp.nextstep.edu.missionutils.Randoms;

public class Number {

    public static final int MAX = 9;
    public static final int MIN = 1;

    private final int number;

    public Number(int number) {
        if (number < MIN || number > MAX) {
            throw new IllegalArgumentException("1~9 사이의 숫자여야 합니다.");
        }
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    private static Number generate(NumberGenerator generator) {
        return new Number(generator.generate());
    }

    public static Number generateRandom() {
        return generate(() -> Randoms.pickNumberInRange(MIN, MAX));
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
