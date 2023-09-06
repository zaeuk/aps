//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayDeque;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Queue;
//
//public class q16724 {
//    /*
//        bfs 구역나누기 문제
//     */
//    static int[] dx={0,0,-1,1};
//    static int[] dy={-1,1,0,0};
//
//    static Map<Character,Integer> del=new HashMap<>();
//    static {
//        del.put('U',0);
//        del.put('D',1);
//        del.put('L',2);
//        del.put('R',3);
//    }
//    static int n,m;
//    static int[][] map;
//    static boolean[][] v;
//    static Queue<Integer> q=new ArrayDeque<>();
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String str=br.readLine();
//        String[] arr=str.split(" ");
//
//        n=Integer.parseInt(arr[0]);
//        m=Integer.parseInt(arr[1]);
//
//        map=new int[n][m];
//        for(int i=0;i<n;i++){
//            str=br.readLine();
//            for(int j=0;j<m;j++){
//                map[i][j]=del.get(str.charAt(j));
//            }
//        }
//        v=new boolean[n][m];
//        int cnt=0;
//        for(int i=0;i<n;i++){
//            for(int j=0;j<m;j++){
//                if(!v[i][j]){
//                    bfs(i,j);
//                    cnt++;
//                }
//            }
//        }
//        System.out.println(cnt);
//    }
//
//    private static void bfs(int r, int c) {
//        q.offer(r);
//        q.offer(c);
//        v[r][c]=true;
//        int y,x,ny,nx,d;
//        while(!q.isEmpty()){
//            y=q.poll();
//            x=q.poll();
//            d=map[y][x];
//            ny=y+dy[d];
//            nx=x+dx[d];
//            if(!v[ny][nx]){
//                q.offer(ny);
//                q.offer(nx);
//                v[ny][nx]=true;
//            }
//            for(int i=0;i<4;i++){
//                ny=y+dy[i];
//                nx=x+dx[i];
//                if(ny<0||nx<0||ny>=n||nx>=m) continue;
//                if(v[ny][nx]) continue;
//                if(y==ny+dy[map[ny][nx]]&&x==nx+dx[map[ny][nx]]){
//                    q.offer(ny);
//                    q.offer(nx);
//                    v[ny][nx]=true;
//                }
//            }
//        }
//    }
//}

/*
    더 간단한 풀이
 */


import java.util.Scanner;

public class q16724{
    public static void main(String[] args) {
        int n,m,r,c,ans=0;
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        char[][] map=new char[n][m];
        int[][] v=new int[n][m];
        for(int i=0;i<n;i++) map[i]=sc.next().toCharArray();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                r=i;c=j;
                while(v[r][c]==0){
                    v[r][c]=i*m+j+1;
                    if(map[r][c]=='U') r--;
                    else if(map[r][c]=='D') r++;
                    else if(map[r][c]=='L') c--;
                    else c++;
                }
                if(v[r][c]==i*m+j+1) ans++;
            }
        }
        System.out.println(ans);

    }
}