import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int len = id_list.length;
        int[] answer = new int[len];
        
        // 신고자,[신고당한자 list]
        Map<String, HashSet<String>> map = new HashMap<>();
        // 신고 당한 사람, 횟수
        Map<String, Integer> cntMap = new HashMap<>();
        for(String id : id_list){
            map.put(id, new HashSet<String>());
            cntMap.put(id, 0);
        }
        
        for(int i=0; i<report.length; i++){
            String[] srr = report[i].split(" ");
            String reporter = srr[0]; //신고자
            
            if(map.containsKey(reporter)){
                map.get(reporter).add(srr[1]);
            }
        }
        
        // 신고당한 사람, 횟수
        for(String reporter : map.keySet()){
            for(String target : map.get(reporter)){
                cntMap.put(target, cntMap.get(target)+1);
            }
        }
        
        // k번 이상 신고당한 사람 집합
        HashSet<String> set = new HashSet<>();
        for(String id : id_list){
            if(cntMap.get(id) >= k){
                set.add(id);
            }
        }
        
        // 각 사용자가 신고한 사람 중 정지된 사람 수 세기
        for(int i=0; i<len; i++){
            int count = 0;
            for(String target : map.get(id_list[i])){
                if(set.contains(target)){
                    count++;
                }
            }
            answer[i] = count;
        }
        
        return answer;
    }
}