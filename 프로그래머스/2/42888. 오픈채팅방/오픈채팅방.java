import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        String[] answer = {};
        Map<String, String> map = new HashMap<>(); // id, 닉네임
        List<String[]> events = new ArrayList<>(); // type, id 
        
        for(int i=0; i<record.length; i++){
            String[] r = record[i].split(" ");
            String type = r[0];
            String id = r[1];
            
            switch(type){
                case "Enter" : 
                    map.put(id, r[2]); 
                    events.add(new String[]{type, id});
                    break;
                case "Leave" : 
                    events.add(new String[]{type, id}); break;
                case "Change": 
                    map.put(id, r[2]); break;
            }
        }
        int len = events.size();
        answer = new String[len];
        for(int i=0; i<len; i++){
            String[] s = events.get(i);
            String type = s[0];
            String id = s[1];
            String name = map.get(id);
            
            if(type.equals("Enter")){
                answer[i] = name +"님이 들어왔습니다.";
            }else{
                answer[i] = name +"님이 나갔습니다.";
            }
            
        }
        
        return answer;
    }
}