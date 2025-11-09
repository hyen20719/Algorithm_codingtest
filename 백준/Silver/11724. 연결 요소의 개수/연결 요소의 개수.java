import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visited;
    static ArrayList<Integer>[] list;
    public static void main(String args[])throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 정점의 갯수
        int m = Integer.parseInt(st.nextToken()); // 간선의 갯수
        
        visited = new boolean[n+1];
        list = new ArrayList[n+1];
        
        for(int i=1; i<=n; i++){
            list[i] = new ArrayList<Integer>();
        }
        
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()); // 시작점
            int e = Integer.parseInt(st.nextToken()); // 종료점
            list[s].add(e);
            list[e].add(s);
        }
        int count = 0;
        for(int i=1; i<=n; i++){
            if(!visited[i]){
                count++;
                dfs(i);
            }
        }
        System.out.println(count);
    }

    public static void dfs(int v){
        if(visited[v]){
            return;
        }
        visited[v] = true;
        for(int i : list[v]){
            if(!visited[i]){
                dfs(i);
            }
        }
    } 
    
}
