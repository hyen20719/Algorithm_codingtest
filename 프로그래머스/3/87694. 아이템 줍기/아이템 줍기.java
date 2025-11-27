import java.util.*;

class Solution {
    static int[][] map = new int[102][102];
    static boolean[][] v = new boolean[102][102];
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        
        // 1. 직사각형 영역 채우기 (2배 확대)
        for(int[] r : rectangle){
            int x1 = r[0]*2; // 1
            int y1 = r[1]*2; // 1
            int x2 = r[2]*2; // 7
            int y2 = r[3]*2; // 4
            
            for(int i=x1; i<=x2; i++){
                for(int j=y1; j<=y2; j++){
                    map[i][j] = 1;
                }
            }
        }
        
        // 2. 내부 지우기 (0 만들기)
        for(int[] r : rectangle){
            int x1 = r[0]*2;
            int y1 = r[1]*2;
            int x2 = r[2]*2;
            int y2 = r[3]*2;
            
            for(int i=x1+1; i<x2; i++){
                for(int j=y1+1; j<y2; j++){
                    map[i][j] = 0;
                }
            }
        }
        
        // bfs 
        return bfs(characterX*2, characterY*2, itemX*2, itemY*2)/2;
    }
    
    public int bfs(int sx, int sy, int ex, int ey){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sx,sy,0});
        v[sx][sy] = true;
        
        while(!q.isEmpty()){
            int[] cur = q.poll(); // 1,3,0
            int x = cur[0], y = cur[1], d = cur[2];
            
            // 목표 지점에 도달시 최단 거리 반환
            if(x == ex && y == ey){
                return d;
            }
            
            // 상하좌우 이동
            for(int i=0; i<4; i++){
                int nx = x +dx[i];
                int ny = y +dy[i];
                
                // 방문하지않았고 직사각형 선 영역일때
                if(!v[nx][ny] && map[nx][ny] == 1){
                    v[nx][ny] = true;
                    q.offer(new int[]{nx,ny,d+1});
                }
            }
            
        }
        return 0;
    }
}