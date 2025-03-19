import java.util.Arrays;

class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = schedules.length;
        for (int i = 0; i < schedules.length; i++) {
            for (int j = 0; j < timelogs[0].length; j++) {
                int day = (j + startday - 1) % 7;
                if (day == 5 || day == 6) {
                    continue;
                }

                int inTime = schedules[i] + 10;
                if (inTime % 100 > 59) {
                    inTime += 100;
                    inTime -= 60;
                }

                if (inTime < timelogs[i][j]) {
                    answer--;
                    break;
                }
            }
        }

        return answer;
    }
}