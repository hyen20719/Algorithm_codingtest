class Solution {
    static int[] numbers;
    static int target;
    static int answer;
    
    public int solution(int[] numbers, int target) {
        this.answer = 0;
        this.numbers = numbers;
        this.target = target;
        
        dfs(0,0); // index, sum
        return answer;
    }
    
    public void dfs(int index, int sum){
         if(index == numbers.length){
            if(sum == target){
                answer++;
            }
             return;
         }
       // System.out.println(index + " , " + sum);
        dfs(index+1, sum+numbers[index]);
        dfs(index+1, sum-numbers[index]);
    }
}