import java.util.*;

class Solution {
    static int[][] game_board;
    static int[][] table;
    static int n,m;
    static boolean[][] v;
    static int[] dx = {1,-1, 0,0};
    static int[] dy = {0,0, 1,-1};
        
    public int solution(int[][] game_board, int[][] table) {
        n = game_board.length;
        m = game_board[0].length;
        
        this.game_board = game_board;
        this.table = table;
        
        List<List<int[]>> blanks = new ArrayList<>();
        List<List<int[]>> pieces = new ArrayList<>();
        
        
       // game_board 빈칸 추출
        v = new boolean[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(game_board[i][j] == 0 && !v[i][j]){
                    blanks.add(bfs(i,j,0, game_board));
                }
            }
        }
        
        // table 퍼즐조각 추출
        v = new boolean[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(table[i][j] == 1 && !v[i][j]){
                    pieces.add(bfs(i,j,1, table));
                }
            }
        }
        
        int answer = 0;
        
        // 퍼즐조각 채우기
        for(List<int[]> blank : blanks){
            for(int i=0; i<pieces.size(); i++){
                List<int[]> piece = pieces.get(i);
                List<int[]> rotated = piece;
                boolean matched = false;
                
                for(int r=0; r<4; r++){
                   if(same(blank, rotated)){
                       answer += blank.size();// 빈칸 채운 수 만큼 점수 추가
                       pieces.remove(i); 
                       i--; // 리스트 삭제 후 인덱스 조정
                       matched = true;
                       break;
                   }
                    rotated = rotate(rotated);
                }
                if(matched) break;
            }
        }
                   
        return answer;
    }
    
    // bfs로 덩어리 좌표 모으기 + 정규화 
    public List<int[]> bfs(int sx, int sy, int target,int[][] board){
        Queue<int[]> q = new LinkedList<>();
        List<int[]> list = new ArrayList<>();
        
        v[sx][sy] = true;
        q.add(new int[]{sx,sy});
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            list.add(new int[]{x,y});
            
            for(int d=0; d<4; d++){
                int nx = x + dx[d];
                int ny = y + dy[d];
                
                if(nx >=0 && nx<n && ny >= 0 && ny<m){
                    if(!v[nx][ny] && board[nx][ny] == target){
                        v[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }
        return normalize(list); // 정규화
    }
    
    // 좌표 정규화
    private List<int[]> normalize(List<int[]> list){
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        
        for(int[] p : list){
            minX = Math.min(minX, p[0]);
            minY = Math.min(minY, p[1]); 
        }
        
        List<int[]> res = new ArrayList<>();
        for(int[] p : list){
            res.add(new int[]{p[0]-minX, p[1]-minY});
        }
        
        res.sort((a,b)-> a[0]==b[0] ? a[1]-b[1] : a[0]-b[0]);
        return res;
    }
    
    // 90도 회전 후 정규화
    private List<int[]> rotate(List<int[]> shape){
        List<int[]> res = new ArrayList<>();
        for(int[] p : shape){
            res.add(new int[]{p[1], -p[0]}); // 90도 회전
        }
        return normalize(res);
    }
    
    //두 덩어리 비교 
    private boolean same(List<int[]> a, List<int[]> b){
        if(a.size() != b.size()) return false;
        for(int i=0; i<a.size(); i++){
            if(a.get(i)[0] != b.get(i)[0]
              || a.get(i)[1] != b.get(i)[1]){
                return false;
            }
        }
        return true;
    }
}