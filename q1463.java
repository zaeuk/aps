//import java.util.PriorityQueue;
//import java.util.Scanner;
//
//public class q1463 {
//    /*
//        1로 만들기
//
//        dfs problem XX
//        dp problem O
//
//     */
//    private static class Node implements Comparable<Node>{
//        int num,depth;
//
//        public Node(int num, int depth) {
//            this.num = num;
//            this.depth = depth;
//        }
//
//        @Override
//        public int compareTo(Node o) {
//            return this.depth-o.depth;
//        }
//    }
//    private static PriorityQueue<Node> pq=new PriorityQueue<>();
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n=sc.nextInt();
//        pq.offer(new Node(n,0));
//        Node node;
//        int num,depth,ans=-1;
//        while(!pq.isEmpty()){
//            node=pq.poll();
//            num=node.num;
//            depth=node.depth;
//            if(num==1) {
//                ans=depth;
//                break;
//            }
//            if(num%3==0) pq.offer(new Node(num/3,depth+1));
//            if(num%2==0) pq.offer(new Node(num/2,depth+1));
//            pq.offer(new Node(num-1,depth+1));
//        }
//        System.out.println(ans);
//    }
//}

import java.util.Arrays;
import java.util.Scanner;

/*
    using dp much faster
    역으로 연산
 */
public class q1463{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int[] dp=new int[N+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[1]=0;
        for(int i=2;i<=N;i++){
            if(i%3==0) dp[i]=Math.min(dp[i],dp[i/3]+1);
            if(i%2==0) dp[i]=Math.min(dp[i],dp[i/2]+1);
            dp[i]=Math.min(dp[i],dp[i-1]+1);
        }
        System.out.println(dp[N]);
    }
}