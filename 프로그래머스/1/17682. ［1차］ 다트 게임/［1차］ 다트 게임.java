import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        // S : 1제곱,  D : 2제곱, T : 3제곱
        // * : 점수 2배 , # : *-1
        
        int idx = -1; //점수 인덱스
        int[] scores = new int[3]; //3번의 점수 저장 배열
        int num=0; // 현재 숫자
        for(int i=0; i<dartResult.length(); i++){
            char c = dartResult.charAt(i);
            
            if(Character.isDigit(c)){
                num = num*10 +(c -'0');
            }else{
                switch(c){
                    case 'S' :  idx++; scores[idx] = num; break;
                    case 'D' :  idx++; scores[idx] = num*num; break;
                    case 'T' :  idx++; scores[idx] = num*num*num; break;
                    case '*' :  scores[idx] *=2; 
                                if(idx > 0){
                                    scores[idx-1] *=2; // 이전 점수도 두배
                                }
                                break;
                    case '#' :  scores[idx] *= -1; break;
                }
                num = 0; // 다음 숫자 연산을 위해 연산 후 숫자 초기화 
            }
        }
        
        for(int score : scores){
            answer += score;
        }
        
        return answer;
    }
    
}