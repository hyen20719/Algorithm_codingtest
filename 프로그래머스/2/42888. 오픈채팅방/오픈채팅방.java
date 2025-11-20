import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        int len = record.length;
        String[] answer = new String[len];
        int idx = 0;
        
        Map<String, String> map = new HashMap<>();
        
        for(int i=0; i<len; i++){
            String[] srr = record[i].split(" ");
            String type = srr[0];
            String id = srr[1];
            
            switch(type){
                case "Enter" : 
                    map.put(id, srr[2]);
                    answer[idx++] = id+"님이 들어왔습니다."; break;
                case "Leave" : 
                    answer[idx++] = id+"님이 나갔습니다."; break;
                case "Change" :
                   map.put(id, srr[2]); break;
            }
        }
        
        String[] irr = Arrays.copyOf(answer,idx);
       // System.out.println(Arrays.toString(irr));
        for(int i=0; i<irr.length; i++){
            String s = irr[i];
            
            String id = s.substring(0, s.indexOf("님"));
            irr[i] = s.replace(id, map.get(id));
        }
        
        return irr;
    }
}