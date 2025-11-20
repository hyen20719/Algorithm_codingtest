import java.util.*;

class Solution {
    private static boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        
        for(int i=0; i<n; i++){
            if(!visited[i]){
                dfs(i, n, computers);
                answer++;
            }
        }
        return answer;
    }
    
    public void dfs(int cur , int n, int[][] computers){
        visited[cur] = true; // 방문 처리
        
        for(int i=0; i<n; i++){
            if(!visited[i] && computers[cur][i] == 1){
                dfs(i, n, computers);
            }
        }
        
    }
}