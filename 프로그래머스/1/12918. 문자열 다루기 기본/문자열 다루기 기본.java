import java.util.*;

class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        int len = s.length();
    
        for(char c : s.toCharArray()){
            if(!Character.isDigit(c)){
                answer = false;
                return answer;
            }
        }
        
        return len == 4 || len == 6 ? answer : false;
    }
}