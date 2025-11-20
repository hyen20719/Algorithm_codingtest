class Solution {
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n]; // 방문여부 체크
        int answer = 0;
        for(int i=0; i<n; i++){
            if(!visited[i]){
                dfs(i ,computers, visited);
                answer++;
            }
        }
        return answer;
    }
    
    public void dfs(int cur, int[][] computers, boolean[] visited){
        visited[cur] = true;
        
        for(int j=0; j<computers.length; j++){
            if(computers[cur][j] == 1 && !visited[j]){ // 연결되어있는데 방문안한 경우 
                dfs(j, computers, visited);
            }
        }
        
    }
}