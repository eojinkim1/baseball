package baseball;

public class User implements Player {
    private final UserInput input;

    public User(UserInput input) {
        this.input = input;
    }

    private Integer[] numbers = null;

    public Integer[] getNumbers() {
        if(numbers != null) {
            return numbers;
        }
        numbers = input.inputNumbers().getNumbers();
        return numbers;
    }

    public int getNumber(int i ){
        return numbers[i];
    }

    public int size() {
        if (numbers == null) {
            getNumbers();
        }
        return numbers.length;
    }
}
