import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        // 정렬 후 양쪽 접근이 가능한 Deque 사용
        Arrays.sort(people);
        Deque<Integer> q = new ArrayDeque<>();
        
        for(int p : people) { 
            q.offer(p);
        }
        //System.out.println(q);
        
        while(!q.isEmpty()){
            int cur = q.pollLast();
            if(!q.isEmpty() && cur + q.peekFirst() <= limit){
                q.pollFirst();
            }
            answer++;
        }
        
        return answer;
    }
}