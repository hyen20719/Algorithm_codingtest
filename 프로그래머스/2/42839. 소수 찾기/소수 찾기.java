import java.util.*;

class Solution {
    String numbers;
    boolean[] v;
    int len;
    int answer = 0;
    ArrayList<Integer> list = new ArrayList<>(); // 중복 체크를 위해
    
    public int solution(String numbers) {
        this.numbers = numbers;
        len = numbers.length();
        v = new boolean[len];
        
        dfs("");
        
        return answer;
    }
    
    public void dfs(String cur){
        if(!cur.equals("")){
            int n = Integer.parseInt(cur);
            if(isPrime(n) && !list.contains(n)){
                list.add(n);
                answer++;
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
    
    public boolean isPrime(int n){
        if(n < 2) return false;
        for(int i=2; i*i<=n; i++){
            if(n % i == 0){ return false;}
        }
        return true;
    }
}