package solved;

import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.Arrays;
    import java.util.PriorityQueue;
    import java.util.StringTokenizer;

    public class q14621 {
        /*
            MST + @ (제약조건 같은타입끼리 잇는 간선 제외)
            edge받고나서 같은 성별조건 엣지 제외하고 크루스칼 or 프림 돌리자.
            이번엔 프림돌려보자.
         */
        static class Node implements Comparable<Node>{
            int no;
            int weight;

            public Node(int no, int weight) {
                this.no = no;
                this.weight = weight;
            }

            @Override
            public int compareTo(Node o) {
                return this.weight-o.weight;
            }
        }
        public static void main(String[] args) throws IOException {
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st =new StringTokenizer(br.readLine());
            int N=Integer.parseInt(st.nextToken());
            int M=Integer.parseInt(st.nextToken());

            boolean[] univ= new boolean[N];
            int[][] edge=new int[N][N];

            st=new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++){
                if(st.nextToken().equals("M")) univ[i]=true;
            }
            int u,v,d;
            for(int i=0;i<M;i++){
                st=new StringTokenizer(br.readLine());
                u=Integer.parseInt(st.nextToken())-1;
                v=Integer.parseInt(st.nextToken())-1;
                d=Integer.parseInt(st.nextToken());
                if(univ[u]==univ[v]) continue;
                if(edge[u][v]!=0){
                    edge[u][v]=Math.min(edge[u][v],d);
                    edge[v][u]=Math.min(edge[u][v],d);
                }else{
                    edge[v][u]=d;
                    edge[u][v]=d;
                }
            }
            PriorityQueue<Node> pq=new PriorityQueue<>();
            int[] minEdge=new int[N];
            Arrays.fill(minEdge,Integer.MAX_VALUE);
            boolean[] visited=new boolean[N];
            int cnt=0;
            minEdge[0]=0;
            pq.offer(new Node(0,0));
            int now;
            int ans=-1;
            int sum=0;
            while(!pq.isEmpty()){
                now=pq.poll().no;
                if(visited[now]) continue;
                visited[now]=true;
                sum+=minEdge[now];
                if(++cnt==N) {
                    ans=sum;
                    break;
                }
                for(int i=0;i<N;i++){
                    if(edge[now][i]==0) continue;
                    if(minEdge[i]>edge[now][i]){
                        minEdge[i]=edge[now][i];
                        pq.offer(new Node(i,minEdge[i]));
                    }
                }
            }
            System.out.println(ans);

        }
    }
