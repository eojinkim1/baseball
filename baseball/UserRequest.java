package baseball;

import java.util.Arrays;

public class UserRequest {
    private String input;

    public UserRequest(String input){
        if(input.length() != 3) {
            throw new IllegalArgumentException("abc");
        }

        this.input = input;
    }

    public Integer[] getNumbers() {
        return Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);
    }
}
