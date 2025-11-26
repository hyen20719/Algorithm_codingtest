import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int len = progresses.length;
        int[] answer = new int[len];
        
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<len; i++){
            int cur = progresses[i];
            int cnt = 0;
            while(cur < 100){
                cur += speeds[i];
                cnt++;
            }
            q.add(cnt); 
        }
        
        List<Integer> list = new ArrayList<>();
        System.out.println(q);
        while(!q.isEmpty()){
            int count = 1;
            int current = q.poll(); // 10
            while(!q.isEmpty() && current >= q.peek()){ // 10 > 1
                q.poll(); // 1
                count++; 
            }
            list.add(count);
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}