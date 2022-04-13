package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumbersTest {

    @DisplayName("서로 다른 1~9 사이의 숫자 3자리를 생성한다.")
    @Test
    public void generateNumbers() {
        Numbers numbers = Numbers.generate(this::createNumberMock);
        assertThat(numbers.getNumbers()).containsExactly(1, 2, 3);
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
        Numbers numbers = Numbers.generate(() -> Randoms.pickUniqueNumbersInRange(1, 9, 3));
        assertThat(numbers.getNumbers().get(0)).isBetween(1, 9);
        assertThat(numbers.getNumbers().get(1)).isBetween(1, 9);
        assertThat(numbers.getNumbers().get(2)).isBetween(1, 9);
    }

}