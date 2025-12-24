import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        // 끝 위치 기준 정렬
        Arrays.sort(routes, (a, b) -> a[1] - b[1]);
        
        int cam = Integer.MIN_VALUE; // 현재 카메라 위치
        
        for(int[] route : routes){
            int start = route[0];
            int end = route[1];
            
            if(cam < start){ // 카메라로 이 차량을 커버 못하면
                cam = end;   // 끝 위치에 카메라 설치
                System.out.println(cam);
                answer++;
            }
        }
        
        return answer;
    }
}