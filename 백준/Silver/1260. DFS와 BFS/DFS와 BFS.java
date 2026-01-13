import java.util.*;

public class Main {
    static boolean[] v;
    static ArrayList<Integer>[] nums;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
//        N(노드 개수) M(에지 개수) Start(시작점)
        int N = scan.nextInt();
        int M = scan.nextInt();
        int st = scan.nextInt();

//        A(그래프 데이터 저장 인접 리스트) visited(방문 기록 저장 배열)
        nums = new ArrayList[N + 1];
        for(int i=1; i<=N; i++) {
//            A 인접 리스트의 각 ArrayList 초기화하기
            nums[i] = new ArrayList<Integer>();
        }

//     for(M의 개수만큼 반복하기) {
//        A 인접 리스트에 그래프 데이터 저장하기
//     }
        for(int i=0; i<M; i++){
            int s = scan.nextInt();
            int e = scan.nextInt();
            nums[s].add(e);
            nums[e].add(s);
        }
     // 방문할 수 있는 노드가 여러 개일 경우에는 번호가 작은 것을 먼저 방문하기 위해 정렬하기
        for(int i=1; i<=N; i++){
            Collections.sort(nums[i]);
        }
//            visited 배열 초기화하기
        v = new boolean[N+1];
//      DFS(Start) 실행하기
        dfs(st);
        System.out.println();
//      visited 배열 초기화하기
//      BFS(Start) 실행하기
        v = new boolean[N + 1];
        bfs(st);
        System.out.println();
    }

    public static void dfs(int node){
        System.out.print(node + " ");
        v[node] = true;
        for(int i : nums[node]){
            if(!v[i]){
                dfs(i);
            }
        }
    }

    public static void bfs(int node) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        v[node] = true;
        while(!q.isEmpty()){
            int cur = q.poll();
            System.out.print(cur + " ");
            for (int i : nums[cur]) {
                if(!v[i]){
                    v[i] = true;
                    q.add(i);
                }
            }
        }
    }
    //            DFS { // DFS 구현하기
//                현재 노드 출력하기
//                visited 배열에 현재 노드 방문 기록하기
//                현재 노드의 연결 노드 중 방문하지 않은 노드로 DFS 실행하기(재귀 함수 형태)
//            }
//            BFS{ // BFS 구현하기
//            큐 자료구조에 시작 노드 삽입하기(add 연산)
//            visited 배열에 현재 노드 방문 기록하기
//            While(큐가 비어 있을 때까지) {
//                큐에서 노드 데이터를 가져오기(poLL 연산)
//                가져온 노드 출력하기
//                현재 노드의 연결 노드 중 미방문 노드를 큐에 삽입(add 연산)하고 방문 배열에 기록하기

}
