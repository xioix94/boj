import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        ArrayList<String> temp = new ArrayList<>();
        HashMap<String, ArrayList<Integer>> log = new HashMap<>();
        HashMap<String, String> idName = new HashMap<>();
        for (String r : record) {
            String[] s = r.split(" ");
            if (s.length == 2) {
                log.get(s[1]).add(temp.size());
                temp.add(idName.get(s[1]) + "님이 나갔습니다.");
            } else {
                // 들어왔는데 이름은 바꾼 경우 처리해야됨
                if (idName.containsKey(s[1]) && !idName.get(s[1]).equals(s[2])) {
                    ArrayList<Integer> changeList = log.get(s[1]);
                    for (int c : changeList) {
                        temp.set(c, changeName(temp.get(c), s[2]));
                    }
                    
                    idName.put(s[1], s[2]);
                }
                if (s[0].equals("Enter")) {
                    idName.put(s[1], s[2]);
                    if (log.containsKey(s[1])) {
                        log.get(s[1]).add(temp.size());
                    } else {
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(temp.size());
                        log.put(s[1], list);
                    }
                    
                    temp.add(s[2] + "님이 들어왔습니다.");
                // Change
                } else {
                    ArrayList<Integer> changeList = log.get(s[1]);
                    for (int c : changeList) {
                        temp.set(c, changeName(temp.get(c), s[2]));
                    }
                    
                    idName.put(s[1], s[2]);
                }
            }
        }
        
        return temp.toArray(new String[temp.size()]);
    }
    
    public String changeName(String old, String current) {
        String[] temp = old.split("님");
        String newOne = old.replace(temp[0], current);
        return newOne;
    }
}