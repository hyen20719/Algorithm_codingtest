import java.util.*;

class Solution {
    int[][] computers;
    boolean[] v;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        this.computers = computers;
        v = new boolean[n];
        
        for(int i=0; i<n; i++){
            if(!v[i]){
                bfs(i);
                answer++;
            }
        }
        
        return answer;
    }
    
    public void bfs(int st){
        Queue<Integer> q = new LinkedList<>();
        q.offer(st);
        v[st] = true;
        
        while(!q.isEmpty()){
            int cur = q.poll();
            
            for(int i=0; i<computers.length; i++){
                if(!v[i] && computers[cur][i] == 1){
                    v[i] = true;
                    q.offer(i);
                }
            }
        }
    }
}