package baseball.domain;

import baseball.generator.NumberGenerator;
import java.util.List;

public class Numbers {

    private final List<Integer> numbers;

    private Numbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Numbers generate(NumberGenerator generator) {
        return new Numbers(generator.generate());
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
