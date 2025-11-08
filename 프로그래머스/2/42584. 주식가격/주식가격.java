import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int size = prices.length;
        int[] answer = new int[size];
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<size; i++){
            // 가격이 떨어진 시점마다 입력
            while(!stack.isEmpty() && prices[i] < prices[stack.peek()]){ 
                int cur = stack.pop();
                answer[cur] = i - cur;
            }
            stack.push(i);
        }
       // System.out.println(stack);
        
        // 스택에 담겨진 인덱스로 몇 초인지 계산
        while(!stack.isEmpty()){
            int idx = stack.pop();
            answer[idx] = size -1 -idx;
        }
        
        return answer;
    }
}