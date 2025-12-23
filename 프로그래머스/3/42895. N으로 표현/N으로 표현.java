import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int N, int number) {
        int answer = 0;
        if(N == number) return 1;
        
        List<Set<Integer>> list = new ArrayList<>();
        for(int i=0; i<=8; i++){
            list.add(new HashSet<>());
        }
        
        for(int i=1; i<=8; i++){
            // N반복 붙이기
            list.get(i).add(Integer.parseInt(String.valueOf(N).repeat(i)));
            
            // 이전 집합 조합해서 새로운 수 만들기
            for(int j=1; j<i; j++){
                combine(list.get(j), list.get(i-j),list.get(i));
            }
            
            if(list.get(i).contains(number)) return i;
        }
        
        
        return -1;
    }
    
    private void combine(Set<Integer> set1, Set<Integer> set2, Set<Integer> target){
        for(int x : set1){
            for(int y : set2){
                target.add(x+y);
                target.add(x-y);
                target.add(y-x);
                target.add(x*y);
                if(y!=0) target.add(x/y);
                if(x!=0) target.add(y/x);
            }
        }
    }
}