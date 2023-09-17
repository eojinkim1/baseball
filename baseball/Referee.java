package baseball;

public class Referee {
    public Result judge(Computer computer, User user) {
        int strikeCnt = 0, ballCnt = 0;

        for (int i = 0; i < user.size(); i++) {
            int targetValue = user.getNumber(i);
            int index = computer.hasNumber(targetValue);

            if (index == i) {
                strikeCnt++;
            } else if (index >= 0) {
                ballCnt++;
            }
        }
        return new Result(strikeCnt, ballCnt);
    }

    class Result {
        int strike;
        int ball;

        public Result(int strike, int ball) {
            this.strike = strike;
            this.ball = ball;
        }

        public boolean isNothing() {
            return strike ==0 && ball == 0;
        }

        public boolean isAllStrike() {
            return strike == 3;
        }
    }
}