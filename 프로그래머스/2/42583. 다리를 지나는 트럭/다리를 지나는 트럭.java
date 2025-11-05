import java.util.*;

class Solution {
    
    class Truck{
        int weight;
        int move;
        
        public Truck(int weight){
            this.weight = weight;
            this.move = 1;
        }
        
        public void moving(){
            move++;
        }
    }
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Truck> waitQ = new LinkedList<>();
        Queue<Truck> moveQ = new LinkedList<>();
        
        for(int t : truck_weights){
            waitQ.offer(new Truck(t));
        }
        
        int curWeight = 0; // 현재 다리위 무게 
        
        while(!waitQ.isEmpty() || !moveQ.isEmpty()){
            answer++;
            
            if(moveQ.isEmpty()){
                Truck t = waitQ.poll();
                curWeight += t.weight;
                moveQ.offer(t);
                continue;
            }
            
            for(Truck t : moveQ){
                t.moving();
            }
            
            //System.out.println(t.weight +", "+t.move);
            
            if(moveQ.peek().move > bridge_length){ // 다리길이보다 이동거리가 큰 경우 
                Truck t = moveQ.poll();
                curWeight -= t.weight;
            }
            
            if(!waitQ.isEmpty() && curWeight + waitQ.peek().weight <= weight){ // 대기큐에있고 다리위총무게가 최대무게보다 작을때
                Truck t = waitQ.poll();
                curWeight += t.weight;
                moveQ.offer(t);
            }
        }
        return answer;
    }
}