import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        
        HashMap<String, String> map = new HashMap<>();
        HashMap<String, Integer> pre = new HashMap<>();
        
        for (String record : records) {
            String[] splited = record.split(" ");
            if (splited[2].equals("IN")) {
                map.put(splited[1], splited[0]);
            } else {
                if (pre.containsKey(splited[1])) {
                    pre.put(splited[1], pre.get(splited[1]) + getTimeFromInTimeOutTime(map.get(splited[1]), splited[0]));
                } else {
                    pre.put(splited[1], getTimeFromInTimeOutTime(map.get(splited[1]), splited[0]));
                }
                
                map.remove(splited[1]);
            }
        }
        
        if (map.size() > 0) {
            for (String k : map.keySet()) {
                if (pre.containsKey(k)) {
                    pre.put(k, pre.get(k) + getTimeFromInTimeOutTime(map.get(k), "23:59"));
                } else {
                    pre.put(k, getTimeFromInTimeOutTime(map.get(k), "23:59"));
                }
            }
        }
        
        Set<String> temp = pre.keySet();
        ArrayList<Integer> intTemp = new ArrayList<>();
        for (String t : temp) {
            intTemp.add(Integer.parseInt(t));
        }
        
        Collections.sort(intTemp);
        
        int[] answer = new int[pre.size()];
        int count = 0;
        for (int i : intTemp) {
            answer[count] = getFee(getCarNumber(i), pre.get(getCarNumber(i)), fees, map);
            count++;
        }        
        
        return answer;
    }
    
    public int getFee(String carNumber, int time, int[] fees, HashMap<String, String> map) {
        int basicTime = fees[0];
        int basicFee = fees[1];
        int addTime = fees[2];
        int addFee = fees[3];
        
        if (time <= basicTime) {
            return basicFee;
        }
        
        int addedTime = time - basicTime;
        int addedFee = addedTime / addTime;
        if (addedTime % addTime != 0) {
            addedFee += 1;
        }
        
        addedFee *= addFee;
        return basicFee + addedFee;
    }
    
    public int getTimeFromInTimeOutTime(String inTime, String outTime) {
        String[] inTimeSplit = inTime.split(":");
        String[] outTimeSplit = outTime.split(":");
        
        return (Integer.parseInt(outTimeSplit[0]) * 60 + Integer.parseInt(outTimeSplit[1])) - (Integer.parseInt(inTimeSplit[0]) * 60 + Integer.parseInt(inTimeSplit[1]));
    }
    
    public String getCarNumber(int i) {
        String s = String.valueOf(i);
        while(s.length() != 4) {
            s = "0" + s;
        }
        
        return s;
    }
}