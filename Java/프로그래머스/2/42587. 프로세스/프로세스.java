import java.util.*;

class CustomClass {
    String name;
    int priority;
    
    CustomClass(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }
    
    int getPriority() {
        return priority;
    }
    
    String getName() {
        return name;
    }
}

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        LinkedList<CustomClass> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            if (i == location) {
                queue.offer(new CustomClass("target", priorities[i]));
            } else {
                queue.offer(new CustomClass("no", priorities[i]));
            }
        }
        
        while(true) {
            CustomClass temp = queue.poll();
            boolean isGood = true;
            
            // 우선순위에 밀려서 다시 넣는 경우
            for (int i = 0; i < queue.size(); i++) {
                if (temp.getPriority() < queue.get(i).getPriority()) {
                    queue.offer(temp);
                    isGood = false;
                    break;
                }
            }
            
            // 뺀 것에 대한 계산
            if (isGood) {
                answer++;
                if (temp.getName().equals("target")) {
                    break;
                }
            }
        }
        
        return answer;
    }
}