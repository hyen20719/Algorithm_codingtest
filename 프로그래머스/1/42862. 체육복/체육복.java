import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        int[] p = new int[n+1];
        for(int r : reserve){
            p[r]++;
        }
        for(int l : lost){
            p[l]--;
        }
        
        //System.out.println(Arrays.toString(p));
        // lost에 사람이 남아있으면 그 수만큼 n-lost.length
        for(int i=1; i<p.length-1; i++){
            if(p[i] == 1 && p[i+1] == -1){
                p[i+1]++;
                p[i]--;
               // continue;
            }else if(p[i] == -1 && p[i-1] == 1){
                p[i]++; 
                p[i-1]--;
            }else if(p[i] == -1 && p[i+1] == 1){
                p[i]++; 
                p[i+1]--;
            }
        }
       // System.out.println(Arrays.toString(p));
        for(int i : p){
            if(i == -1){answer--;}
        }
        return answer;
    }
}