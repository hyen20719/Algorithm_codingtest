class Solution {
    public int solution(int[] queue1, int[] queue2) {
        long sum1 = 0, sum2 = 0;
        int n = queue1.length;

        // 각 큐 합 계산
        for(int i=0; i<n; i++){
            sum1 += queue1[i];
            sum2 += queue2[i];
        }

        long totalSum = sum1 + sum2;
        // 합이 홀수면 절대 동일하게 나눌 수 없음
        if(totalSum % 2 != 0) return -1;

        long target = totalSum / 2;

        // 두 큐를 이어서 하나의 배열처럼 사용
        int[] q = new int[2*n];
        System.arraycopy(queue1, 0, q, 0, n);
        System.arraycopy(queue2, 0, q, n, n);

        int i = 0;      // queue1 front
        int j = n;      // queue2 front
        int cnt = 0;    // 작업 횟수
        int maxMoves = 4 * n; // 안전하게 최대 이동 횟수

        while(cnt <= maxMoves){
            if(sum1 == target) return cnt;

            if(sum1 > target){
                sum1 -= q[i % (2*n)]; // queue1에서 pop
                i++;
            } else {
                sum1 += q[j % (2*n)]; // queue2에서 pop해서 queue1에 insert
                j++;
            }

            cnt++;
        }

        return -1; // 목표 달성 불가
    }
}
