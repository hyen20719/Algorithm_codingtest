
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    // 가지치기가 중요한 문제
    // 인덱스와 값의 차이가 같은 경우 => 대각선
    // 값이 이 전의 값과 동일한 경우 => 일직선
    static int[] A; // 체스판
    static int N; // 체스판 크기
    static int cnt = 0; // 경우의 수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        A = new int[N];
        backtraking(0);
        System.out.println(cnt);
        
    }

    private static void backtraking(int row) {
        if (row == N) { // 정답 출력
            cnt++;
            return;
        }

        for (int i = 0; i < N; i++) { // 모든 경우의 수 탐색
            A[row] = i;
            if (check(row)) { // 가지치기 유효성 검사 
                backtraking(row+1);

                // 풀어썼을때
                /*row +=1;
                backtraking(row);
                row -=1;*/
            }
        }

    }

    private static boolean check(int row) {
        for (int i = 0; i < row; i++) {
            if(A[i] == A[row]) return false; // 일직선 공격
            if(Math.abs(row-i) == Math.abs(A[row]-A[i])) return false; // 대각선 공격
        }
        return true;
    }
}
