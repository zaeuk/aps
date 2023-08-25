package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class q11909 {
    /*
        다익스트라, DP, 그래프 탐색
        갈곳보다 지금 자리가 숫자가 더 커야한다는 제약조건
        돌아갈 일이 없으니 visited는 배제하자.
        INF값 10만에서 1억으로 올리고 통과
     */
    static class Node implements Comparable<Node>{
        int x;
        int y;
        int weight;

        public Node(int x, int y, int weight) {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight-o.weight;
        }
    }
    static int N;
    static int[][] map;
    static int[][] d;
    static final int INF=100000000;
    static PriorityQueue<Node> pq=new PriorityQueue<>();
    static int[] dx={0,1};
    static int[] dy={1,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        map=new int[N][N];
        d=new int[N][N];
        StringTokenizer st;
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
                d[i][j]=INF;
            }
        }
        dijkstra();
        System.out.println(d[N-1][N-1]);
    }

    private static void dijkstra() {
        d[0][0]=0;
        pq.offer(new Node(0,0,0));
        Node now;
        int x,y,nx,ny,nw;
        while(!pq.isEmpty()){
            now=pq.poll();
            x=now.x;
            y=now.y;
            if(x==N-1&&y==N-1) return;
            for(int i=0;i<2;i++){
                nx=x+dx[i];
                ny=y+dy[i];
                nw=0;
                if(nx>=N||ny>=N) continue;
                if(map[ny][nx]>=map[y][x]) nw=map[ny][nx]-map[y][x]+1;
                if(d[ny][nx]>d[y][x]+nw){
                    d[ny][nx]=d[y][x]+nw;
                    pq.offer(new Node(nx,ny,d[ny][nx]));
                }
            }
        }
    }
}
