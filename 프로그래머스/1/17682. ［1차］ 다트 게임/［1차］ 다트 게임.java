import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        // S : 1제곱 , D : 2제곱 , T : 3제곱 
        // * : 점수2배 (이전점수도 2배) , # : -2배
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<dartResult.length(); i++){
            char c = dartResult.charAt(i);
            
            if(Character.isDigit(c)){
                if(i != 0 && Character.isDigit(dartResult.charAt(i-1))){
                    int pre = stack.pop();
                    //System.out.println(pre);
                    stack.push(pre * 10 + (c-'0'));
                }else{
                    stack.push(c - '0');
                }
               // System.out.println(stack);
            }else if(c == 'S' || c == 'D' ||c == 'T'){
                int cur = stack.pop();
                switch(c){
                    case 'S' : stack.push((int)Math.pow(cur,1)); break;
                    case 'D' : stack.push((int)Math.pow(cur,2)); break;
                    case 'T' : stack.push((int)Math.pow(cur,3)); break;
                }
                //System.out.println("ddd" + stack);
            }else{
                int cur = stack.pop();
                if(c == '*'){ // 2배
                    if(!stack.isEmpty()){
                        stack.push(stack.pop()*2);
                    }
                    stack.push(cur*2);
                }else{ // 마이너스
                    stack.push(cur*-1);
                }
            }
        }
        
        while(!stack.isEmpty()){
            answer += stack.pop();
        }
        
        
        return answer;
    }
}