

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(token.nextToken());
        int e = Integer.parseInt(token.nextToken());

        Edge[] edges = new Edge[e];
        for (int i = 0; i < e; i++) {
            token = new StringTokenizer(br.readLine());
            int st = Integer.parseInt(token.nextToken());
            int end = Integer.parseInt(token.nextToken());
            int weight = Integer.parseInt(token.nextToken());

            edges[i] = new Edge(st, end, weight);
        }

        // 가중치 기준 오름차순
        Arrays.sort(edges);

        // union-Find 초기화
        parent = new int[v + 1];
        for (int i = 1; i <= v; i++) {
            parent[i] = i;
        }

        // 크루스칼 알고리즘
        long result = 0;
        int edgeCnt = 0;

        for (Edge edge : edges) {
            if (union(edge.st, edge.end)) {
                result += edge.weight;
                edgeCnt++;

                if(edgeCnt == v-1) break; // 최소 스패닝 트리 완성
            }
        }
        System.out.println(result);

    }

    static int find(int x) {
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if(rootA == rootB) return false; // 같은 집합이면 사이클 제외
        parent[rootB] = rootA; // 아니면 합침
        return true;
    }

    public static class Edge implements Comparable<Edge>{
        int st;
        int end;
        int weight;

        public Edge(int st, int end, int weight){
            this.st = st;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
}
