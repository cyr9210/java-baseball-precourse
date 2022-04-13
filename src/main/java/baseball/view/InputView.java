package baseball.view;

import baseball.domain.Numbers;
import baseball.generator.InputGenerator;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputView {

    public static final String INPUT_MESSAGE = "숫자를입력해주세요:";
    public static final String IS_CONTINUE_MESSAGE = "게임을새로시작하려면1,종료하려면2를입력하세요.";
    public static final String EXCEPTION_MESSAGE = "입력값은 숫자여야 합니다.";

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
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
    }

    public Boolean inputContinue() {
        System.out.println(IS_CONTINUE_MESSAGE);
        String continueString = Console.readLine();
        int isContinue = Integer.parseInt(continueString);
        return isContinue == 1;
    }

}
