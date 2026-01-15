import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int len = numbers.length;
        int[] answer = new int[len];
        Stack<Integer> stack = new Stack<>();
        Arrays.fill(answer, -1);
        
        for(int i=0; i<len; i++){
            
            while(!stack.isEmpty() && numbers[i] > numbers[stack.peek()]){
                int idx = stack.pop();
                answer[idx] =  numbers[i];
            }
            stack.push(i);
        }
        return answer;
    }
}