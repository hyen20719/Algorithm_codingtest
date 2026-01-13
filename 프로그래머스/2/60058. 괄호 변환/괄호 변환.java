import java.util.*;

class Solution {
    public String solution(String p) {
        String answer = "";
        
        if("".equals(p)) return "";
        
        // u,v 분리 
        int idx = 0; // 분리점 기준
        int chk = 0; // 짝이 맞는지 확인하는 변수
        for(int i=0; i<p.length(); i++){
            if(p.charAt(i) == '('){
                chk++;
            }else{
                chk--;
            }
            if(chk == 0){
                idx = i;
                break;
            }
        }
        
        String u = p.substring(0,idx+1);
        String v = p.substring(idx+1);
        
        // u가 올바른 괄호 문자열이면
        if(isCorrect(u)){
            return u + solution(v);
        }else {
            StringBuilder sb = new StringBuilder();
            sb.append("(");
            sb.append(solution(v));
            sb.append(")");

            // u의 첫/끝 제거 후 방향 뒤집기
            for(int i=1; i<u.length()-1; i++){
                if(u.charAt(i) == '('){
                    sb.append(')');
                }else{
                    sb.append('(');
                }
            }
            return sb.toString();  
        }
        
    }
    
    public boolean isCorrect(String str){
        int cnt = 0;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == '(') cnt++;
            else cnt--;
            
            if(cnt < 0) return false; // 올바른 괄호 문자열인지 확인하기 위해
        }
        return cnt == 0;
    }
}