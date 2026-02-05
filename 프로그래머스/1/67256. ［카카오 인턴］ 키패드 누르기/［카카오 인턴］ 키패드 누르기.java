import java.util.*;

class Solution {
    String hand;
    StringBuilder sb = new StringBuilder();
    int left = 10;
    int right = 12;
    
    public String solution(int[] numbers, String hand) {
        String answer = "";
        this.hand = hand;
        
        for(int n : numbers){
            if(n==0) n = 11;
            // System.out.println(left + " " + right + " " + n);
            if(n == 1 || n == 4 || n == 7){
                sb.append("L");
                left = n;
            }else if(n == 3 || n == 6 || n == 9){
                sb.append("R");
                right = n;
            }else{
                if(chk(n)){
                    sb.append("L");
                    left = n;
                }else{
                    sb.append("R");
                    right = n;
                }
            }
        }
        return sb.toString();
    }
    
    public boolean chk(int n){
        boolean ck = false;
        int leftDistance = Math.abs((left-1)/3 - (n-1)/3) 
                        + Math.abs((left-1)%3 - (n-1)%3);
        int rightDistance = Math.abs((right-1)/3 - (n-1)/3) 
                        + Math.abs((right-1)%3 - (n-1)%3);
                                     
        if(leftDistance < rightDistance){
            ck = true;
        }else if(leftDistance > rightDistance){
            ck = false;
        }else {
            if(hand.equals("left")){
                ck = true;
            }
        }
        
        return ck;
    }
    
}