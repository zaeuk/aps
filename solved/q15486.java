package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q15486 {
    /*
        dp problem
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String str=br.readLine();
        int n=Integer.parseInt(str);
        int[] cost=new int[n+1];
        int t,p;
        String[] arr;
        for(int i=1;i<=n;i++){
            str=br.readLine();
            arr=str.split(" ");
            t=Integer.parseInt(arr[0]);
            p=Integer.parseInt(arr[1]);
            cost[i]=Math.max(cost[i],cost[i-1]);
            if(i-1+t<=n){
                cost[i-1+t]=Math.max(cost[i-1+t],cost[i-1]+p);
            }
        }
        System.out.println(cost[n]);
    }
}
