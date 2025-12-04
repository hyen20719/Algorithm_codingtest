import java.util.*;

class Solution {
    static Map<String, PriorityQueue<String>> map;
    static List<String> answer;
    
    public String[] solution(String[][] tickets) {
        answer = new ArrayList<>();
        map = new HashMap<>();
        
        // 출발지, [도착지] 큐삽입
        for(String[] t : tickets){
            map.putIfAbsent(t[0], new PriorityQueue<>());
            map.get(t[0]).offer(t[1]);
        }
        
        //System.out.println(map);
        dfs("ICN");
        
        return answer.toArray(new String[0]);
    }
    
    public void dfs(String ticket){
        PriorityQueue<String> pq = map.get(ticket);
        
        while(pq != null && !pq.isEmpty()){
            String next = pq.poll();
            dfs(next);
        }
        
        answer.add(0, ticket);
       // System.out.println(answer);
    }
}