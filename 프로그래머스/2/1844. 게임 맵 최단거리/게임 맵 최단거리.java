import java.util.*;

class Solution {
    int[][] maps;
    boolean[][] v;
    
    public int solution(int[][] maps) {
        int answer = 0;
        this.maps = maps;
        
        int n = maps.length;
        int m = maps[0].length;
        
        v = new boolean[n][m];
        
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0,1}); // x,y,dist
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int dist = cur[2];
            
            if(x == n-1 && y == m-1){
                return dist;
            }
            
            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx >= 0 && ny >= 0 && nx < n && ny < m){
                    if(!v[nx][ny] && maps[nx][ny] == 1){
                        v[nx][ny] = true; // 큐에 넣을때 방문 처리
                        q.offer(new int[]{nx,ny,dist+1});
                    }    
                }
                
            }
            
        }
        
        return -1;
    }
}