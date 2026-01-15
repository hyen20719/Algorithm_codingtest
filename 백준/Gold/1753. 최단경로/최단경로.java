
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(token.nextToken()); //정점의 개수
        int E = Integer.parseInt(token.nextToken()); //간선의 개수
        int K = Integer.parseInt(br.readLine()); // 시작점

        int[] distance = new int[V + 1]; // 최단거리 배열
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[K] = 0;

        boolean[] v = new boolean[V + 1];
        ArrayList<Node>[] graph = new ArrayList[V + 1]; // 인접리스트
        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            token = new StringTokenizer(br.readLine());
            int st = Integer.parseInt(token.nextToken());
            int end = Integer.parseInt(token.nextToken());
            int w = Integer.parseInt(token.nextToken()); // 거리
            graph[st].add(new Node(end, w));
        }

        // 다익스트라용 우선순위 큐
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(K,0));

        // 다익스트라 실행
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int curv = cur.v;
            int curw = cur.w;

            // 이미 더 짧은 경로가 있으면 무시
            if(distance[curv] < curw) continue;

            for (Node next : graph[curv]) {
                if (distance[next.v] > distance[curv] + next.w) {
                    distance[next.v] = distance[curv] + next.w;
                    pq.offer(new Node(next.v, distance[next.v]));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if(distance[i] == Integer.MAX_VALUE) sb.append("INF\n");
            else sb.append(distance[i]+"\n");
        }
        System.out.println(sb);

}
    // 간선 클래스
    static class Node implements Comparable<Node> {
        int v; // 도착 정점
        int w; // 거리

        Node(int v, int w) {
            this.v = v;
            this.w = w;
        }

        // PriorityQueue에서 거리 기준 오름차순
        @Override
        public int compareTo(Node o) {
            return this.w - o.w;
        }
    }
}
