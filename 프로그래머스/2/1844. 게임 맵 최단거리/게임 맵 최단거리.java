import java.util.*;

class Solution {
    int[][] maps;
    
    public int solution(int[][] maps) {
        // 방문 체크없이 바로 거리 계산하는 방식
        this.maps = maps;
        
        int n = maps.length;
        int m = maps[0].length;
        
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0}); // x,y
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            
            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx >= 0 && ny >= 0 && nx < n && ny < m){
                    if(maps[nx][ny] == 1){
                        maps[nx][ny] = maps[x][y] +1; // 큐에 넣을때 방문 처리
                        q.offer(new int[]{nx,ny});
                    }    
                }
                
            }
            
        }
        
        int answer = maps[n-1][m-1];
        return answer == 1 ? -1 : answer;
    }
}