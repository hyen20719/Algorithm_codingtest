import java.util.*;

class Solution {
    int[][] triangle;
    int[][] dp;
    int len;
    
    public int solution(int[][] triangle) {
        int answer = 0;
        this.triangle = triangle;
        len = triangle.length;
        dp = new int[len][len];
        
        return dfs(0,0);
    }
    
    public int dfs(int depth, int idx){
        // 맨 아래 도착
        if(depth == len-1){
            return triangle[depth][idx];
        }
        
        // 이미 계산된 경우
        if(dp[depth][idx] != 0 ){
            return dp[depth][idx];
        }
        
        dp[depth][idx] = triangle[depth][idx] +
                         Math.max(dfs(depth+1, idx), dfs(depth+1,idx+1));
        return dp[depth][idx];
        
    }
}