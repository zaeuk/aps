import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1717 {
    static int[] parent;
    static int n,m;

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        parent=new int[n+1];
        for(int i=1;i<=n;i++){
            parent[i]=i;
        }
        int order,a,b;
        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            order =Integer.parseInt(st.nextToken());
            a =Integer.parseInt(st.nextToken());
            b =Integer.parseInt(st.nextToken());
            switch (order){
                case 0:
                    union(a,b);
                    break;
                case 1:
                    if(find(a)==find(b)) sb.append("YES\n");
                    else sb.append("NO\n");
                    break;
                default:
                    break;
            }
        }
        System.out.println(sb);
    }
    private static int find(int a){
        if(parent[a]==a) return a;

        return parent[a]=find(parent[a]);
    }

    private static void union(int a,int b){
        int ap=find(a);
        int bp=find(b);
        parent[bp]=ap;
    }
}
