import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        // 완주하지못한 마라톤 선수 판별하기 위한 map  
        HashMap<String, Integer> map = new HashMap<>();
        // 참가자 
        for(String p : participant){
            map.put(p, map.getOrDefault(p,0)+1);
        }
        // 완주자
        for(String c : completion){
            map.put(c, map.getOrDefault(c,0)+1);
        }
        
        // 동명이인도 고려하여 홀수인 선수 추출
        for(String i : map.keySet()){
            int count = map.get(i);
            if(count % 2 != 0){
                return i;
            }
        }
        
        return answer;
    }
}