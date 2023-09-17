package baseball;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Computer implements Player {
    private static final int MAX_NUMBER = 9;

    private Integer[] numbers = null;

    @Override
    public Integer[] getNumbers() {
        if(numbers != null) {
            return numbers;
        }
        List<Integer> arr = IntStream.rangeClosed(1, MAX_NUMBER)
                .boxed()
                .collect(toList());
        Collections.shuffle(arr);

        numbers = arr.stream()
                .limit(3)
                .toArray(Integer[]::new);

        return numbers;
    }

    @Override
    public int size() {
        if(numbers == null) {
            getNumbers();
        }
        return numbers.length;
    }

    public int hasNumber(int number) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == number) {
                return i;
            }
        }
        return -1;
    }
}
