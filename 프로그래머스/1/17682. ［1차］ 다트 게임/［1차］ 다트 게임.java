import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int answer = 0; // 현재숫자
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<dartResult.length(); i++){
            char c = dartResult.charAt(i);
            
            if(Character.isDigit(c)){
                answer = answer * 10 + (c - '0');
                
            }else if(c == 'S' || c == 'D' || c == 'T' ){
                switch(c){
                    case 'S':answer = (int)Math.pow(answer,1); break;
                    case 'D':answer = (int)Math.pow(answer,2); break;
                    case 'T':answer = (int)Math.pow(answer,3); break;
                }
                stack.push(answer); // 계산한 현재값
                answer = 0; // 다음 점수를 위해
            }else if(c == '*'){
                int num = stack.pop(); // S,D,T에서 계산한 점수 가져오기
                num *= 2; // 현재 점수 2배
                if(!stack.isEmpty()){ //스택 비어있지않으면 이전 점수도 
                    int prev = stack.pop() *2;
                    stack.push(prev);
                }
                stack.push(num);
                // 이전 점수 먼저 push하고 그 다음 점수
            }else if(c == '#'){
                int num = stack.pop() * -1;
                stack.push(num);
            }
        }
        
        // 최종 점수 합 계산
        answer = 0; 
        for(int score : stack){
            answer += score;
        }
        
        return answer;
    }
}