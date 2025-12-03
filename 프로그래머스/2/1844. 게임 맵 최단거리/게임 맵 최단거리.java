import java.util.*;

class Solution {
    static int[][] maps;
    static boolean[][] v; 
    
    public int solution(int[][] maps) {
        this.maps = maps;
        int n = maps.length;
        int m = maps[0].length;
        v = new boolean[n][m];
        
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0,0,1}); // x,y, distance
        v[0][0] = true;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int dist = cur[2];
            
            // 도착지점
            if(x == n-1 && y == m-1){
                return dist;
            }
            
            // 4방향 탐색
            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx >= 0 && ny>= 0 && nx < n && ny < m){
                    if(!v[nx][ny] && maps[nx][ny] == 1){
                        v[nx][ny] = true;
                        q.add(new int[]{nx, ny, dist+1});
                    }
                }
            }
            
        }
        
        return -1;
    }
    
   
}