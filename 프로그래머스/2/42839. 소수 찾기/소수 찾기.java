import java.util.*;

class Solution {
    static boolean[] visited;
    static HashSet<Integer> set = new HashSet<>();
    static String numbers;

    public int solution(String numbers) {
        this.numbers = numbers;
        visited = new boolean[numbers.length()];
        
        dfs("", 0);   // 빈 문자열부터 시작
        
        // set 안에는 소수만 들어 있음
        int count = 0;
        for (int n : set) {
            if (isPrime(n)) count++;
        }
        return count;
    }
    
    public void dfs(String current, int depth) {
        // current가 비어 있지 않으면 숫자로 변환해 set에 추가
        if (!current.equals("")) {
            set.add(Integer.parseInt(current));
        }

        // 더 이상 만들 수 없는 경우 종료
        if (depth == numbers.length()) return;
        
        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                
                dfs(current + numbers.charAt(i), depth + 1);
                
                visited[i] = false;   // 백트래킹
            }
        }
    }

    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
