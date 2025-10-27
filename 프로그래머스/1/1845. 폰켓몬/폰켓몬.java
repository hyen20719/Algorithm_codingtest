import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        // 중복 제거 hashSet
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        // 여러 종류 선택하는 최댓값이지만 N/2마리로 제한이 있기때문에
        answer = Math.min(nums.length/2 , set.size());
        
        return answer;
    }
}