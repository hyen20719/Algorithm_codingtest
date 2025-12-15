import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        // 그래프 초기화 
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        
        // edge로 그래프 연결 
        for(int[] e : edge){
            int st = e[0], ed = e[1];
            graph.get(st).add(ed);
            graph.get(ed).add(st);
        }
        
        // bfs 초기화
        Queue<Integer> q = new LinkedList<>();
        boolean[] v = new boolean[n+1]; // 방문 체크 배열
        int[] distance = new int[n+1]; // 각 노드 거리
        
        // bfs 1번에서 시작
        q.offer(1);
        v[1] = true;
        distance[1] = 0;
        
        // bfs 
        while(!q.isEmpty()){
            int node = q.poll();
            
            // 현재 노드와 연결된 모든 노드 탐색
            for(int next : graph.get(node)){
                if(!v[next]){
                    v[next] = true;
                    distance[next] = distance[node] +1;
                    q.offer(next);
                }
            }
        }
        
        // 가장 먼 노드 찾기
        int maxDistance = Integer.MIN_VALUE;
        int count = 0;
        
        // 가장 큰 거리와 그 거리를 가진 노드 수 계산
        for(int i=1; i<=n; i++){
            if(distance[i] > maxDistance){
                maxDistance = distance[i];
                count = 1; // 가장 먼 노드를 찾으면 갯수 1로 초기화
            }else if(distance[i] == maxDistance){
                count++;
            }
        }
        
        return count;
    }
}