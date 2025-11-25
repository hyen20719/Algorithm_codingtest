import java.util.*;
import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int len = commands.length;
        int[] answer = new int[len];
        
        for(int i=0; i<len; i++){
            int[] crr = commands[i];
            int st = crr[0]; // 시작점
            int end = crr[1]; // 종료지점
            
            // System.out.println(st + " , " +end +" , " + i);
            int[] a = Arrays.copyOfRange(array,st-1, end);
            Arrays.sort(a);
            int idx = crr[2]; // 몇번째인지
            
            answer[i] = a[idx-1];
        }
        
        return answer;
    }
}