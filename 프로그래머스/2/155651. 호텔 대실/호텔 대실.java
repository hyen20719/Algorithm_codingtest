import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        Arrays.sort(book_time, (a,b) -> {
            return toMin(a[0]) - toMin(b[0]);
        });
        
        for(String[] time: book_time){
            int st = toMin(time[0]);
            int end = toMin(time[1]) + 10;// 청소시간 추가
            
            if(!pq.isEmpty() && pq.peek() <= st){ // 가장빠른퇴실방+10분 <= 지금 시작시간
                pq.poll();
            }
            pq.offer(end);
        }
        
        return pq.size();
    }
    
    // 분으로 변환
    public int toMin(String time){
        String[] times = time.split(":");
        return Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
    }
}