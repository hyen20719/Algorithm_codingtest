import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(token.nextToken()); // 도시 수
        int M = Integer.parseInt(token.nextToken()); // 도로 수
        ArrayList<Node> graph = new ArrayList<>();
        long[] dist = new long[N+1]; // 최단거리 저장
        for (int i = 1; i <= N; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[1] = 0; //시작

        for (int i = 1; i <= M; i++) {
            token = new StringTokenizer(br.readLine());
            int st = Integer.parseInt(token.nextToken());
            int end = Integer.parseInt(token.nextToken());
            int cost = Integer.parseInt(token.nextToken());
            graph.add(new Node(st, end, cost));
        }

        for(int i=1; i<N; i++){
            for (Node edge : graph) {
                if(dist[edge.st] != Integer.MAX_VALUE
                        && dist[edge.st] + edge.cost < dist[edge.end]){
                    dist[edge.end] = dist[edge.st] + edge.cost;
                }
            }
        }

        // 음수 사이클 탐지
        boolean negative = false;
        for (Node edge : graph) {
            if (dist[edge.st] != Integer.MAX_VALUE
                    && dist[edge.st] + edge.cost < dist[edge.end]) {
                negative = true;
                break;
            }
        }

        if(negative){
            System.out.println("-1");
        }else{
            for (int i = 2; i <= N; i++) {
                if (dist[i] == Integer.MAX_VALUE) {
                    System.out.println("-1");
                }else{
                    System.out.println(dist[i]);
                }
            }
        }

    }

    static class Node{
        int st;
        int end;
        int cost;

        public Node(int st, int end, int cost) {
            this.st = st;
            this.end = end;
            this.cost = cost;
        }
    }
}
