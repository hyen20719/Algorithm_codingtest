import java.util.*;

class Solution {
    public String solution(String s) {
        String[] srr = s.split(" ", -1);
        StringBuilder sb = new StringBuilder();
        System.out.println(srr.length);
        
        for(int n=0; n<srr.length; n++){
            String r = srr[n];
            for(int i=0; i<r.length(); i++){
                Character c = r.charAt(i);
                if(i%2==0){ //짝수
                    sb.append(Character.toUpperCase(c));
                }else{ //홀수
                    sb.append(Character.toLowerCase(c));
                }
            }
            if(n < srr.length-1) sb.append(" ");
        }
        return sb.toString();
    }
}