import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -2;
        int len = queue1.length;
        long sum1 = 0, sum2 = 0;
        
        int[] totalq = new int[len*2];
        for(int i=0; i<len; i++){
            sum1 += queue1[i];
            totalq[i] = queue1[i];
        }
        
        for(int i=len; i<totalq.length; i++){
            totalq[i] = queue2[i-len];
            sum2 += queue2[i-len];
        }
        
        long total = sum1+sum2;
        if(total % 2 != 0) return -1;
        
        int left = 0; //q1시작점
        int right = len; // q2시작점
        int cnt = 0; //이동횟수
        long target = total/2; 
        
        while(left < right && right < len*2){
            if(target == sum1){
                return cnt; // 큐 합이 같을 때
            }else if(sum1 > target){
                sum1-=totalq[left++];
            }else{
                sum1+=totalq[right % (2 * len)]; // ✅ 수정
                right++;
            }
            cnt++;
        }
        
        return -1;
    }
}