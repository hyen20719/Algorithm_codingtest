class Solution {
    public int solution(String s) {
        int len = s.length();
        int answer = len;
        
        for(int i=1; i<=len/2; i++){
            StringBuilder sb = new StringBuilder();
            String str = s.substring(0, i);
            int count = 1;
            
            for(int j=i; j<=len; j+=i){
                int end = j+i;
                if(end > len) end = len;
                
                String str2 = s.substring(j, end);
                
                if(str.equals(str2)){
                   // System.out.println(str2);
                    count++;
                   // System.out.println(str);
                }else{
                    if(count > 1){
                        sb.append(count);
                    }
                    sb.append(str);
                    
                    // 새조각으로
                    str = str2;
                    count = 1;
                }
                
            }
            
             // 마지막 남은 조각 
            if(count > 1){
                sb.append(count);
            }
            sb.append(str);
            
            answer = Math.min(answer, sb.length());
        }

        
        return answer;
    }
}