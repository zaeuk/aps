import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class q16174 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int[][] map= new int[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                map[i][j]=sc.nextInt();
            }
        }
        boolean[][] visited= new boolean[N][N];
        Queue<Integer> q=new ArrayDeque();
        q.offer(0);
        q.offer(0);
        visited[0][0]=true;
        int nx,ny;
        boolean flag=false;
        while(!q.isEmpty()){
            nx=q.poll();
            ny=q.poll();
            if(nx==N-1&&ny==N-1){
                flag=true;
                break;
            }
            if(map[nx][ny]==0) continue;
            if(nx+map[nx][ny]<N&&!visited[nx+map[nx][ny]][ny]){
                q.offer(nx+map[nx][ny]);
                q.offer(ny);
                visited[nx+map[nx][ny]][ny]=true;
            }
            if(ny+map[nx][ny]<N&&!visited[nx][ny+map[nx][ny]]){
                q.offer(nx);
                q.offer(ny+map[nx][ny]);
                visited[nx][ny+map[nx][ny]]=true;
            }
        }
        if(flag) System.out.println("HaruHaru");
        else System.out.println("Hing");
    }
}
