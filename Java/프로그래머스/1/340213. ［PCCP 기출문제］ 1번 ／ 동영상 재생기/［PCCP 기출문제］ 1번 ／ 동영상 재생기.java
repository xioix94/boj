class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        int[] videoLenNum = divideToNumber(video_len);
        int[] posNum = divideToNumber(pos);
        int[] opStartNum = divideToNumber(op_start);
        int[] opEndNum = divideToNumber(op_end);

        checkOpening(opStartNum, opEndNum, posNum);

        for (String command : commands) {
            checkOpening(opStartNum, opEndNum, posNum);
            if (command.equals("prev")) {
                // 0분 10초 까지 -> 처음으로
                if (posNum[0] == 0 && posNum[1] <= 10) {
                    posNum[1] = 0;
                // 1분 이상 10초 미만인 경우
                } else if (posNum[0] > 0 && posNum[1] < 10) {
                    posNum[0]--;
                    posNum[1] = posNum[1] - 10 + 60;
                // 나머지 계산 쉬운 경우
                } else {
                    posNum[1] -= 10;
                }
            // command 가 next 인 경우
            } else {
                // 50초 이상인 경우
                if (posNum[1] >= 50) {
                    posNum[0]++;
                    posNum[1] = posNum[1] + 10 - 60;
                } else {
                    // 계산 쉬운 경우
                    posNum[1] += 10;
                }

                // 영상 끝인 경우
                if (videoLenNum[0] < posNum[0] || (videoLenNum[0] <= posNum[0] && videoLenNum[1] <= posNum[1])) {
                    posNum[0] = videoLenNum[0];
                    posNum[1] = videoLenNum[1];
                }
            }

            checkOpening(opStartNum, opEndNum, posNum);
        }

        if (posNum[0] < 10) {
            answer += "0" + posNum[0];
        } else {
            answer += Integer.toString(posNum[0]);
        }

        answer += ":";

        if (posNum[1] < 10) {
            answer += "0" + posNum[1];
        } else {
            answer += Integer.toString(posNum[1]);
        }

        return answer;
    }
    
    public int[] divideToNumber(String time) {
        int[] result = new int[2];
        String[] splitString = time.split(":");
        result[0] = Integer.parseInt(splitString[0]);
        result[1] = Integer.parseInt(splitString[1]);

        return result;
    }

    public void checkOpening(int[] opStartNum, int[] opEndNum, int[] posNum) {
        if ((opStartNum[0] < posNum[0] || opStartNum[0] == posNum[0] && opStartNum[1] <= posNum[1]) && (opEndNum[0] > posNum[0] || (opEndNum[0] == posNum[0] && opEndNum[1] >= posNum[1]))) {
            posNum[0] = opEndNum[0];
            posNum[1] = opEndNum[1];
        }
    }
}