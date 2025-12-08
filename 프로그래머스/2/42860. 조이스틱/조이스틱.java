import java.util.*;

class Solution {
    public int solution(String name) {
        int answer = 0;
        char[] crr = name.toCharArray();
        int len = crr.length;
        
        // 상하이동 
        for(char c : crr){
            answer += Math.min(c- 'A', 'Z'-c+1);
        }
        
        // 좌우이동
        int move = len-1;
        for(int i=0; i<len; i++){
            int next = i+1;
            
            // 다음 문자부터 연속된 A구간
            while(next < len && crr[next] == 'A'){
                next++;
                 
            }
            move = Math.min(move, i*2 + (len-next));
            move = Math.min(move, (len-next)*2+i);
        }
       // System.out.println(answer);
        
        return answer + move;
    }
}