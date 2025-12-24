import java.util.*;

class Solution {
    int[] parent;
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        // 부모 배열 초기화
        parent = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
        }
        
        // 비용 기준 정렬 
        Arrays.sort(costs, (a,b) -> a[2] - b[2]);
        
        // 간선 선택
        for(int[] cost : costs){
            int a = cost[0];
            int b = cost[1];
            int c = cost[2];
            
            if(find(a) != find(b)){ // 이미 부모가 연결되어 있다면 더하지않음
                union(a,b);
                answer += c;
            }
        }
        return answer;
    }
    
    public int find(int x){
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    
    public void union(int a, int b){
        a = find(a);
        b = find(b);
        parent[b] = a;
    }
    
}