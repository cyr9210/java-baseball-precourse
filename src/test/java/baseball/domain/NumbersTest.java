package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class NumbersTest {

    @DisplayName("서로 다른 1~9 사이의 숫자 3자리를 생성한다.")
    @Test
    public void generateNumbers() {
        Numbers numbers = new Numbers(createNumberMock(1, 2, 3));
        assertThat(numbers.getNumbers()).containsExactly(new Number(1), new Number(2), new Number(3));
    }

    private List<Number> createNumberMock(int first, int second, int third) {
        List<Number> numbers = new ArrayList<>();
        numbers.add(new Number(first));
        numbers.add(new Number(second));
        numbers.add(new Number(third));
        return numbers;
    }

    @DisplayName("서로 다른 1~9사이의 숫자 3자리를 랜덤으로 생성한다.")
    @Test
    public void generateRandomNumbers() {
        Numbers numbers = Numbers.generateRandom();
        assertEquals(numbers.getNumbers().size(), Numbers.SIZE);
        assertThat(numbers.getNumber(0)).isBetween(Number.MIN, Number.MAX);
        assertThat(numbers.getNumber(1)).isBetween(Number.MIN, Number.MAX);
        assertThat(numbers.getNumber(2)).isBetween(Number.MIN, Number.MAX);
    }

    @DisplayName("숫자가 4자리 이상인 경우, IllegalArgumentException 발생")
    @Test
    public void generateNumbers_fail() {
        List<Number> numbersMock = createNumberMock(1, 2, 3);
        numbersMock.add(new Number(4));

        assertThatIllegalArgumentException().isThrownBy(() -> new Numbers(numbersMock));
    }

    @DisplayName("포함된 숫자의 갯수를 구한다.")
    @ParameterizedTest
    @CsvSource(value = {"3,1,2,3", "4,1,2,2", "4,5,2,1", "4,5,6,0"})
    public void getContainsCount(int inputFirst, int inputSecond, int inputThird, int result) {
        Numbers answer = new Numbers(createNumberMock(1, 2, 3));
        Numbers inputNumbers = new Numbers(createNumberMock(inputFirst, inputSecond, inputThird));
        int containsCount = answer.getContainsCount(inputNumbers);
        assertEquals(result, containsCount);
    }

    @DisplayName("위치가 같은 숫자의 갯수를 구한다.")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,3", "1,2,4,2", "1,4,5,1", "3,1,2,0"})
    public void getStrikeCount(int inputFirst, int inputSecond, int inputThird, int result) {
        Numbers answer = new Numbers(createNumberMock(1, 2, 3));
        Numbers inputNumbers = new Numbers(createNumberMock(inputFirst, inputSecond, inputThird));
        int containsCount = answer.getStrikeCount(inputNumbers);
        assertEquals(result, containsCount);
    }

}