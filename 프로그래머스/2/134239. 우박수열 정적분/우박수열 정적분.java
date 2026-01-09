import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        int len = ranges.length;
        double[] answer = new double[len];
        
        double[] nums = new double[len*4];
        int cnt = 0;
        nums[cnt++] = k;
        while( k != 1){
            if(k %2 == 0){//짝수
                k = k/2;
            }else{//홀수
                k = k*3+1;
            }
            nums[cnt++] = k;
        }
        nums = Arrays.copyOfRange(nums, 0, cnt);
        
        for(int i=0; i<ranges.length; i++){
            int[] range = ranges[i];
            double sum = 0.0;
            int st = range[0];
            int end = cnt+range[1]-1;
            
            for(int j=st; j<end; j++){
                sum += (nums[j] + nums[j + 1]) / 2.0;
            }
            if(st > end) sum = -1;
            answer[i] = sum;
        }
        return answer;
    }
}