import java.util.*;

class Solution {
    static boolean[] v;
    static ArrayList<Integer>[] graph;
    static int cnt = 0;
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        int len = wires.length;
        graph = new ArrayList[n+1];
        v = new boolean[n+1];
        
        for(int i=1; i<=n; i++){
            graph[i] = new ArrayList<>();
        }
        
        // 간선 모두 추가 
        for(int i=0; i<len; i++){
            int st = wires[i][0];
            int end = wires[i][1];
            
            graph[st].add(end);
            graph[end].add(st);
        }
        
        // 하나씩 끊고 dfs 돌리기
        for(int i=0; i<len; i++){
            int st = wires[i][0];
            int end = wires[i][1];
            
            // 그냥 st로 remove시 인덱스로 인식
            graph[st].remove((Integer)end);
            graph[end].remove((Integer)st);
            
            dfs(1);
            answer = Math.min(answer, Math.abs(cnt - (n-cnt)));
            
            cnt = 0;
            Arrays.fill(v, false); // 방문 배열 모두 초기화
            graph[st].add(end);
            graph[end].add(st);
        }
        
        return answer;
    }
    
    static void dfs(int node){
        v[node] = true;
        cnt++;
        for(int next : graph[node]){
            if(!v[next]){
                dfs(next);
            }
        }
    }
    
}