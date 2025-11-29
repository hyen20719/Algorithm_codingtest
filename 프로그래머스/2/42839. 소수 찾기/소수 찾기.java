class Solution {
    static String numbers;
    static boolean[] v; // 방문 여부
    static boolean[] checked; // 이미 계산한 숫자 여부
    static int answer;
    
    public int solution(String numbers) {
        answer = 0;
        this.numbers = numbers;
        v = new boolean[numbers.length()];
        checked = new boolean[100000000];
        
        dfs("", 0);
        return answer;
    }
    
    public void dfs(String cur, int depth){
        // 숫자 조합이 비어있지않을때 소수 판별
        if(!cur.equals("")){
            int num = Integer.parseInt(cur);
            if(!checked[num] && isPrime(num)){ // 중복 체크 같이
                checked[num] = true;
                answer++;
            }
        }
        
        if(depth == numbers.length()){
            return;
        }
        
        
        for(int i=0; i<numbers.length(); i++){
            if(!v[i]){
                v[i] = true;
                dfs(cur+numbers.charAt(i), depth+1);
                v[i] = false; // 다른 조합 탐색을 위해 복원
            }
        }
    }
    
    // 소수 찾기
    public boolean isPrime(int num){
        boolean chk = true;
        if(num < 2){chk = false; return chk;}
        for(int i=2; i*i<=num; i++){
            if(num % i == 0){
                return false;
            }
        }
        return chk;
    }
}