class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        for(int i =left; i<=right; i++){
            //제곱수인 경우 약수의 개수가 홀수 (이중for문 필요x)
            if (i % Math.sqrt(i) == 0) {
            //if(chk(i) % 2 == 0){
                answer -= i; // 홀수 
            }else{
                answer += i; // 짝수
            }
        }
        return answer;
    }
    
    // 약수 구하기
    public int chk(int n){
        int count = 0;
        for(int i=1; i*i<=n; i++){
            if(n % i == 0){
                if(n/i == i){ // 같은 수인 경우 count+1, 다른 수는 count+2
                    count+=1;
                }else{
                    count+=2;
                }
            }
        }
        return count;
    }
}