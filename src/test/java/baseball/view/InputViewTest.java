package baseball.view;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

import baseball.domain.Numbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {

    @DisplayName("입력받은 값으로 Numbers를 생성한다.")
    @Test
    public void inputNumbers() {
        InputView service = new InputView();
        Numbers numbers = service.inputNumbers(() -> "123");
        assertEquals(numbers.getNumbers().size(), 3);
        assertEquals(numbers.getNumber(0), 1);
        assertEquals(numbers.getNumber(1), 2);
        assertEquals(numbers.getNumber(2), 3);
    }

    @DisplayName("입력값이 숫자가 아닌 경우, IllegalArgumentException 발생")
    @Test
    public void inputNumbers_fail() {
        InputView service = new InputView();
        assertThatIllegalArgumentException().isThrownBy(() -> service.inputNumbers(() -> "a123"));
    }

}