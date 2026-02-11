import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        
        HashSet<Integer> set = new HashSet<>();
        for(int n : win_nums){
            set.add(n);
        }
        
        int sameCnt = 0;
        int zeroCnt = 0;
        for(int lotto : lottos){
            if(lotto == 0) zeroCnt++;
            if(set.contains(lotto)) sameCnt++;
        }
        
        int lank = 6;
        int worst = sameCnt==0?6 :0;
        for(int i=1; i<7; i++){
            if(sameCnt == i){
                worst = lank;
                break;
            }
            lank--;
        }
        // System.out.println(lank);
        // System.out.println(zeroCnt);
        int best = lank-zeroCnt <1 ? 1 :lank-zeroCnt;
        if(lank == 0 && zeroCnt == 0) best = 6;
        
        return new int[]{best,worst};
    }
}