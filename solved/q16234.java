package solved;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class q16234 {
    /*
        인구 이동
        bfs 탐색 + @
        아 유니온 파인드로 하면 더 쉽게 할 수 있겠구나.
        코드 최적화 필요.
     */
    static int N,L,R;
    static int[][] arr;
    static int[][] tmp;
    static boolean[][] visited;
    static int[] dx={0,0,-1,1};
    static int[] dy={-1,1,0,0};
    static int ans=0;
    static boolean flag=true;
    static Queue<Integer> q=new ArrayDeque<>();
    static Set<Point> set=new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N= Integer.parseInt(st.nextToken());
        L= Integer.parseInt(st.nextToken());
        R= Integer.parseInt(st.nextToken());

        arr=new int[N][N];
        tmp=new int[N][N];

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        while(flag){
            flag=false;
            find();
            if(flag) {
                move();
                ans++;
            }
        }

        System.out.println(ans);
    }

    private static void move() {
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                arr[i][j]=tmp[i][j];
            }
        }
    }

    private static void find() {
        visited=new boolean[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!visited[i][j]) {
                    bfs(i, j);
                }
            }
        }
    }

    private static void bfs(int r, int c) {
        set.clear();
        set.add(new Point(r,c));
        q.offer(r);
        q.offer(c);
        visited[r][c]=true;
        int sum=arr[r][c];
        int cnt=1;
        int x,y,nx,ny,diff;
        while(!q.isEmpty()){
            y=q.poll();
            x=q.poll();
            for(int i=0;i<4;i++){
                ny=y+dy[i];
                nx=x+dx[i];
                if(nx<0||ny<0||nx>=N||ny>=N) continue;
                if(visited[ny][nx]) continue;
                diff=Math.abs(arr[y][x]-arr[ny][nx]);
                if(L<=diff&&diff<=R) {
                    q.offer(ny);
                    q.offer(nx);
                    set.add(new Point(ny,nx));
                    visited[ny][nx]=true;
                    flag= true;
                    sum+=arr[ny][nx];
                    cnt++;
                }
            }
        }
        for(Point p : set){
            tmp[p.y][p.x]=sum/cnt;
        }
    }
}
