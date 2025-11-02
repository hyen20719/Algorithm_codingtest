import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        // 우선순위큐
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        // 큐
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<priorities.length; i++){
            q.offer(new int[]{i,priorities[i]});
            pq.offer(priorities[i]);
        }
        
        //System.out.println(pq);
        int count = 0; // location이 몇번째로 실행되는지 횟수
        while(!q.isEmpty()){
            int[] cur = q.poll(); 
            
            if(cur[1] < pq.peek()){ // 기존큐 < 우선순위큐
                q.offer(cur); // 다시 큐에 넣기
            }else{
                pq.poll(); 
                count++;
                if(cur[0] == location){ 
                    return count;
                }
            }
        }
        
        return answer;
    }
}