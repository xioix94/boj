import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        Map<Integer, Integer> clothes = new HashMap<>();
        
        // clothes 1로 초기화
        for (int i = 1; i <= n; i++) {
            clothes.put(i, 1);
        }
        
        // lost 만큼 제거
        for (int l : lost) {
            clothes.put(l, clothes.get(l) - 1);
        } 
        
        // reserve 만큼 추가
        for (int r : reserve) {
            clothes.put(r, clothes.get(r) + 1);
        }
        
        System.out.println(clothes);
        
        // 왼쪽에 있는 인원의 옷을 우선적으로 빌림
        for (int i = 1; i <= n; i++) {
            if (clothes.get(i) == 0) {
                System.out.println(i);
                getClothes(i, n, clothes);
                System.out.println(clothes);
            }
        }
        
        // 전체에서 0인 경우 뻄
        for (int i = 1; i <= n; i++) {
            System.out.format("i = %d    clothes.get(%d) = %d\n", i, i, clothes.get(i));
            if (clothes.get(i) == 0) {
                answer--;
            }
        }
        
        
        return answer;
    }
    
    void getClothes(int i, int n, Map<Integer, Integer> clothes) {
        // 1인 경우
        if (i == 1) {
            if (clothes.get(i + 1) == 2) {
                clothes.put(i, 1);
                clothes.put(i + 1, 1);
            }
            
            return;
        }
        
        // n인 경우
        if (i == n) {
            if (clothes.get(i - 1) == 2) {
                clothes.put(i, 1);
                clothes.put(i - 1, 1);
            }
            
            return;
        }
        
        System.out.println("여기");
        // 가운데인 경우 - 왼쪽부터 체크하고 없으면 오른쪽 체크
        System.out.format("i = %d   %d\n", i - 1, clothes.get(i - 1));
        if (clothes.get(i - 1) == 2) {
            System.out.println("여기2");
            clothes.put(i, 1);
            clothes.put(i - 1, 1);
            return;
        }
        
        if (clothes.get(i + 1) == 2) {
            System.out.println("여기3");
            clothes.put(i, 1);
            clothes.put(i + 1, 1);
        }
        
        System.out.println("여기4");
    }
}