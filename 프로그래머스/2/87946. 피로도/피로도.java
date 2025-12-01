import java.util.*;

class Solution {
    static int answer;
    static boolean[] v;
    static int[][] dungeons;
    
    public int solution(int k, int[][] dungeons) {
        answer = 0;
        v = new boolean[dungeons.length];
        this.dungeons = dungeons;
        
        dfs(k, 0);
        return answer;
    }
    
    static void dfs(int k, int count){
        answer = Math.max(count, answer);
        
        for(int i=0; i<dungeons.length; i++){
            int[] dungeon = dungeons[i];  // 던전
            int limit = dungeon[0]; // 최소 필요도
            int damage = dungeon[1]; // 소모 피로도 
            
            if(!v[i] && k >= limit){
                v[i] = true;
                dfs(k-damage, count+1);
                v[i] = false;
            }
            
        }
        
    }
}