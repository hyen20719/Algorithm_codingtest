import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (a,b)-> a[1]-b[1]);
        int answer = 0;
        int cam = Integer.MIN_VALUE;
        
        for(int[] route : routes){
            int st = route[0]; 
            int ed = route[1]; 
            //System.out.println(st + " , " + cam);
            if(st > cam){
                cam = ed; 
                //System.out.println(cam);
                answer++;
            }
        }
        
        return answer;
    }
}