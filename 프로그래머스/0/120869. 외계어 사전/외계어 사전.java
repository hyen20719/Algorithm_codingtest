import java.util.*;

class Solution {
    public int solution(String[] spell, String[] dic) {
        int answer = 2;
        Arrays.sort(spell);
        for(String d : dic){
            if(d.length() == spell.length){
                String[] drr = d.split("");
                Arrays.sort(drr);
                
                // Arrays.toString 대신 Arrays.equals 사용
                if(Arrays.equals(drr, spell)){ 
                   return answer = 1;
                }
            }
        }
        
        return answer;
    }
}