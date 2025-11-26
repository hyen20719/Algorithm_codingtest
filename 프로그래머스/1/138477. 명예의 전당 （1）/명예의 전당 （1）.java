import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int len = score.length; 
        int[] answer = new int[len];
        
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i=0; i<len; i++){
            if(q.size() < k){ // k보다 작으면 insert
                q.offer(score[i]);
            }else if(q.size() == k){ // k랑 같을시
                if(q.peek() < score[i]){ // 현재 점수가 명예의 전당보다 클때
                    q.poll();
                    q.offer(score[i]); // 현재 점수
                }
            }
            answer[i] = q.peek();// 가장 작은 점수
        }
        
        return answer;
    }
}