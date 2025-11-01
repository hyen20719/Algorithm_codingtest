import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Stack<String> stack = new Stack<>();
        char[] crr = s.toCharArray();
        for(int i=0; i<crr.length; i++){
            if('(' == crr[i]){
                stack.push("(");
            }else if(')' == crr[i]){
                if(!stack.isEmpty()){
                    stack.pop();
                }else{
                    answer = false;
                }
            }
        }
        if(stack.size() != 0){
            answer = false;
        }

        return answer;
    }
}