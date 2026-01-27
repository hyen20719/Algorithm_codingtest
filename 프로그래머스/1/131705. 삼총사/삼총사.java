class Solution {
    int count = 0; // 합이 0인 삼총사 개수
    int[] numbers;

    public int solution(int[] number) {
        this.numbers = number;
        dfs(0, 0, 0);
        return count;
    }

    // idx: 현재 위치, selected: 선택한 개수, sum: 현재까지 합
    private void dfs(int idx, int selected, int sum) {
        if (selected == 3) { // 3개 선택 완료
            if (sum == 0) count++;
            return;
        }

        if (idx == numbers.length) return; // 끝까지 갔는데 3개 못 고름

        // 1) numbers[idx] 선택
        dfs(idx + 1, selected + 1, sum + numbers[idx]);

        // 2) numbers[idx] 선택 안함
        dfs(idx + 1, selected, sum);
    }
}
