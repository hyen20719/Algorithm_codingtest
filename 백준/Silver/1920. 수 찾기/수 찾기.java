import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for(int i=0; i<N; i++){
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);

        int M = sc.nextInt();
        for (int i = 0; i < M; i++) {
            boolean find = false;
            int target = sc.nextInt();

            int st = 0;
            int end = nums.length -1;
            while(st<= end){
                int midIdx = (st+end)/2;
                int mid = nums[midIdx];

                if (target > mid) {
                    st = midIdx+1;
                } else if (target < mid) {
                    end = midIdx-1;
                }else{
                    find = true;
                    break;
                }
            }

            if(find){
                System.out.println(1);
            }else{
                System.out.println(0);
            }
        }
    }
}
