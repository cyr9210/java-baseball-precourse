package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class Numbers {

    private static final String SIZE_EXCEPTION_MESSAGE = "숫자는 3자리여야 합니다.";
    public static final int SIZE = 3;

    private final List<Number> numbers = new ArrayList<>(3);

    public Numbers(List<Number> numbers) {
        this.numbers.addAll(numbers);
        if (numbers.size() != SIZE) {
            throw new IllegalArgumentException(SIZE_EXCEPTION_MESSAGE);
        }
    }

    public static Numbers generateRandom() {
        List<Number> list = new ArrayList<>();
        while (list.size() != SIZE) {
            Number number = Number.generateRandom();
            addNumbers(list, number);
        }
        return new Numbers(list);
    }

    private static void addNumbers(List<Number> list, Number number) {
        if (!list.contains(number)) {
            list.add(number);
        }
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
            count = plusContainsCount(count, number);
        }
        return count;
    }

    private int plusContainsCount(int count, Number inputNumber) {
        if (numbers.contains(inputNumber)) {
            count++;
        }
        return count;
    }

    public int getStrikeCount(Numbers inputNumbers) {
        int count = 0;
        for (int i = 0; i < numbers.size(); i++) {
            count = plusStrikeCount(inputNumbers, count, i);
        }
        return count;
    }

    private int plusStrikeCount(Numbers inputNumbers, int count, int i) {
        if (getNumber(i) == inputNumbers.getNumber(i)) {
            count++;
        }
        return count;
    }

}
