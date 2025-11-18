import java.util.*;

class Solution {
    // 숫자를 좌표로 바꾸는 함수
    int[] getpos(int n){
        if(n == 0) return new int[]{3,1};
        if(n == 10) return new int[]{3,0}; //*위치
        if(n == 11) return new int[]{3,2}; //#위치
        return new int[]{(n-1)/3 ,(n-1)%3};
    }
    // 거리 계산
        int dist(int a, int b){
            int[] A = getpos(a);
            int[] B = getpos(b);
            return Math.abs(A[0]-B[0]) + Math.abs(A[1]-B[1]);
        }
    
    public String solution(int[] numbers, String hand) {
        String answer = "";
        // [1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5]
        //  L  R  L  L  L  R  L  L  R  R  L
        
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1,"L");
        map.put(4,"L");
        map.put(7,"L");
        map.put(3,"R");
        map.put(6,"R");
        map.put(9,"R");
        
        int rcur=10, lcur=11; // 0으로 초기화시 좌표가 다르게 계산되기때문
        for(int i=0; i<numbers.length; i++){
            int key = numbers[i];
            if(map.containsKey(key)){
                String val = map.get(key);
                if("L".equals(val)){
                    lcur = key;
                }else{
                    rcur = key;
                }
                answer += val;
            }else{
               // 가운데 열이면 거리 계산 
                int leftDist = dist(lcur, key);
                int rightDist = dist(rcur, key);
                
                if( rightDist > leftDist){
                    answer += "L";
                    lcur = key;
                }else if(rightDist < leftDist){
                    answer += "R";
                    rcur = key;
                }else{
                    // 같은 경우 hand 기준
                    if(hand.equals("left")){
                        answer += "L";
                        lcur = key;
                    }else{
                        answer += "R";
                        rcur = key;
                    }
                }
            }
        }
        
        return answer;
    }
}