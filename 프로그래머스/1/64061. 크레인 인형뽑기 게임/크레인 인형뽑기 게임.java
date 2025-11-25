import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        Stack<Integer> stack = new Stack<>();
        for(int move : moves){ // 열 기준이 됨
            int col = move-1;
            for(int row=0; row<board.length; row++){
                int cur = board[row][col];
                if(cur != 0){
                    board[row][col] = 0; // 인형 뽑음 
                    
                    if(!stack.isEmpty() && cur == stack.peek()){
                        stack.pop();
                        answer +=2; // 제거된 인형 수
                    }else{
                        stack.push(cur);
                    }
                    break; // move당 한번만 뽑기 위해서
                }
            }
        }
        
        return answer;
    }
}