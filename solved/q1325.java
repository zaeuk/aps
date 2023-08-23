package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class q1325 {
    static int N,M;
    static List<Integer>[] list;
    static Queue<Integer> q=new ArrayDeque<>();
    static boolean[] visited;
    static int[] trusted;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        list = new List[N];
        trusted=new int[N];
        for(int i=0;i<N;i++) list[i]=new ArrayList<>();

        int a,b;
        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            a= Integer.parseInt(st.nextToken())-1;
            b= Integer.parseInt(st.nextToken())-1;
            list[a].add(b);
        }

        for(int i=0;i<N;i++){
            bfs(i);
        }

        int max=0;
        for(int i=0;i<N;i++){
            max=Math.max(max,trusted[i]);
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<N;i++){
            if(max==trusted[i]) sb.append(i+1+" ");
        }
        System.out.println(sb);
    }
    private static void bfs(int n) {
        q.clear();
        visited=new boolean[N];
        q.offer(n);
        visited[n]=true;
        int now,tmp;
        while(!q.isEmpty()){
            now=q.poll();
            for(short j=0;j<list[now].size();j++){
                tmp=list[now].get(j);
                if(!visited[tmp]){
                    trusted[tmp]++;
                    q.offer(tmp);
                    visited[tmp]=true;
                }
            }
        }
    }
}
