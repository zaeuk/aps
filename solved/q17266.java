package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q17266 {
    /*
        가로등 문제 0~ N까지 길이중 가로등 위치간 거리가 가장 (큰거에서+1)/2
        + 첫번째랑 끝은 나누지말고 계산해야함.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int max=0;
        int N=Integer.parseInt(br.readLine());
        int M=Integer.parseInt(br.readLine());
        StringTokenizer st =new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int before=start;
        int after ;
        for(int i=1;i<M;i++){
            after=Integer.parseInt(st.nextToken());
            max=Math.max(max,after-before);
            before=after;
        }
        int end=N-before;
        int ans=Math.max(Math.max(start,end),(max+1)/2);
        System.out.println(ans);
    }
}
