package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class q14621_2 {
    /*
        MST + @ (제약조건 같은타입끼리 잇는 간선 제외)
        edge받고나서 같은 성별조건 엣지 제외하고 크루스칼 or 프림 돌리자.
        크루스칼로 풀어보자
     */
    static class Edge implements Comparable<Edge>{
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight-o.weight;
        }
    }
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());

        boolean[] univ= new boolean[N];

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            if(st.nextToken().equals("M")) univ[i]=true;
        }
        int u,v,d;
        PriorityQueue<Edge> pq=new PriorityQueue<>();
        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            u=Integer.parseInt(st.nextToken())-1;
            v=Integer.parseInt(st.nextToken())-1;
            d=Integer.parseInt(st.nextToken());
            if(univ[u]==univ[v]) continue;
            pq.offer(new Edge(u,v,d));
        }
        //step1. init parent
        parent=new int[N];
        for(int i=0;i<N;i++){
            parent[i]=i;
        }

        int ans=-1;
        int cnt=0;
        int sum=0;
        Edge e;

        while(!pq.isEmpty()){
            e=pq.poll();
            if(union(e.from,e.to)){
                sum+=e.weight;
                if(++cnt==N-1){
                  ans=sum;
                }
            }
        }
        System.out.println(ans);

    }
    private static int find(int a){
        if(parent[a]==a) return a;
        return parent[a]=find(parent[a]);
    }
    private static boolean union(int a, int b) {
        int ap=find(a);
        int bp=find(b);
        if(ap==bp) return false;
        parent[bp]=ap;
        return true;
    }
}
