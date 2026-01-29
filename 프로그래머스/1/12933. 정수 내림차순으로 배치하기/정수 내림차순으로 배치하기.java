import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        String st = String.valueOf(n);
        int[] arr = new int[st.length()];

        for(int i=0; i<st.length(); i++){
            //System.out.println(st.charAt(i));
            arr[i] = st.charAt(i)-'0';
        }
        
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for(int i=arr.length-1; i>=0; i--){
            sb.append(arr[i]);
        }
        return Long.parseLong(sb.toString());
    }
}