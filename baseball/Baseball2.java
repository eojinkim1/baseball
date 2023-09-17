package baseball;

import java.util.*;

//## 🛠 구현 기능 목록 (배열 없이)
//        * 1-9사이의 숫자중 3개를 뽑아 3자리 수를 정한다.
//        * 3자리 수를 입력받는다.
//        * 받은 값이 3자리가 아닌 경우 예외 출력
//        * 받은 값이 숫자가 아닌 경우 예외 출력
//        * 받은 값에 중복된 숫자가 있을 시 예외 출력
//        * 입력값에 따라 힌트를 구분한다.
//        * 자리와 숫자 둘다 맞춘 경우 => 스트라이크
//        * 숫자는 같지만 자리가 다른 경우 => 볼
//        * 자리와 숫자 모두 틀린 경우 => 낫싱
//        * 게임의 승패 유무를 판단한다.
//        * 3스트라이크인 경우, 게임이 종료된다.
//        * 3스트라이크가 아니면 다음 라운드로 자동 진행된다.
//        * 게임 종료가 되면, 다시 게임을 진행할지 완전히 프로그램을 종료할 지를 출력한다.
//        * 1 입력 시 게임 재시작
//        * 2 입력 시 프로그램 종료
public class Baseball2 {
    private static final int MAX_NUMBER = 9;

    public static void main(String[] args) {
        //게임전체반복
        while(true) {
            Computer computer = new Computer();
            printComputerNumbers(computer.getNumbers());

            int gameCount = 0;
            while (true) {
                System.out.println("1~9사이의 정수 3개를 입력하세요");
                User user = new User(new UserInput());

                gameCount++;

                Referee.Result result = null;
                while(true) {
                    try {
                        result = new Referee().judge(computer, user);
                        break;
                    } catch (IllegalArgumentException e){
                        System.out.println("1~9사이의 정수 3개를 제대로 다시 입력하세요");
                    }
                }

                if (result.isNothing()) {
                    System.out.println("낫싱");
                }
                if (result.isAllStrike()) {
                    System.out.println("게임 종료!");
                    break;
                }
                System.out.printf("%d회\n", gameCount);
                System.out.printf("%d스트라이크 %d볼\n", result.strike, result.ball);
                System.out.println("=============================");
            }
            System.out.println("축하합니다! 다시 시작하겠습니까? 다시 시작 : 1, 종료 : 2");
            if (!new UserInput().restart()) {
                System.out.println("\n게임이 종료되었습니다.\n");
                break;
            }
        }
    }

    private static void printComputerNumbers(Integer[] com) {
        System.out.println("컴퓨터가 정한 값");
        for (int x : com) { // 컴퓨터 랜덤 숫자 확인
            System.out.print(x + " ");
        }
        System.out.println();
        System.out.println("=============================");
    }
}
