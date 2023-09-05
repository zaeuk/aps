package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q21317 {
    /*
        dp with detph...
        조건 잘못생각해서 8번틀렸다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[][] jump=new int[n][2];
        int[][] dp=new int[n][2];
        StringTokenizer st;
        for(int i=1;i<n;i++){
            st=new StringTokenizer(br.readLine());
            jump[i][0]=Integer.parseInt(st.nextToken());
            jump[i][1]=Integer.parseInt(st.nextToken());
        }
        int k=Integer.parseInt(br.readLine());

        for(int i=1;i<n;i++){
            dp[i][0]=10000000;
            dp[i][1]=10000000;
        }
        if(n>1)
        dp[1][0]=jump[1][0];

        for(int i=2;i<n;i++){
            dp[i][0]=Math.min(dp[i-1][0]+jump[i][0],dp[i-2][0]+jump[i-1][1]);
            if(i>=3)
                dp[i][1]=Math.min(dp[i-3][0]+k,Math.min(dp[i-1][1]+jump[i][0],dp[i-2][1]+jump[i-1][1]));
        }

        System.out.println(Math.min(dp[n-1][0],dp[n-1][1]));

    }
}
