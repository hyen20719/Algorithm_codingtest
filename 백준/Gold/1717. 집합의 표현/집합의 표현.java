import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());

        parent = new int[n+1];

        for(int i=0; i<=n; i++){
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            token = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(token.nextToken());
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());

            if(type == 0){ // 합집합
                union(a, b);
            }else{ // 같은 집합 체크
                if(find(a) == find(b)){
                    sb.append("YES\n");
                }else{
                    sb.append("NO\n");
                }
            }

        }
        System.out.println(sb.toString());
    }

    public static void union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);
        if(rootA != rootB){
            parent[rootB] = rootA;
        }
    }

    public static int find(int n){
        if(parent[n] == n) return n;
        return parent[n] = find(parent[n]);
    }

    public static boolean checkSame(int a, int b) {
        a = find(a);
        b = find(b);
        if(a == b){
            return true;
        }
        return false;
    }
}
