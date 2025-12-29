import java.util.*;

class Solution {
    public int solution(String arr[]) {
       
        // 1️⃣ 숫자 / 연산자 분리
        List<Integer> num = new ArrayList<>();
        List<Character> c = new ArrayList<>();
        
        for(int i=0; i<arr.length; i++){
            if(i%2 == 0){
                num.add(Integer.parseInt(arr[i]));
            }else{
                c.add(arr[i].charAt(0));
            }
        }
        
        int N = num.size();

        // 2️⃣ DP 배열 선언
        int[][] minDp = new int[N][N];
        int[][] maxDp = new int[N][N];

        // 3️⃣ 초기값 (길이 1 구간)
        for(int i=0; i<N; i++){
            minDp[i][i] = num.get(i);
            maxDp[i][i] = num.get(i);
        }
        
        // 4️⃣ 구간 길이 증가
        for(int len=2; len<=N; len++){
            for(int i=0; i+len-1<N; i++ ){
                int j = i+len-1;
                
                minDp[i][j] = Integer.MAX_VALUE;
                maxDp[i][j] = Integer.MIN_VALUE;
                
               // System.out.println(len);
               // System.out.println(i+ ", "+j);
                //System.out.println("======");
                
                for(int k=i; k<j; k++){
                    char op = c.get(k);
                    
                    if(op == '+'){
                       // System.out.println(i+ ", "+j+ ", "+k);
                       // System.out.println(minDp[i][j] + " , "+ minDp[i][k] + " , "+ minDp[k + 1][j]);
                        minDp[i][j] = Math.min(minDp[i][j],minDp[i][k] + minDp[k + 1][j]);
                        maxDp[i][j] = Math.max(maxDp[i][j], maxDp[i][k] + maxDp[k+1][j]);
                    }else{ // -
                        minDp[i][j] = Math.min(minDp[i][j] , minDp[i][k] - maxDp[k+1][j]);
                        maxDp[i][j] = Math.max(maxDp[i][j] , maxDp[i][k] - minDp[k+1][j]);
                    }
                }
                
            }
        }
        
        // 6️⃣ 전체 수식의 최댓값 반환
        return maxDp[0][N-1];
    }
}