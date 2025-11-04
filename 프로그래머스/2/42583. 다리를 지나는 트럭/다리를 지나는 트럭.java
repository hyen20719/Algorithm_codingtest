import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> truck = new LinkedList<>();
        // 트럭 큐
        for(int i=0; i<truck_weights.length; i++){
            truck.offer(truck_weights[i]);   
        }
        // 다리 길이만큼 큐
        for(int i=0; i<bridge_length; i++){
            q.offer(0);
        }
        
        int time = 0;
        int curWeight = 0;
        
        while(!q.isEmpty()){
            time++;
            // System.out.println(time);
            curWeight -= q.poll();
            
            if(!truck.isEmpty()){ // 대기 중 트럭이 있을때
                int next = truck.peek();
                
                if(curWeight + next <= weight){
                    q.offer(next);
                    curWeight += next;
                    truck.poll(); // 제한 무게보다 적으니 큐에서 제거
                }else{
                    q.offer(0);
                }
            }
           // System.out.println(truck);
            // System.out.println(q);
        }
        
        return time;
    }
}