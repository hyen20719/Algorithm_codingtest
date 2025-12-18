import java.util.*;

class Solution {
    static final int MAX = 102;
    int[][] map = new int[MAX][MAX];
    boolean[][] v = new boolean[MAX][MAX];
    
    int[] dx = new int[]{1,-1,0,0};
    int[] dy = new int[]{0,0,1,-1};
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        // 2배로 채우기
        for(int[] r : rectangle){
            int x1 = r[0]*2;
            int y1 = r[1]*2;
            int x2 = r[2]*2;
            int y2 = r[3]*2;
            
            for(int x=x1; x<=x2; x++){
                for(int y=y1; y<=y2; y++){
                    map[x][y] = 1;
                }
            }
        }
        
        // 안쪽만 비우기 0으로
        for(int[] r : rectangle){
            int x1 = r[0]*2;
            int y1 = r[1]*2;
            int x2 = r[2]*2;
            int y2 = r[3]*2;
            
            for(int x=x1+1; x<x2; x++){
                for(int y=y1+1; y<y2; y++){
                    map[x][y] = 0;
                }
            }
        }
        
        // bfs로 거리 구하기 답은 /2
        return bfs(characterX*2, characterY*2, itemX*2, itemY*2)/2;
    }
    
    public int bfs(int sx,int sy,int ex,int ey){
        Queue<int[]> q = new LinkedList<>();
        
        q.offer(new int[]{sx,sy,0});
        v[sx][sy] = true;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            for(int i=0; i<4; i++){
                int x = cur[0] + dx[i];
                int y = cur[1] + dy[i];
                int dist = cur[2];
                
                if(x == ex && y == ey){return dist+1;}
                
                if(x < MAX && y < MAX && x >= 0 && y >= 0){
                    if(!v[x][y] && map[x][y] == 1){
                        v[x][y] = true;
                        q.offer(new int[]{x,y,dist+1});
                    }
                }
            }
            
        }
        
        return 0;
    }
}