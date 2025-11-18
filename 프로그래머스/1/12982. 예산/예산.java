import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        int count = 0;
        Arrays.sort(d);
        Stack<Integer> stack = new Stack<>();
        for(int i=d.length-1; i>=0; i--){
            stack.push(d[i]);
        }
        
        while(!stack.isEmpty()){
            int cur = stack.pop();
            if (answer + cur <= budget) {
                answer += cur;  // 예산을 초과하지 않으면 지원
                count++;         // 지원한 부서 수 증가
            } else {
                break;           // 예산을 초과하면 더 이상 지원하지 않음
            }
        }
        return count;
    }
}