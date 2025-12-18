import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int len = words.length;
        boolean[] v = new boolean[len];
        
        if(!Arrays.asList(words).contains(target)){
            return 0;
        }
        
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(begin,0));
        
        while(!q.isEmpty()){
            Pair cur = q.poll();
            String word = cur.word;
            int cnt = cur.cnt;
            
            if(word.equals(target)){return cnt;}
            
            for(int i=0; i<len; i++){
                if(!v[i] && differentChk(word, words[i])){
                    v[i] = true;
                    q.offer(new Pair(words[i], cnt+1));
                }
            }
        }
        
        
        return 0;
    }
    
    boolean differentChk(String w, String newWord){
        int count = 0; 
        for(int i=0; i<w.length(); i++){
            if(w.charAt(i) != newWord.charAt(i)){
                count++;
            }
        }
        return count == 1;
    }
    
    class Pair{
        String word;
        int cnt;
        Pair(String w, int c){
            word=w;
            cnt=c;
        }
    }
}