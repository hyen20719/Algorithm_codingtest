import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer = -1;
        
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(!stack.isEmpty() && c == stack.peek()){
                stack.pop();
            }else{
                stack.push(c);
            }
        }
        //System.out.println(stack);

        return stack.isEmpty() ? 1 :0;
    }
}