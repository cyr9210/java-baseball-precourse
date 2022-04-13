package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumbersTest {

    @DisplayName("서로 다른 1~9 사이의 숫자 3자리를 생성한다.")
    @Test
    public void generateNumbers() {
        Numbers numbers = Numbers.generate(this::createNumberMock);
        assertThat(numbers.getNumbers()).containsExactly(new Number(1), new Number(2), new Number(3));
    }

    private List<Integer> createNumberMock() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        return numbers;
    }

    @DisplayName("서로 다른 1~9사이의 숫자 3자리를 랜덤으로 생성한다.")
    @Test
    public void generateRandomNumbers() {
        Numbers numbers = Numbers.generateRandom();
        assertEquals(numbers.getNumbers().size(), Numbers.SIZE);
        assertThat(numbers.getNumber(0)).isBetween(Numbers.MIN, Numbers.MAX);
        assertThat(numbers.getNumber(1)).isBetween(Numbers.MIN, Numbers.MAX);
        assertThat(numbers.getNumber(2)).isBetween(Numbers.MIN, Numbers.MAX);
    }

    @DisplayName("숫자가 4자리 이상인 경우, IllegalArgumentException 발생")
    @Test
    public void generateNumbers_fail() {
        List<Integer> numberMock = createNumberMock();
        numberMock.add(4);

        assertThatIllegalArgumentException().isThrownBy(() -> Numbers.generate(() -> numberMock));
    }

}