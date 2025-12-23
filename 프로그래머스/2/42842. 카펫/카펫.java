import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total = brown + yellow;
        
        for(int y=1; y<=total; y++){
            if(total % y  == 0){
                int x = total/y;
                System.out.println(x + " " + y);
                
                if((2*x+2*y)-4 == brown){
                    answer[0] = x;
                    answer[1] = y;
                    break;
                }
            }
        }
        
        return answer;
    }
}