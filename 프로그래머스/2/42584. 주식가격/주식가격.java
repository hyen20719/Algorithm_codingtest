import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int len = prices.length;
        int[] answer = new int[len];
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<len; i++){
            // 가격이 떨어진 지점 찾기
            while(!stack.isEmpty() && prices[stack.peek()] > prices[i]){ 
                int idx = stack.pop();
                answer[idx] = i - idx; // 떨어진 지점에 길이 넣기
            }
            stack.push(i);
        }
        
       // System.out.println(stack); // [0,1,3,4]
        
        while(!stack.isEmpty()){
            int idx = stack.pop();
            answer[idx] = len - idx -1; // 가격이 끝날때까지 떨어지지않은 시간
        }
        
        
        return answer;
    }
}