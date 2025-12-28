import java.util.*;

class Solution {
    int answer = 0;
    int[][] puddles;
    long[][] dp;
    boolean[][] v;
    
    
    public int solution(int m, int n, int[][] puddles) {
        this.puddles = puddles;
        dp = new long[m+1][n+1];
        v = new boolean[m+1][n+1];
        int MOD = 1_000_000_007;
        
        // 물웅덩이 체크 
        for(int[] p :  puddles){
            v[p[0]][p[1]] = true;
        }
        
        dp[1][1] =1;
        
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(v[i][j]){
                    dp[i][j] = 0;
                    continue;
                }
                if(i > 1){
                    dp[i][j] = (dp[i][j] + dp[i-1][j]) %MOD; // 위쪽에서 오는 경우
                }        
                if(j > 1){
                    dp[i][j] = (dp[i][j] + dp[i][j-1]) %MOD; // 왼쪽에서 오는 경우
                }
            }
        }
        answer = (int)dp[m][n];
        
        return answer;
    }
}