import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        int total = 0;
        int len = tangerine.length;
        Arrays.sort(tangerine);
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int t : tangerine){
            map.put(t, map.getOrDefault(t,0)+1);
        }
        //System.out.println(map);
        
        List<Integer> counts = new ArrayList<>(map.values());
        Collections.sort(counts, Collections.reverseOrder());
        //System.out.println(counts);
        
        for(int count : counts){
            total+=count;
            answer++;
            if(total >= k){
                break;
            }
        }
        
        return answer;
    }
}