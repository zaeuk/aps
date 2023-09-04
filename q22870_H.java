import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class q22870_H {
    /*
        산책 문제. 까다롭다
        다익스트라 두번  사용
        사전순이 어렵네
     */
    static class Node implements Comparable<Node>{
        int no;
        long weight;

        public Node(int no, long weight) {
            this.no = no;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.weight,o.weight)==0?this.no-o.no:Long.compare(this.weight,o.weight);//사전순 할때 의미가 있을까
        }
    }
    static class Edge{
        int to;
        int weight;
        Edge next;

        public Edge(int to,int weight, Edge next) {
            this.to = to;
            this.weight=weight;
            this.next = next;
        }
    }
    static int N,M;
    static boolean[] visited;
    static Edge[] edges;
    static long ans;
    static PriorityQueue<Node> pq=new PriorityQueue<>();
    static long[] d;

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        visited=new boolean[N];
        edges=new Edge[N];

        int a,b,c;
        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            a=Integer.parseInt(st.nextToken());
            b=Integer.parseInt(st.nextToken());
            c=Integer.parseInt(st.nextToken());
            edges[a]=new Edge(b,c,edges[a]);
            edges[b]=new Edge(a,c,edges[b]);
        }

        st=new StringTokenizer(br.readLine());
        int S=Integer.parseInt(st.nextToken());
        int E=Integer.parseInt(st.nextToken());

        d=new long[N];
        d[S]=0;
        pq.offer(new Node(S,d[S]));
        dijkstra(S,E);

    }

    private static void dijkstra(int s, int e) {

    }
}
