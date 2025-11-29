import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        int total = brown + yellow; // 전체면적
        
        for(int y=1; y<=total; y++){ //세로를 기준으로 total까지
            if(total % y == 0){// 정수일때
                int x = total / y; // 가로
                
                
                if((2*x+2*y-4) == brown){
                    //System.out.println(x + " , " + y);
                    return new int[]{x,y};
                }
            }
        }
        return new int[]{};
    }
}