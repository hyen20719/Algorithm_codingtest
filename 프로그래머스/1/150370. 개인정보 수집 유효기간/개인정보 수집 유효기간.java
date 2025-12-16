import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        
        // 각 보관기간
        Map<String,Integer> map = new HashMap<>();
        for(String term : terms){
            String[] t = term.split(" ");
            map.put(t[0], Integer.parseInt(t[1]));
        }

        String[] todays = today.split("\\.");
        int todayY = Integer.parseInt(todays[0]);
        int todayM = Integer.parseInt(todays[1]);
        int todayD = Integer.parseInt(todays[2]);
        int todayTotal = todayY*12*28 + todayM*28 +todayD;
        
        for(int i=0; i<privacies.length; i++){
            String[] p = privacies[i].split(" ");
            String[] date = p[0].split("\\.");
            int term = map.get(p[1]);
            
            int year = Integer.parseInt(date[0]);
            int month = Integer.parseInt(date[1]);
            int day = Integer.parseInt(date[2]);
            
            // 총 일수 계산 
            int privacyDay = year *12*28 + month*28 + day;
            privacyDay += term *28; // 만료일 
            
           // System.out.println(privacyDay);
            if(privacyDay <= todayTotal){
                answer.add(i+1);
            }
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}