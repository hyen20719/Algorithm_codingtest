import java.util.*;

class Solution {
    String numbers;
    int len;
    boolean[] v;
    Set<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        int answer = 0;
        this.numbers = numbers;
        len = numbers.length();
        v = new boolean[len];
        
        dfs("");
        
        return set.size();
    }
    
    public void dfs(String cur){
        
        if(!cur.equals("")){
            int num = Integer.parseInt(cur);
            if(isPrime(num)){
                set.add(num);
            }
        }
        
        for(int i=0; i<len; i++){
            if(!v[i]){
                v[i] = true;
                dfs(cur+numbers.charAt(i));
                v[i] = false;
            }
        }
    }
    
    boolean isPrime(int n){
        if( n < 2) return false;
        for(int i=2; i*i<=n; i++){
            if(n % i == 0) return false;
        }
        return true;
    }
}