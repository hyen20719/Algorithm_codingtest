import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int len = friends.length;
        int[][] gift = new int[len][len]; // [선물준사람][받은사람]
        int[] score = new int[len]; // 각 선물지수
        
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<len; i++){
            map.put(friends[i], i);
        }
        
        for(String g : gifts){
            String[] s = g.split(" ");
            int giver = map.get(s[0]);
            int receiver = map.get(s[1]);
            
            gift[giver][receiver]++;
            score[giver]++;
            score[receiver]--;
        }
        
        int[] nextGift = new int[len];
        for(int i=0; i<len; i++){
            for(int j=i+1; j<len; j++){ // 앞사람은 이미 비교했기때문에 i 다음 사람부터
                if(gift[i][j] > gift[j][i]){ // i가 더 많이 준 경우
                    nextGift[i]++;
                }else if(gift[i][j] < gift[j][i]){ // j가 더 많이 준 경우
                    nextGift[j]++;
                }else{ // 선물 지수로 비교
                    if(score[i] > score[j]){
                        nextGift[i]++;
                    }else if(score[i] < score[j]){
                        nextGift[j]++;
                    }
                    
                }
            }
        }
        
        for(int n : nextGift){
            answer = Math.max(answer, n);
        }
        
        return answer;
    }
}