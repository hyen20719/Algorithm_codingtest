
import java.util.Scanner;

public class Main {
    static int result = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] srr = str.split("-");

        for (int i = 0; i < srr.length; i++) {
            int n = calSum(srr[i]);
            if (i == 0) {
                result = result + n;
            }else{
                result = result - n;
            }
        }
        System.out.println(result);
    }

    public static int calSum(String str) {
        int res = 0;
        String[] srr = str.split("[+]");
        for (String s : srr) {
            res += Integer.parseInt(s);
        }
        return res;
    }
}
