

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 도시 수
        int m = Integer.parseInt(br.readLine()); // 버스 수
        long[][] dis = new long[n+1][n+1];

        // 초기화 (시작도시 도착도시 같으면 0 아니면 무한대로)
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(i==j) dis[i][j] = 0;
                else dis[i][j] = Integer.MAX_VALUE;
            }
        }

        for(int i=0; i<m; i++){
            StringTokenizer token = new StringTokenizer(br.readLine());
            int st = Integer.parseInt(token.nextToken());
            int end = Integer.parseInt(token.nextToken());
            int cost = Integer.parseInt(token.nextToken());

            if(dis[st][end] > cost) dis[st][end] = cost;
        }

        // 플로이드 워셜 알고리즘
        for (int k = 1; k <= n; k++) { // 중간 경유지
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if(dis[i][j] > dis[i][k] + dis[k][j]){
                        dis[i][j] = dis[i][k] + dis[k][j];
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(dis[i][j] == Integer.MAX_VALUE) System.out.print("0 ");
                else System.out.print(dis[i][j] + " ");
            }
            System.out.println();
        }


    }
}
