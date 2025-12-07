import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        boolean[] used = new boolean[reserve.length]; //reserve 학생 사용여부 
        // 여벌이 있지만 도난도 당한 학생 처리 
        for(int i=0; i<lost.length; i++){
            for(int j=0; j<reserve.length; j++){
                if(lost[i] == reserve[j]){
                    lost[i] = -1; // 해결된 도난
                    used[j] = true;
                    break;
                }
            }
        }
        
        // 남은 학생끼리 옷 빌리기
        for(int i=0; i<lost.length; i++){
            if(lost[i] == -1) continue; // 이미 해결된 학생
            
            boolean chk = false;
            for(int j=0; j<reserve.length; j++){
                if(used[j]) continue; // 이미 빌려준 reserve
                
                if(reserve[j] == lost[i]-1 || reserve[j] == lost[i]+1 ){
                    used[j] = true;
                    chk = true;
                    break;
                    
                }
            }
            
            if(!chk) answer--; // 못빌렸을 경우
        }
        
        return answer;
    }
}