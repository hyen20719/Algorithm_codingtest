import java.util.*;

class Solution {
    static int n;  // 전력소의 수
    static int[][] wires;  // 전선 정보
    static boolean[] visited;  // 방문 여부 배열

    public int solution(int n, int[][] wires) {
        this.n = n;
        this.wires = wires;
        int len = wires.length;
        int answer = Integer.MAX_VALUE;  // 최소값을 구할 변수
        
        // 전선 하나씩 끊어보면서 두 그룹으로 나누기
        for (int i = 0; i < len; i++) {
            visited = new boolean[n + 1];  // 방문 배열 초기화
            int group1Size = dfs(i, wires[0][0]);  // 첫 번째 그룹 크기 계산

            // 두 번째 그룹 크기 = 전체 전력소 수 - 첫 번째 그룹 크기
            int group2Size = n - group1Size;

            // 그룹 크기 차이를 구하고, 최소값을 answer에 저장
            int diff = Math.abs(group1Size - group2Size);
            answer = Math.min(answer, diff);
        }
        
        return answer;
    }

    // DFS 함수: 하나의 그룹을 찾은 후, 그룹 크기 반환
    private int dfs(int skipWire, int currentNode) {
        visited[currentNode] = true;
        int groupSize = 1;  // 현재 노드를 포함한 그룹 크기

        // 연결된 노드들 탐색
        for (int i = 0; i < wires.length; i++) {
            // skipWire는 끊어야 할 전선이므로 그 전선은 탐색하지 않음
            if (i == skipWire) continue;

            int node1 = wires[i][0];
            int node2 = wires[i][1];

            // currentNode가 node1이면 node2로 연결된 노드를 탐색
            if (node1 == currentNode && !visited[node2]) {
                groupSize += dfs(skipWire, node2);
            }
            // currentNode가 node2이면 node1로 연결된 노드를 탐색
            else if (node2 == currentNode && !visited[node1]) {
                groupSize += dfs(skipWire, node1);
            }
        }

        return groupSize;  // 그룹 크기 반환
    }
}
