import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();
        map.put("zero", 0);
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);
        
        StringBuilder sbNum = new StringBuilder(); // 정답 담아놓는 sb
        StringBuilder sb = new StringBuilder(); // 문자열 체크
        
        char[] crr = s.toCharArray();
        for(char c : s.toCharArray()){
            if(Character.isDigit(c)){ // 숫자인지
                sbNum.append(c);
                continue;
            }
            
            sb.append(c);
            if(map.containsKey(sb.toString())){
                sbNum.append(map.get(sb.toString()));
                sb.setLength(0);
            }
        }
        
        return Integer.parseInt(sbNum.toString());
    }
}