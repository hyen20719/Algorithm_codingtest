import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int len = prices.length;
        int[] answer = new int[len];
        
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<len; i++){
            while(!stack.isEmpty() && prices[i] < prices[stack.peek()]){
                int idx = stack.pop(); 
                //System.out.println(i);
                answer[idx] = i - idx; // 현재값 - 이전값
            }
            stack.push(i);
        }
        
        while(!stack.isEmpty()){
            int cur = stack.pop();
          //  System.out.println(cur);
            answer[cur] = len - cur -1;
        }
        
        //System.out.println(stack);
        //System.out.println(Arrays.toString(answer));
        return answer;
    }
}