import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        // 큐에 작업일수 담기
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<progresses.length; i++){
            int cur = progresses[i];
            int count = 0;
            while(cur < 100 ){
                cur += speeds[i];
                count++;
            }
            q.offer(count);  
        }
        
        int count = 0;
        while(!q.isEmpty()){
            int cnt = 1;
            int cur = q.poll(); 
           // System.out.println("현재===" + cur);
            // 큐 안의 다음 기능들이 현재 기능과 함께 배포될 수 있는지 확인
            while(!q.isEmpty() && q.peek() <= cur){ 
                q.poll(); // 앞의 날짜보다 뒤의 날짜가 작으면 꺼내서 함께 배포
                cnt++;
            }
            list.add(cnt);
        }
       
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}