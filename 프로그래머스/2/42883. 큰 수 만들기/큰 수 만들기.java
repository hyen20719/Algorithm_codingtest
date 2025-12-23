import java.util.*;

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        Stack<Integer> stack = new Stack<>();
        for(char c : number.toCharArray()){
            int num = c - '0';
            
            while(!stack.isEmpty() && stack.peek() < num && k > 0){
                stack.pop();
                k--;
            }
            stack.push(num);
        }
        
        while(k > 0){
            stack.pop();
            k--;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int s : stack) {
            sb.append(s);
        }
        
      //  System.out.println(stack);
        
        
        return sb.toString();
    }
}