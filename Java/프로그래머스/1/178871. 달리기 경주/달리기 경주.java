import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        Map<Integer, String> order = new HashMap<>();
        Map<String, Integer> member = new HashMap<>();
        
        for (int i = 0; i < players.length; i++) {
            order.put(i, players[i]);
            member.put(players[i], i);
        }
        
        for (String overTakingMemberName : callings) {
            int overTakingMemberOrder = member.get(overTakingMemberName);
            int overTakenMemberOrder = overTakingMemberOrder - 1;
            String overTakenMemberName = order.get(overTakingMemberOrder - 1);
            
            // order 변경
            String temp = overTakenMemberName;
            order.put(overTakenMemberOrder, overTakingMemberName);
            order.put(overTakingMemberOrder, temp);
            
            // member 변경
            int temp2 = overTakenMemberOrder;
            member.put(overTakenMemberName, overTakingMemberOrder);
            member.put(overTakingMemberName, temp2);
        }
        
        for (int i = 0; i < order.size(); i++) {
            answer[i] = order.get(i);
        }
        
        return answer;
    }
}