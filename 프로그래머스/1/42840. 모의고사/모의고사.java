import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        ArrayList<Integer> list = new ArrayList<>();
        int maxCnt = 0; // 가장 높은 점수
        int[] p1 = {1, 2, 3, 4, 5};
        int[] p2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] p3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int c1 = cntChk(answers, p1);
        int c2 = cntChk(answers, p2);
        int c3 = cntChk(answers, p3);
        maxCnt = Math.max(c1, Math.max(c2,c3));
        
        if(maxCnt == c1){list.add(1);}
        if(maxCnt == c2){list.add(2);}
        if(maxCnt == c3){list.add(3);}
        
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
    
    public int cntChk(int[] answers, int[] p){
        int count = 0;
        for(int i=0; i<answers.length; i++){
            if(answers[i] == p[i%p.length]){
                count++;
            }
        }
        return count;
    }
}