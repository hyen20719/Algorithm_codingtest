
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        int[] inde = new int[N + 1];
        for (int i = 0; i < M; i++) {
            token = new StringTokenizer(br.readLine());
            int st = Integer.parseInt(token.nextToken());
            int end = Integer.parseInt(token.nextToken());
            list.get(st).add(end);
            inde[end]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (inde[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int cur = q.poll();
            System.out.print(cur+" ");

            for(int next : list.get(cur)){
                inde[next]--;
                if (inde[next] == 0) {
                    q.add(next);
                }
            }
        }

    }
}
