import java.util.*;

import java.util.*;

class Solution {
    String[][]  tickets;
    String[] answer;
    boolean[] v;
    boolean found = false;
        
    public String[] solution(String[][] tickets) {
        this.tickets = tickets;
        int n = tickets.length;
        v = new boolean[n];
        
        Arrays.sort(tickets, (a,b)->{
            if(a[0].equals(b[0])){
                return a[1].compareTo(b[1]);
            }
                return a[0].compareTo(b[0]);
        });
        
        answer = new String[n+1];
        answer[0] = "ICN";
        dfs("ICN", 0);
        
        return answer;
    }
    
    public void dfs(String cur, int cnt){
        if(found) return;
        
        if(cnt == tickets.length){
            found = true;
            return;
        }
        
        for(int i=0; i<tickets.length; i++){
            if(!v[i] && tickets[i][0].equals(cur)){
                v[i] = true;
                answer[cnt+1] = tickets[i][1];
                dfs(tickets[i][1], cnt+1);
                
                if(!found){
                    v[i] = false;
                }
            }
        }
    }
}