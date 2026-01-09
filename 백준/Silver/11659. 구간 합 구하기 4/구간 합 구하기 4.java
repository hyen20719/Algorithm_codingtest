
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[] nums = new long[N + 1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<nums.length; i++){
            nums[i] = nums[i-1] + Integer.parseInt(st.nextToken());
        }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            long sum = nums[end] - nums[start-1];
            // 이 방법으로는 시간복잡도에서 터짐 -> 합계산으로 해결
            /*for(int j=start-1; j<end; j++){
                sum += nums[j];
            }*/
            System.out.println(sum);
        }

    }

}