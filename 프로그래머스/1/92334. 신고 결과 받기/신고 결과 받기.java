import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int len = id_list.length;
        int[] answer = new int[len];
        
        // 중복 신고 제거
        Set<String> set = new HashSet<>(Arrays.asList(report));
        
        // 신고당한 횟수
        Map<String, Integer> map = new HashMap<>();
        // 유저별 index 저장
        Map<String, Integer> idxMap = new HashMap<>();
        for(int i=0; i<len; i++) {
            map.put(id_list[i], 0);
            idxMap.put(id_list[i], i);
        }
        
        // 신고당한 사람 횟수 집계
        for(String s : set){
            String user = s.split(" ")[1];
            map.put(user, map.get(user) +1);
        }
        
       // System.out.println(map);
        
        // 각 유저가 받은 메일 수 계산
        for(String s : set){
            String reporter = s.split(" ")[0];
            String target = s.split(" ")[1];
            
            if(map.get(target) >= k){
                answer[idxMap.get(reporter)]++;
            }
        }
        
        return answer;
    }
}