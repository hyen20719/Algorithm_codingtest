import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        // 보석 종류 set
        Set<String> gemTypes = new HashSet<>(Arrays.asList(gems));
        int typeCnt = gemTypes.size();
        
        Map<String, Integer> map = new HashMap<>();
        int left =0, right =0;
        int minLength = Integer.MAX_VALUE; // 최소 구간 길이 
        int[] tempAnswer = new int[2]; // 임시 저장소
        
        // 슬라이딩 윈도우
        while(right < gems.length){
            String cur = gems[right];
            map.put(cur, map.getOrDefault(cur, 0)+1);
            right++;
            
            while(map.size() == typeCnt){
                if(right - left < minLength){
                    minLength = right - left;
                    tempAnswer[0] = left +1;
                    tempAnswer[1] = right;
                }
                
                // left 포인터 이동시켜 구간 축소
                String leftGem = gems[left];
                map.put(leftGem, map.get(leftGem)-1);
                if(map.get(leftGem) == 0){
                    map.remove(leftGem);
                }
                left++;
                
            }
        }
        
        answer[0] = tempAnswer[0];
        answer[1] = tempAnswer[1];
        
        return answer;
    }
}