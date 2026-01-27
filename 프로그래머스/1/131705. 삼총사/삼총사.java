import java.util.*;

class Solution {
    public int solution(int[] number) {
        int answer = 0;
        int len = number.length; 
        HashSet<Integer> set = new HashSet<>();
        
        for(int i=0; i<len; i++){
            for(int j=i+1; j<len; j++){
                for(int z=j+1; z<len; z++){
                    if(number[i]+number[j]+number[z] == 0){
                        answer++;   
                    }
                }
            }
        }
        
        return answer;
    }
}