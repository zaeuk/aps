import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;


public class q17471 {
    /*
        게리맨더링
        bfs로 인접지역 찾아서 나누는 알고리즘.
        N이 10이하라서 모든 경우의수를 확인
        - 최대 2^n의 경우의수를 만들고
        - 각각의 경우 연결이 되는지를 확인
        - 연결이 된다면 min값 갱신
     */
    static int sum=0;
    static int min=Integer.MAX_VALUE;
    static int N;
    static boolean[] comb;
    static int[] population;
    static boolean[][] edge;
    static boolean flag=true;
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine());
        population=new int[N];
        edge=new boolean[N][N];
        for(int i=0;i<N;i++){
            population[i]=Integer.parseInt(st.nextToken());
            sum+=population[i];
        }
        int cnt,tmp;
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            cnt=Integer.parseInt(st.nextToken());
            for(int j=0;j<cnt;j++){
                tmp=Integer.parseInt(st.nextToken())-1;
                edge[i][tmp]=true;
//                edge[tmp][i]=true;
            }
        }

        int tCnt;
        for(int i=1;i<(1<<N)-1;i++){
            comb=new boolean[N];
            tCnt=0;
            for(int j=0;j<N;j++){
                if((i & (1<<j))!=0){
                    comb[j]=true;
                    tCnt++;
                }
            }
            flag=false;
            bfs(true,tCnt);
            if(flag)
                bfs(false,N-tCnt);
            int tSum=0;
            if(flag){
//                System.out.println(tCnt);
                for(int j=0;j<N;j++)
                    if(comb[j]) tSum+=population[j];
                min=Math.min(min,Math.abs(sum-2*tSum));
            }
        }
        if(min!=Integer.MAX_VALUE) System.out.println(min);
        else System.out.println(-1);
    }

    private static void bfs(boolean b,int V) {
        Queue<Integer> q=new ArrayDeque<>();
        boolean[] visited=new boolean[N];
        int cnt=0;
        for(int i=0;i<N;i++){
            if((b&&comb[i])||(!b&&!comb[i])){
                q.offer(i);
                visited[i]=true;
                break;
            }
        }
        int now;
        while(!q.isEmpty()){
            now=q.poll();

            if(++cnt==V){
                flag=true;
                return;
            }

            for(int i=0;i<N;i++){
                if(visited[i]||!edge[now][i]) continue;
                if((b&&comb[i])||(!b&&!comb[i])){
                    q.offer(i);
                    visited[i]=true;
                }
            }
        }

        flag=false;

    }
}
