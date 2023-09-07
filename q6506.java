import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q6506 {
    /*
        엘 도라도
        dp problem

        dfs >> 시간초과 최악일경우 100 C 50
        n,k가 100이하라 2차원 dp로 3중 반복문으로 해결
     */
    static int N,K;
    static int[] arr;
    static long[][] dp;
    static long ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb=new StringBuilder();
        while(true){
            st=new StringTokenizer(br.readLine());
            N=Integer.parseInt(st.nextToken());
            K=Integer.parseInt(st.nextToken());

            if(N==0&&K==0) break;

            arr=new int[N];
            st=new StringTokenizer(br.readLine());
            dp=new long[K][N]; //올 수 있는 가지수 방법 담기 [depth][idx]
            for(int i=0;i<N;i++){
                arr[i]=Integer.parseInt(st.nextToken());
                dp[0][i]=1;//가장 앞에 어떤 수든 올 수 있다
            }
            ans=0;
            for(int i=1;i<K;i++){
                for(int j=0;j<N;j++){
                    for(int k=j+1;k<N;k++){
                        if(arr[j]<arr[k]){
                            dp[i][k]+=dp[i-1][j];
                        }
                    }
                }
            }
            for(int i=0;i<N;i++){
                ans+=dp[K-1][i];
            }

//            printDP();

            sb.append(ans+"\n");
        }
        System.out.println(sb);
    }

    private static void printDP() {
        for(int i=0;i<K;i++){
            for(int j=0;j<N;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }

}
