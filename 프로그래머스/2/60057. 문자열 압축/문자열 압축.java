class Solution {
    public int solution(String s) {
        
        int len = s.length();
        int answer = len;
        
        for(int i=1; i<len; i++){
            StringBuilder sb = new StringBuilder();
            int count = 1;
            String str = s.substring(0,i);
           // System.out.println(str);
            for(int j=i; j<len; j+=i){
                int end = j+i >len ? len : j+i;
                String str2 = s.substring(j,end);
                //System.out.println("str2 : " + str2);
                
                if(str.equals(str2)){ // 같은 경우
                    count++;
                }else{
                    if(count >1){
                        sb.append(count);
                    }
                    sb.append(str);
                    count = 1;
                }
                str = str2;
            }
            // 문자열의 마지막 부분
            if(count > 1){
                sb.append(count);
            }
            sb.append(str);
            
            answer = Math.min(answer, sb.length());
            
        }
        
        
        return answer;
    }
}