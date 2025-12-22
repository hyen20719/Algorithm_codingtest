import java.util.*;

class Solution {
    int[][] dungeons;
    boolean[] v;
    int answer = 0;
    
    public int solution(int k, int[][] dungeons) {
        this.dungeons = dungeons;
        v = new boolean[dungeons.length];
        
        dfs(k, 0);
        
        return answer;
    }
    
    public void dfs(int cur, int cnt){
        answer = Math.max(answer, cnt);
        if(cnt == dungeons.length) return;
        
        for(int i=0; i<dungeons.length; i++){
            int[] d = dungeons[i];
            if(!v[i] && cur >= d[0]){
                v[i] = true;
                dfs(cur - d[1], cnt+1);
                v[i] = false;
            }
        }
    }
}