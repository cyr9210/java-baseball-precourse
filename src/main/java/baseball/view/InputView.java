package baseball.view;

import baseball.domain.Number;
import baseball.domain.Numbers;
import baseball.generator.InputGenerator;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputView {

    private static final String INPUT_MESSAGE = "숫자를입력해주세요:";
    private static final String IS_CONTINUE_MESSAGE = "게임을새로시작하려면1,종료하려면2를입력하세요.";
    private static final String EXCEPTION_MESSAGE = "입력값은 숫자여야 합니다.";
    private static final int CONTINUE_INPUT = 1;

    public Numbers inputNumbers() {
        return inputNumbers(Console::readLine);
    }

    public Numbers inputNumbers(InputGenerator inputGenerator) {
        List<Number> numbers = new ArrayList<>(Number.MAX);
        System.out.println(INPUT_MESSAGE);
        String input = inputGenerator.input();
        String[] numberStrings = input.split("");
        for (final String numberString : numberStrings) {
            int number = parseInt(numberString);
            numbers.add(new Number(number));
        }
        return new Numbers(numbers);
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
        return isContinue == CONTINUE_INPUT;
    }

}
