import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int size = prices.length;
        int[] answer = new int[size];
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<size; i++){
            while(!stack.isEmpty() && prices[i] < prices[stack.peek()]){ // 
                int cur = stack.pop();
                answer[cur] = i - cur;
              //  System.out.println(answer[cur]);
            }
            stack.push(i);
        }
       // System.out.println(stack);
        
        while(!stack.isEmpty()){
            int cur = stack.pop();
           // System.out.println(cur + "<<<");
            answer[cur] = size -1 -cur;
           // System.out.println(answer[cur]);
        }
        
        return answer;
    }
}