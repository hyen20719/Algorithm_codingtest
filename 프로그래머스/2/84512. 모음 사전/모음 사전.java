import java.util.*;

class Solution {
    boolean found = false;
    int answer = 0;
    char[] crr = new char[]{'A', 'E', 'I', 'O', 'U'};
    String word;
    int len;
    
    public int solution(String word) {
        len = crr.length;
        this.word = word;
        
        dfs("", 0);   
        
        return answer;
    }
    
    public void dfs(String cur, int depth){
        
        if(cur.equals(word)){
            found = true;
            return;    
        } 
        if(depth == 5) return;
        
        for(int i=0; i<5; i++){
            //System.out.println(cur);
            answer++;  
            dfs(cur+crr[i], depth+1);
            if(found) return;
             
        }
    }
}