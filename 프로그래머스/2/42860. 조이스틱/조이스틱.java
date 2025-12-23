import java.util.*;

class Solution {
    public int solution(String name) {
        int answer = 0;
        char[] crr = name.toCharArray();
        int len = name.length();
        
        for(char c : crr){
            answer += Math.min(c-'A', 'Z'-c+1);
        }
        
        int move = len-1;
        for(int i=0; i<len; i++){
            int cnt = i+1;
            while(len > cnt && name.charAt(cnt) == 'A'){
                cnt++;
            }
            
            move = Math.min(move, i*2+(len-cnt));
            move = Math.min(move, (len-cnt)*2+i);
            
        }
        
        return answer+move;
    }
}