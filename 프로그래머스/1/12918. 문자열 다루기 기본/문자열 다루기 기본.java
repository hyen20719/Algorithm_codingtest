import java.util.*;
class Solution {
    public boolean solution(String s) {
        
        int len = s.length();
        boolean answer = false;
        
        if(len == 4 || len == 6) answer = true;
        
        for(char c : s.toCharArray()){
            //System.out.println(c);
            if(!Character.isDigit(c)){
                return false;
            }
        }
        
        return answer;
    }
}