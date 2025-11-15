class Solution {
    static int answer = 0;
    static char[] crr = {'A', 'E', 'I', 'O', 'U'};
    static boolean found = false;

    public int solution(String word) {
        backtracking("", word);
        return answer;
    }

    public void backtracking(String current, String word) {
        if (current.length() > 5 || found) return;

        // 길이가 1 이상이면 사전의 단어
        if (current.length() > 0) {
            answer++;
            if (current.equals(word)) {
                found = true; // 찾았으니 모든 탐색 종료
                return;
            }
        }

        for (char c : crr) {
            backtracking(current + c, word);
            if (found) return; // 다른 재귀 못 내려가게 차단
        }
    }
}
