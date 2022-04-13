package baseball;

import baseball.controller.GameController;
import baseball.domain.Numbers;
import baseball.domain.Result;
import baseball.view.InputView;
import baseball.view.ResultView;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        play(inputView, resultView);
        while (inputView.inputContinue()) {
            play(inputView, resultView);
        }
    }

    private static void play(InputView inputView, ResultView resultView) {
        GameController controller = new GameController(Numbers.generateRandom());
        Result result = playOneTime(inputView, resultView, controller);
        while (!result.isMatch()) {
            result = playOneTime(inputView, resultView, controller);
        }
    }

    private static Result playOneTime(InputView inputView, ResultView resultView, GameController controller) {
        Result result = controller.game(inputView.inputNumbers());
        resultView.printResult(result);
        return result;
    }

}
