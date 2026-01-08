import java.util.*;

class Solution {
    int cnt = 0;
    int answer = 0;
    String word;
    char[] crr = {'A', 'E', 'I', 'O', 'U'};
    
    public int solution(String word) {
        this.word = word;
        
        dfs("");
        return answer;
    }
    
    public void dfs(String cur){
        if(cur.length() > 5) {
            return;
        }
        if(!cur.equals("")) cnt++;
        
        if(cur.equals(word)){
            answer = cnt;  // word 발견 → answer 저장
            return;
        }
        
        for(char c : crr){
            dfs(cur+c);   
            if(answer != 0) return;
        }
    }
}