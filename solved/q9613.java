package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q9613 {
    /*
        GCD를 구하면 되는데 nC2 *N 이라서 그냥 쉽게  짜도 됨. 근데 최적화 해서 짜려면 유클리드호제법을 이용
        순열을 어떻게 만들까.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int n;
        int[] arr;
        long sum;
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            arr = new int[n];
            sum = 0;
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
                for (int k = 0; k < j; k++) {
                    sum += findGCD(arr[k], arr[j]);
                }
            }

            sb.append(sum + "\n");
        }
        System.out.println(sb);
    }

    private static int findGCD(int a, int b) {
        if (a < b) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        while (true) {
            if (a % b == 0) return b;
            int tmp = b;
            b = a % b;
            a = tmp;
        }
    }
}
