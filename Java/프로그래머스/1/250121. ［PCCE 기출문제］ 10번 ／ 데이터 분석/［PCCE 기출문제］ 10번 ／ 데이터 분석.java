import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        ArrayList<int[]> dataArray = new ArrayList<>();
        
        int criteria = getIndex(ext);
        
        for (int[] each : data) {
            if (each[criteria] < val_ext) {
                dataArray.add(each);
            }
        }
        
        // 정렬
        final int sortCriteria = getIndex(sort_by);

        Collections.sort(dataArray, Comparator.comparingInt(d -> d[sortCriteria]));
        
        // Data 개체를 int[] 개체로 변경해서 answer에 삽입
        int[][] answer = new int[dataArray.size()][4];
        for (int i = 0; i < dataArray.size(); i++) {
            answer[i] = dataArray.get(i); 
        }
        
        return answer;
    }
    
    public int getIndex(String temp) {
        int sortCriteria = -1;
        if (temp.equals("code")) {
            sortCriteria = 0;
        } else if (temp.equals("date")) {
            sortCriteria = 1;
        } else if (temp.equals("maximum")) {
            sortCriteria = 2;
        } else if (temp.equals("remain")) {
            sortCriteria = 3;
        }
        
        return sortCriteria;
    }
}