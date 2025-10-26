import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        // 동명이인 처리, 횟수 누적 문제 => hashMap
        // 참가자, 완주자 모두 추가로 구현시 hashmap 연산이 두 번 이루어져 비효율
        // => 아래처럼 추가 후 제거하는 방식이 효율적
        
        // 완주하지못한 마라톤 선수 판별하기 위한 map  
        HashMap<String, Integer> map = new HashMap<>();
        // 참가자 map map count+1
        for(String p : participant){
            map.put(p, map.getOrDefault(p,0)+1);
        }
        // 완주자 이름 map count-1
        for(String c : completion){
            map.put(c, map.get(c)-1);
        }
        
        // map에 남아있는 완주하지 못한 선수 추출
        for(String i : map.keySet()){
            if(map.get(i) == 1 ){
                return i;
            }
        }
        
        return answer;
    }
}