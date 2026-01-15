import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> road = new LinkedList<>(); // 다리위
        
        for(int truck : truck_weights){
            q.offer(truck);
        }
        
        for(int i=0; i<bridge_length; i++){
            road.offer(0);
        }
        
        int time = 0;
        int totalWeight = 0;
        while(!q.isEmpty()){
            time++;
            
            // 다리에서 하나 내림
            totalWeight -= road.poll();

            // 트럭 올릴 수 있으면 올림(한도내에서)
            if(totalWeight + q.peek() <= weight){
                int truck = q.poll();
                road.offer(truck);
                totalWeight += truck;
            }else{
                road.offer(0);
            }
            
        }
        
        return time + bridge_length;
    }
}