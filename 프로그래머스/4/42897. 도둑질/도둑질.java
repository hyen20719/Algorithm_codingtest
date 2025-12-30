import java.util.*;

class Solution {
    int[] money; 
    
    public int solution(int[] money) {
        this.money = money;
        
        int answer = 0;
        int len = money.length;
        
        
        if ( len == 1) {
            return money[0];
        }
        
        // 첫 번째 집을 털지 않는 경우와 마지막 집을 털지 않는 경우를 각각 계산
        int case1 = getMaxMoney(len, 0, len - 2);  // 첫 번째 집을 제외하고 계산
        int case2 = getMaxMoney(len, 1, len - 1);  // 마지막 집을 제외하고 계산

        // 두 경우 중 더 큰 값을 반환
        return Math.max(case1, case2);
    }
    
    // 집을 털지 않거나 털 때의 최대 금액을 구하는 함수
    private int getMaxMoney(int n, int start, int end) {
        int[] dp = new int[n];
        
        dp[start] = money[start];  // 첫 번째 집을 털었을 때
        dp[start + 1] = Math.max(money[start], money[start + 1]);  // 첫 번째와 두 번째 집 중 더 큰 금액
        
        // 점화식 적용
        for (int i = start + 2; i <= end; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + money[i]);
        }
        
        return dp[end];
    }
}