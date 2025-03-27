import java.util.*;

class Solution {
    // privacies : ["2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"]
    public int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        Map<String, Integer> termsMap = new HashMap<>();
        for (String term : terms) {
            String[] splited = term.split(" ");
            termsMap.put(splited[0], Integer.parseInt(splited[1]));
        }
        
        for (int i = 0; i < privacies.length; i++) {
            // privacy : "2021.05.02 A"
            String privacy = privacies[i];
            int[] expiration = getExpiration(privacy, termsMap);
            if (isBad(today, expiration)) {
                answer.add(i + 1);
            }
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    // 수집 날짜와 약관 종류를 넣으면 만기 날짜를 구하는 함수
    public int[] getExpiration(String privacy, Map<String, Integer> termsMap) {
        // splited : ["2021.05.02", "A"];
        
        String[] splited = privacy.split(" ");
        // expirationList : ["2021", "05", "02"]
        String[] expirationList = splited[0].split("\\.");
        System.out.println();
        // expiration : [2021, 5, 2]
        int[] expiration = new int[expirationList.length];
        for (int i = 0; i < expirationList.length; i++) {
            expiration[i] = Integer.parseInt(expirationList[i]);
        }
        int term = termsMap.get(splited[1]);
        expiration[1] += term; // 월 더하기
        expiration[0] += expiration[1] / 12; // 연도 계산
        expiration[1] = expiration[1] % 12; // 월 계산
        if (expiration[1] == 0) { // 12의 배수일 때
            expiration[1] = 12;
            expiration[0] -= 1;
        }

        expiration[2] -= 1; // 날짜 조정
        if (expiration[2] == 0) {
            expiration[2] = 28;
            expiration[1] -= 1;
            if (expiration[1] == 0) {
                expiration[1] = 12;
                expiration[0] -= 1;
            }
        }
        
        return expiration;
    }
    
    // 만기 날짜와 오늘 날짜를 비교하여 만기인지 구하는 함수 만기 = true, 유효 = false
    public boolean isBad(String today, int[] expiration) {
        String[] todayList = today.split("\\.");
        ArrayList<Integer> todayArray = new ArrayList<>();
        for (String s : todayList) {
            todayArray.add(Integer.parseInt(s));
        }
        
        if (expiration[0] < todayArray.get(0)) {
            return true;
        }
        
        if ((expiration[0] == todayArray.get(0)) && expiration[1] < todayArray.get(1)) {
            return true;
        }
        
        if ((expiration[0] == todayArray.get(0)) && (expiration[1] == todayArray.get(1)) && expiration[2] < todayArray.get(2)) {
            return true;
        }
        
        return false;
    }
}