
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(token.nextToken()); // 건물개수
        int[] time = new int[N + 1]; // 각 건물 짓는 시간
        int[] sums = new int[N + 1]; // i번 건물 완성하는데 걸리는 최소 시간
        int[] indeg = new int[N + 1]; // 선행 건물 개수(진입 차수)

        // 시간 뒤에 들어온 건물번호를 먼저 지어야 가능하기에
        List<Integer>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i < N + 1; i++) {
            token = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(token.nextToken());

            while(true){
                int prev = Integer.parseInt(token.nextToken()); // 선행 건물
                if(prev == -1){
                    break;
                }
                graph[prev].add(i);
                indeg[i]++;
            }
        }
        // 위상 정렬을 위한 큐
        Queue<Integer> q = new LinkedList<>();

        // 선행 건물 없는 건물부터
        for (int i = 1; i < N + 1; i++) {
            sums[i] = time[i];
            if(indeg[i] == 0){ //바로 시작 가능
                q.add(i);
            }
        }

        //위상정렬+DP
        while (!q.isEmpty()) {
            int cur = q.poll(); // 현재 건물

            // cur 이후 지을 수 있는 건물들
            for(int next : graph[cur]){

                //next는 cur이 끝난 뒤 시작 가능
                // 여러 선행 중 가장 늦게 끝나는 시간 선택
                sums[next] = Math.max(sums[next], sums[cur] + time[next]);

                // 선행 조건 하나 제거
                indeg[next]--;

                // 모든 선행 조건 끝났을시 큐에 추가
                if (indeg[next] == 0) {
                    q.add(next);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            sb.append(sums[i] + "\n");
        }
        System.out.println(sb.toString());
    }
}
