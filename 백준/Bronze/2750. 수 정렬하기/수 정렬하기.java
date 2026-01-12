import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] nums = new long[N];
        for(int i=0; i<N; i++){
            StringTokenizer token = new StringTokenizer(br.readLine());
            nums[i] = Long.parseLong(token.nextToken());
        }

        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++){
            System.out.println(nums[i]);
        }

    }
}
