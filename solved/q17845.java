package solved;

import java.io.*;

public class q17845 {
    /*
        knapsack problem
        not using StringTokenizer;
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String str=br.readLine();
        String[] arr=str.split(" ");

        int k= Integer.parseInt(arr[0]);
        int n=Integer.parseInt(arr[1]);
        int[] p=new int[k+1];
        int a,t;
        while(n-->0){
            str=br.readLine();
            arr=str.split(" ");
            a=Integer.parseInt(arr[0]);
            t=Integer.parseInt(arr[1]);
            for(int i=k;i>=t;i--){
                p[i]=Math.max(p[i],p[i-t]+a);
            }
        }
        System.out.println(p[k]);

    }
}
