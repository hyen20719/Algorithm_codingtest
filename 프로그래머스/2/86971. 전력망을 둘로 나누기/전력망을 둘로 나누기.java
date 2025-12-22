import java.util.*;

class Solution {
    int[][] wires;
    boolean[] v;
    ArrayList<List<Integer>> list = new ArrayList<>();
    int answer = Integer.MAX_VALUE;
    
    public int solution(int n, int[][] wires) {
        this.wires = wires;
        
        for(int i=0; i<=n; i++){
            list.add(new ArrayList<>());
        }
        
        for(int[] wire : wires){
            list.get(wire[0]).add(wire[1]);
            list.get(wire[1]).add(wire[0]);
        }
        
        for(int i=0; i<wires.length; i++){
            v = new boolean[n+1];
            
            list.get(wires[i][0]).remove(Integer.valueOf(wires[i][1]));
            list.get(wires[i][1]).remove(Integer.valueOf(wires[i][0]));
            
            int part1 = dfs(wires[i][0]);
            int part2 = n - part1;
            
            answer = Math.min(answer, Math.abs(part1-part2));
            
            list.get(wires[i][0]).add(wires[i][1]);
            list.get(wires[i][1]).add(wires[i][0]);
        }
        
        return answer;
    }
    
    public int dfs(int cur){
        v[cur] = true;
        int count = 1;
        
        for(int next : list.get(cur)){
            if(!v[next]){
                count += dfs(next);
            }
        }
        return count;
    }
}