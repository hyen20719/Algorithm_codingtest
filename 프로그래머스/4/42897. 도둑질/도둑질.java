import java.util.*;

class Solution {
    int[] money;
    int len;
    
    public int solution(int[] money) {
        int answer = 0;
        this.money = money;
        len = money.length;
        
        if(len == 1){
            return money[0];
        }else if(len == 2){
            return Math.max(money[0], money[1]);
        }
        
        int case1 = getMaxMoney(0, len-2); // 첫번째집 제외
        int case2 = getMaxMoney(1, len-1); // 마지막집 제외
        
        return Math.max(case1, case2);
    }
    
    public int getMaxMoney(int st , int end){
        int prev2 = 0; // money[i-2]
        int prev1 = 0; // money[i-1]
        
        for(int i=st; i<=end; i++){
            int cur = Math.max(prev1, prev2+money[i]);
            prev2 = prev1;
            prev1 = cur;
        }
        
        return prev1;
    }
}