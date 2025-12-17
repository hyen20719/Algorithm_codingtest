import java.util.*;

class Solution {
    int[][] computers;
    boolean[] v;
    public int solution(int n, int[][] computers) {
        this.computers = computers;
        v = new boolean[n];
        
        int answer = 0;
        for(int i=0; i<n; i++){
            if(!v[i]){
                dfs(i);   
                answer++;
            }
        }
        return answer;
    }
    
    public void dfs(int cur){
        v[cur] = true;
        
        for(int i=0; i<computers.length; i++){
            if(computers[cur][i] == 1 && !v[i]){
                dfs(i);
            }
        }
    }
}