import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int sco : scoville){
            pq.offer(sco);
        }
        
        while(pq.size() >=2){
            int min = pq.poll();
            if(min< K && !pq.isEmpty()){
                int min2 = pq.poll();
                int newSco = min + (min2*2);
                pq.offer(newSco);
                answer++;
            }else{
                break;
            }
        }
        
        return pq.peek() >= K ? answer : -1 ;
    }
}