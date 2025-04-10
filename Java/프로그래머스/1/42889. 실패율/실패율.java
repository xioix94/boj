import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        
        Map<Integer, Integer> count = new HashMap<>();
        // count에 각 층에 대해 값 초기화
        for (int i = 1; i <= N; i++) {
            count.put(i, 0);
        }
        
        // 각 층에 있는 인원 추가
        int allClear = 0;
        for (int stage : stages) {
            if (stage == N + 1) {
                allClear++;
                continue;
            } else {
                count.put(stage, count.get(stage) + 1);
            }
        }
        
        // 실패율 계산
        ArrayList<Stage> failRate = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            int noClear = count.get(i);
            if (noClear == 0) {
                failRate.add(new Stage(i, 0));
                continue;
            }
            
            int clear = 0;
            for (int j = i; j <= N; j++) {
                clear += count.get(j);
            }
            
            clear += allClear;
            failRate.add(new Stage(i, (double) noClear / clear));
        }
        
        // 순서에 맞게 정렬
        failRate.sort((a, b) -> {
            if (a.failRate == b.failRate) {
                return a.num - b.num;
            } 
            
            return Double.compare(b.failRate, a.failRate);
        });
        
        for (int i = 0; i < N; i++) {
            answer[i] = failRate.get(i).num;
        }
        
        return answer;
    }
    
    class Stage {
        int num;
        double failRate;
        
        Stage (int num, double failRate) {
            this.num = num;
            this.failRate = failRate;
        }
    }
}