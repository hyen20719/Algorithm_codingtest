import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visited;
    static int[] list;
    static int n,m;
    public static void main(String args[]) throws IOException {
        // 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
        //1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열

       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        //n = 4;
        //m = 2;
        list = new int[n];
        visited = new boolean[n];
        backtraking(0);
    }

    private static void backtraking(int num) {
        if(num == m){ // 출력하기
            printArray();
            return;
        }

        for(int i=0; i<n; i++){ // 갈 수 있는 모든 선택지
            if(!visited[i]){ // 방문하지 않았다면
                visited[i] = true;
                list[num] = i;
                backtraking(num + 1);
                visited[i] =false;
            }
        }

    }

    private static void printArray(){
        for(int i=0; i<m; i++){
            System.out.print(list[i] + 1 + " ");
        }
    }
}
