import java.util.*;

class Solution {
    int cnt = 0; // 변환 횟수
    int zeroCnt = 0; // 0제거갯수
    
    public int[] solution(String s) {
        while(!"1".equals(s)){
            cnt++;
            
            int ones = 0;
            for(int i=0; i<s.length(); i++){
                if(s.charAt(i) == '0'){
                    zeroCnt++;
                }else{
                    ones++;
                }
            }

            s = Integer.toBinaryString(ones);
        }
        return new int[]{cnt, zeroCnt};
    }
}