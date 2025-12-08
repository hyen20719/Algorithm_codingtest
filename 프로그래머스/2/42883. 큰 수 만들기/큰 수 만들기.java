import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        int len = number.length();
        
        for(int i=0; i<len; i++){
            char cur = number.charAt(i);
            
            while(!stack.isEmpty() && k > 0 && stack.peek() < cur){
                stack.pop();
                k--;
            }
            stack.push(cur);
        }
       // System.out.println(stack);
        //System.out.println(k);
        while(k > 0){
            stack.pop();
            k--;
        }
        
        //System.out.println(stack);
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
       // System.out.println(stack);
        return sb.reverse().toString();
    }
}