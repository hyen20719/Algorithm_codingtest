import java.util.*;

class Solution {
    public boolean solution(String s) {
        boolean answer = false;
        
        // 길이 체크 
        if(s.length() == 4 || s.length() == 6){
            answer = true;
        }
        for(char c : s.toCharArray()){
            if(!Character.isDigit(c)){
                answer = false;
                break;
            }
        }
        
        return answer;
    }
}