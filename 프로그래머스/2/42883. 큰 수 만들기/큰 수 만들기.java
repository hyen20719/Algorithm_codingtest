import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        
        Stack<Character> stack = new Stack<>();
        
        for(char c : number.toCharArray()){
            while(!stack.isEmpty() && c > stack.peek() && k > 0){
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        
        while(!stack.isEmpty() && k > 0){
            stack.pop();
            k--;
        }
        
        for(char c : stack){
            sb.append(c);
        }
        
        return sb.toString();
    }
}