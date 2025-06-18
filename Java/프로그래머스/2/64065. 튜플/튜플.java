import java.util.*;

class Solution {
    public int[] solution(String s) {
        int index = 0;
        
        // s 분해 -> 이중리스트로 변경
        // 1. 양끝의 {}제거
        s = s.substring(1, s.length() - 1);
        
        // 2. }, 로 split
        String[] temp = s.split("},");
        
        // 3. 각 요소의 {}제거
        for (int i = 0; i < temp.length; i++) {
            temp[i] = temp[i].replace("{", "");
            temp[i] = temp[i].replace("}", "");
        }
        
        // 4. 각 요소의 ,로 split
        ArrayList<ArrayList<Integer>> array = new ArrayList<>();
        for (String ss : temp) {
            String[] sss = ss.split(",");
            ArrayList<Integer> tempArray = new ArrayList<>();
            for (String ssss : sss) {
                tempArray.add(Integer.parseInt(ssss));
            }
            
            array.add(tempArray);
        }
        
        // array를 길이별로 오름차순 정렬
        array.sort(Comparator.comparing(ArrayList::size));
        
        // 요소에서 길이가 1, 2, 3, ... 씩 늘어가는 걸 찾아서 기존에 없던 값을 answer의 맨 뒤로 추가
        int[] answer = new int[array.size()];
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i).size() == i + 1) {
                if (array.get(i).size() == 1) {
                    answer[index] = array.get(i).get(0);
                    index++;
                } else {
                    // answer에 없는 값을 찾아서 추가
                    for (int num : array.get(i)) {
                        int existed = 0;
                        for (int nn : answer) {
                            if (nn == num) {
                                existed = 1;
                            }
                        }
                        
                        if (existed == 0) {
                            answer[index] = num;
                            index++;
                        }
                    }
                }
            }
        }
        
        return answer;
    }
}