package baseball.domain;

import baseball.generator.NumberGenerator;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Numbers {

    public static final int SIZE = 3;
    public static final int MAX = 9;
    public static final int MIN = 1;

    private final List<Number> numbers = new ArrayList<>(3);

    private Numbers(List<Integer> numbers) {
        if (numbers.size() > 3) {
            throw new IllegalArgumentException("숫자는 3자리여야 합니다.");
        }
        for (int number : numbers) {
            this.numbers.add(new Number(number));
        }
    }

    public static Numbers generate(NumberGenerator generator) {
        return new Numbers(generator.generate());
    }

    public static Numbers generateRandom() {
        return generate(() -> Randoms.pickUniqueNumbersInRange(MIN, MAX, SIZE));
    }

    public List<Number> getNumbers() {
        return numbers;
    }

    public int getNumber(int index) {
        return numbers.get(index).getNumber();
    }

    public int getContainsCount(Numbers inputNumbers) {
        int count = 0;
        for (final Number number : inputNumbers.numbers) {
            count = plusCount(count, number);
        }
        return count;
    }

    private int plusCount(int count, Number inputNumber) {
        if (numbers.contains(inputNumber)) {
            count++;
        }
        return count;
    }

    public void getStrike(Numbers inputNumbers) {
        int count = 0;
    }
}
