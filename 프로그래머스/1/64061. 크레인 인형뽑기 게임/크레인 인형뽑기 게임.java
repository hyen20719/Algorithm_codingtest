import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        Stack<Integer> stack = new Stack<>();
        int cnt = 0;
        for(int i=0; i<moves.length; i++){
            int j=moves[i]-1; 
            int idx= 0;
            
            while(idx < board.length){
                if(board[idx][j] !=0){
                    // System.out.println(idx);
                    if(!stack.isEmpty() && stack.peek() == board[idx][j]){
                        stack.pop();
                        board[idx][j] = 0;
                        cnt+=2;
                    }else{
                        stack.push(board[idx][j]);   
                        board[idx][j] = 0;
                        
                    }
                    break;
                }
                    idx++;
                
            }
        }
         // System.out.println(stack);
        
        return cnt;
    }
}