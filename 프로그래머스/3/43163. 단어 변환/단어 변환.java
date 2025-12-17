import java.util.*;

class Solution {
    String[] words;
    String target;
    boolean[] v;
    int answer = Integer.MAX_VALUE;
    
    public int solution(String begin, String target, String[] words) {
        this.words = words;
        this.target = target;
        v = new boolean[words.length];
        
        if(!Arrays.asList(words).contains(target)){
            return 0;
        }
        
        dfs(begin, 0);
        
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
    
    public void dfs(String w, int cnt){
        
        if(w.equals(target)){
            answer = Math.min(answer, cnt);
            return;
        }
        
        for(int i=0; i<words.length; i++){
            if(!v[i]){
                String word = words[i];
            
                int count = 0;
                for(int j=0; j<word.length(); j++){
                    if(word.charAt(j) != w.charAt(j)){
                        count++;
                    }
                }
                if(count == 1){
                    v[i] = true;
                    dfs(word, cnt+1);
                    v[i] = false;
                }
            }
        }
    }
}