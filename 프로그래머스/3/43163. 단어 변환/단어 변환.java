import java.util.*;

class Solution {
    static String begin;
    static String target;
    static String[] words;
    static boolean[] v; //방문한 단어 추적하는 배열
    static int answer = Integer.MAX_VALUE;
    
    public int solution(String begin, String target, String[] words) {
        this.begin = begin;
        this.target = target;
        this.words = words;
        v = new boolean[words.length];
        
        if(!Arrays.asList(words).contains(target)){
            return 0;
        }
        
        // begin과 현재 변환 횟수로 시작
        dfs(begin, 0);
        
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
    
    public void dfs(String w, int count){
        // 새로운 begin이 target과 같을때 종료
        if(w.equals(target)){
            answer = Math.min(answer, count);
            return;
        }
        
        for(int i=0; i<words.length; i++){
            // 방문하지 않았을때
            if(!v[i]){
                String word = words[i];
                int cnt = 0; // 두 단어가 한글자만 다른지 확인
                
                for(int j=0; j<word.length(); j++){
                    if(w.charAt(j) != word.charAt(j)){
                        cnt++;
                    }
                }

                if(cnt == 1){
                    v[i] = true;
                    dfs(word, count+1);
                    v[i] = false;
                }    
            }
            
        }
    }
    
    
}