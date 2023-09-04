import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q17144 {
    /*
        미세먼지 안녕!
        풀어본 문제인데
        시뮬레이션 구현 문제
     */
    static int[] dx={0,0,-1,1};
    static int[] dy={-1,1,0,0};
    static int[][] room;
    static int[][] tmp;
    static int r,c,t;
    static int top,bottom;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r=Integer.parseInt(st.nextToken());
        c=Integer.parseInt(st.nextToken());
        t=Integer.parseInt(st.nextToken());

        room=new int[r][c];
        tmp=new int[r][c];

        for(int i=0;i<r;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<c;j++){
                room[i][j]=Integer.parseInt(st.nextToken());
            }
            //공기청정기 위치 찾아두기
            if(room[i][0]==-1&&bottom==0){
                top=i;
                bottom=i+1;
            }
        }
        room[top][0]=0;
        room[bottom][0]=0;

        for(int i=0;i<t;i++){
            spread();
            purify();
        }

        long sum=0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                sum+=room[i][j];
            }
        }
        System.out.println(sum);
    }

    private static void printRoom() {
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                System.out.print(room[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("---------------------------");
    }

    private static void purify() {
        //세로
        for(int i=top-1;i>0;i--){
            room[i][0]=room[i-1][0];
        }
        for(int i=bottom+1;i<r-1;i++){
            room[i][0]=room[i+1][0];
        }
        //가로
        for(int i=0;i<c-1;i++){
            room[0][i]=room[0][i+1];
            room[r-1][i]=room[r-1][i+1];
        }
        //세로
        for(int i=0;i<top;i++){
            room[i][c-1]=room[i+1][c-1];
        }
        for(int i=r-1;i>bottom;i--){
            room[i][c-1]=room[i-1][c-1];
        }
        //가로
        for(int i=c-1;i>0;i--){
            room[top][i]=room[top][i-1];
            room[bottom][i]=room[bottom][i-1];
        }

    }

    private static void spread() {
        int nx,ny,cnt,amount;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                cnt=0;
                amount=room[i][j]/5;
                for(int k=0;k<4;k++){
                    ny=i+dy[k];
                    nx=j+dx[k];
                    if(ny<0||nx<0||ny>=r||nx>=c) continue;
                    if(nx==0&&(ny==top||ny==bottom)) continue; //청정기도 제외
                    cnt++;
                    tmp[ny][nx]+=amount;
                }
                room[i][j]-=cnt*amount;
            }
        }

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                room[i][j]+=tmp[i][j];
                tmp[i][j]=0;
            }
        }
    }
}
