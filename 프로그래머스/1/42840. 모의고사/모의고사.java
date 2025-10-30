import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] result = new int[3];
        // 1번 수포자 
        int[] person1 = new int[]{1, 2, 3, 4, 5};
        // 2번 수포자
        int[] person2 = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        // 3번 수포자 
        int[] person3 = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        // 정답 갯수
        for(int i =0; i<answers.length; i++){
            if (answers[i] == person1[i % person1.length]){
                result[0]++;
            }
            if (answers[i] == person2[i % person2.length]){
                result[1]++;
            }
            if (answers[i] == person3[i % person3.length]){
                result[2]++;
            }
        }
        
        // 가장 높은 점수 여러명인 경우 체크
        int maxNum = Math.max(result[0],Math.max(result[1], result[2]));

        // 동점자도 고려하여 list로 저장
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<result.length; i++){
            if(result[i] == maxNum){
                list.add(i+1);
            }
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
        
        
    }
    
}