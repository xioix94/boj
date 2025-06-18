import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        if (cacheSize == 0) {
            return cities.length * 5;
        }
        
        // 영소문자로 통일
        for (int i = 0; i < cities.length; i++) {
            cities[i] = cities[i].toLowerCase();    
        }
        
        HashMap<String, Integer> map = new HashMap<>();
        for (String city : cities) {
            // city가 map에 있는 지 확인
            //  있으면 0으로 초기화 후 종료 -> answer++
            if (map.containsKey(city)) {
                map.put(city, 0);
                answer++;
                for (String tempCity : map.keySet()) {
                    if (!tempCity.equals(city)) {
                        map.put(tempCity, map.get(tempCity) + 1);
                    }
                }
                
                continue;
            }
            
            if (map.size() == 0) {
                map.put(city, 0);
                answer += 5;
                continue;
            }
            
            // 없으면 추가 answer += 5
            // map < cacheSize인 경우 0으로 추가
            if (map.size() < cacheSize) {
                map.put(city, 0);
            // map == cacheSize인 경우 제일 큰 값 제거 후 0으로 추가
            } else if (map.size() == cacheSize) {
                int max = -1;
                String maxCity = "";
                for (String tempCity : map.keySet()) {
                    if (max < map.get(tempCity)) {
                        max = map.get(tempCity);
                        maxCity = tempCity;
                    }
                }
                
                map.remove(maxCity);
                map.put(city, 0);
            }
            
            answer += 5;
            
            // 나머지 ++
            for (String tempCity : map.keySet()) {
                if (!tempCity.equals(city)) {
                    map.put(tempCity, map.get(tempCity) + 1);
                }
            }
        }
        
        return answer;
    }
}