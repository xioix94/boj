import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        // id_list의 중복값을 set을 이용해 제거
        Set<String> set = new HashSet<>();
        for (String s : report) {
            set.add(s);
        }
        
        Map<String, Set<String>> singo = new HashMap<>();
        
        // 기본 ArrayList 생성
        for (String s : id_list) {
            Set<String> temp = new HashSet<>();
            singo.put(s, temp);
        }
        
        // report 돌면서 신고 수 셈
        Map<String, Integer> reported = new HashMap<>();
        for (String r : set) {
            String[] splited = r.split(" ");
            
            // 신고 당한 횟수 추가 
            if (!reported.containsKey(splited[1])) {
                reported.put(splited[1], 1);
            } else {
                reported.put(splited[1], reported.get(splited[1]) + 1);
            }
            
            // 신고한 사람 리스트 추가
            singo.get(splited[0]).add(splited[1]);
        }
        
        // 신고 횟수 세서 k 이상인 경우 모아서 정리
        ArrayList<String> overed = new ArrayList<>();
        for (String key : reported.keySet()) {
            if (reported.get(key) >= k) {
                overed.add(key);
            }
        }
        
        // singo에서 한 명씩 신고한 사람 리스트 뽑아서 overed에 있는 지 확인해서 개수 센 후 answer에 추가
        int index = 0;
        for (int i = 0; i < id_list.length; i++) {
            String key = id_list[i];
            int count = 0;
            Set<String> targets = singo.get(key);
            for (String target : targets) {
                if (overed.contains(target)) {
                    count++;
                }
            }
            
            answer[index] = (count);
            index++;
        }
        
        return answer;
    }
}