package baseball.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NumberTest {

    @DisplayName("1~9사이의 숫자를 생성한다.")
    @Test
    public void constructor() {
        int testInput = 3;
        Number number = new Number(testInput);
        assertEquals(testInput, number.getNumber());
    }

    @DisplayName("1~9사이의 숫자가 아닌 경우 IllegalArgumentException 발생")
    @ParameterizedTest
    @ValueSource(ints = {0, 10})
    public void constructor_fail(int number) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Number(number));
    }

}