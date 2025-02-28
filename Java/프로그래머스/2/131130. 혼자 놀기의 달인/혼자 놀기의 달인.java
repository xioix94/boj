import java.util.*;

class Solution {
    public int solution(int[] cards) {
        int answer = 0;
        
        for (int i = 0; i < cards.length; i++) {
            int firstGroup = 0;
            int secondGroup = 0;
            boolean[] discovered = new boolean[cards.length];
            Arrays.fill(discovered, false);
            
            // 첫번째 사이클
            Stack<Integer> stack = new Stack<>();
            stack.add(cards[i]);
            discovered[i] = true;
            firstGroup++;
            while(true) {
                // 상자 안에 숫자는 인덱스보다 1 크므로 -1 필요
                int curr = stack.pop() - 1;
                if (discovered[curr]) {
                    break;
                }
                
                stack.add(cards[curr]);
                discovered[curr] = true;
                firstGroup++;
            }
            
            // 모든 상자를 연 경우 0 리턴
            if (firstGroup == cards.length) {
                return 0;
            }
            
            // 한 개의 상자만 남은 경우 firstGroup * 1이므로 firstGroup 리턴
            if (firstGroup == cards.length - 1) {
                return firstGroup;
            }
            
            // 두번째 사이클
            // discovered에서 순회하는데 false인 인덱스 모아서 새로운 배열 생성
            // discovered를 복사한 새로운 배열 만들어서 discovered 확인에 적용
            ArrayList<Integer> secondCardGroup = new ArrayList<>();
            for (int j = 0; j < discovered.length; j++) {
                if (!discovered[j]) {
                    secondCardGroup.add(j);
                }
            }
            
            for(int j : secondCardGroup) {
                boolean[] secondDiscovered = new boolean[cards.length];
                for (int k = 0; k < cards.length; k++) {
                    secondDiscovered[k] = discovered[k];
                }
                
                stack.add(cards[j]);
                secondDiscovered[j] = true;
                secondGroup++;
                while(true) {
                    // 상자 안에 숫자는 인덱스보다 1 크므로 -1 필요
                    int curr = stack.pop() - 1;
                    if (secondDiscovered[curr]) {
                        break;
                    }

                    stack.add(cards[curr]);
                    secondDiscovered[curr] = true;
                    secondGroup++;
                }
                
                // firstGroup * secondGroup 값과 result 비교해서 max값 저장 
                if (answer < firstGroup * secondGroup) {
                    answer = firstGroup * secondGroup;
                }
                
                secondGroup = 0;
            }
        }
        
        return answer;
    }
}