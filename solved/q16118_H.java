package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class q16118_H {
    /*
        모든 점들에 대한 shortest path를 구해야하는데 늑대 케이스가 특이한 경우.
        그래서 일반적인 다익스트라 사용이 안된다. 어렵다
        어려워
     */
    static class Node{
        int no;
        int weight;
        Node next;

        public Node(int no, int weight, Node next) {
            this.no = no;
            this.weight = weight;
            this.next = next;
        }
    }
    static class Vertex implements Comparable<Vertex> {
        int no, weight;
        boolean isOdd;

        public Vertex(int no, int weight, boolean isOdd) {
            this.no = no;
            this.weight = weight;
            this.isOdd = isOdd;
        }

        @Override
        public int compareTo(Vertex o) {
            return this.weight - o.weight;
        }
    }

    static int N, M;
    static Node[] edge;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        edge= new Node[N];
        int a, b, c;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken()) - 1;
            b = Integer.parseInt(st.nextToken()) - 1;
            c = Integer.parseInt(st.nextToken()) * 2;
            edge[a]=new Node(b,c,edge[a]);
            edge[b]=new Node(a,c,edge[b]);
        }
        int[] d = new int[N];
        Arrays.fill(d, 1234567890);
        PriorityQueue<Vertex> pq = new PriorityQueue<>();

        pq.offer(new Vertex(0, 0, false));
        d[0] = 0;
        int cnt = 0;
        boolean[] visited = new boolean[N];
        int now;
        while (!pq.isEmpty()) {
            now = pq.poll().no;
            if (visited[now]) continue;
            visited[now] = true;

            if (++cnt == N) break;
            int i;
            for (Node cur=edge[now];cur!=null;cur=cur.next) {
                i=cur.no;
                if (!visited[i] && d[i] > d[now] + cur.weight) {
                    d[i] = d[now] + cur.weight;
                    pq.offer(new Vertex(i, d[i], false));
                }
            }

        }

        int[] d1 = new int[N];
        int[] d2 = new int[N];
        Arrays.fill(d1, 1234567890);
        Arrays.fill(d2, 1234567890);
        pq=new PriorityQueue<>();
        d2[0] = 0;
        pq.offer(new Vertex(0, 0, false));
        boolean[] visited1 = new boolean[N];
        boolean[] visited2 = new boolean[N];
        boolean isOdd;
        while (!pq.isEmpty()) {
            now = pq.peek().no;
            isOdd = pq.poll().isOdd;
            if (isOdd && visited1[now]) continue;
            else if (!isOdd && visited2[now]) continue;
            if (isOdd && !visited1[now]) visited1[now] = true;
            else if (!isOdd && !visited2[now]) visited2[now] = true;
            int i;
            for (Node cur=edge[now];cur!=null;cur=cur.next) {
                i=cur.no;
                if (!visited1[i] && !isOdd && d1[i] > d2[now] + cur.weight / 2) {
                    d1[i] = d2[now] + cur.weight / 2;
                    pq.offer(new Vertex(i, d1[i], true));
                } else if (!visited2[i] && isOdd && d2[i] > d1[now] + cur.weight * 2) {
                    d2[i] = d1[now] + cur.weight * 2;
                    pq.offer(new Vertex(i, d2[i], false));
                }
            }
        }

        cnt = 0;
        for (int i = 1; i < N; i++) {
            d2[i] = Math.min(d1[i], d2[i]);
        }

        for (int i = 1; i < N; i++) {
            if (d[i] < d2[i]) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

}
