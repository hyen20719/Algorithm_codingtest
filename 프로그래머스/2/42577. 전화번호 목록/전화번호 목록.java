import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        //중복없으니 hashset으로
        HashSet<String> set = new HashSet<>();
        for(String p : phone_book){
            set.add(p);
        }
        
        for(String phone : phone_book){
            for(int i=1; i<phone.length(); i++){
                String prefix = phone.substring(0, i); // 전화번호 길이-1이라 같은번호로 체크하는 경우 x
                
                if(set.contains(prefix)){ // 접두어인 경우
                    return answer = false;
                }
            }
        }
        
        return answer;
    }
}