import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        ArrayList<Character> list = new ArrayList<>();
        
        for(int i=0; i<s.length(); i++){
            list.add(s.charAt(i));
        }
        Collections.sort(list, Collections.reverseOrder());
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<list.size(); i++){
            sb.append(list.get(i));
        }
        return sb.toString();
    }
}