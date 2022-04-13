package baseball.service;

import baseball.domain.Numbers;
import baseball.generator.InputGenerator;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputService {

    public static final String INPUT_MESSAGE = "숫자를입력해주세요:";

    public Numbers inputNumbers() {
        return inputNumbers(Console::readLine);
    }

    public Numbers inputNumbers(InputGenerator inputGenerator) {
        List<Integer> numbers = new ArrayList<>(Numbers.MAX);
        System.out.println(INPUT_MESSAGE);
        String input = inputGenerator.input();
        String[] numberStrings = input.split("");
        for (final String numberString : numberStrings) {
            parseInt(numberString);
            numbers.add(Integer.parseInt(numberString));
        }
        return Numbers.generate(() -> numbers);
    }

    private int parseInt(String numberString) {
        try {
            return Integer.parseInt(numberString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력값은 숫자여야 합니다.");
        }
    }

}
