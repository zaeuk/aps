package solved;
//import java.util.Comparator;
//import java.util.PriorityQueue;
//import java.util.Scanner;
//
//public class q14226 {
//    /*
//        1. 전체복사
//        2. 전체붙이기
//        3. -1
//        *2하려면 2초 -1에는 1초 라고 분기가 두개라고 단순히 생각할 수가 없구나.
//        분기점이 정확히 3가지야.
//        1번다음에 1이 오지않는 구조.
//        11은 될수 없다.
//        dp로? how to...
//        각 수마다 정해진 최적의 값이 있을테니 이미 기록되었다면 폐기 근데 클립보드에 값따라 다르잖아... 쉣
//        now tmp step 세가지 숫자를 사용해서 bfs 나아가기. now tmp 해당하는 dp를 만들고 step 기록하기. 2차원 dp기록
//        queue에 계속 넣을건데 step을 기준으로 priority 적용해서 이미 dp에 기록된거라면 그 분기는 폐기
//        그렇게 분기 계속 나누기
//     */
//    static class Q implements Comparable<Q> {
//        int now;
//        int tmp;
//        int step;
//
//        public Q(int now, int tmp, int step) {
//            this.now = now;
//            this.tmp = tmp;
//            this.step = step;
//        }
//
//
//        @Override
//        public int compareTo(Q o) {
//            return this.step - o.step;
//        }
//    }
//
//    static int S;
//    static int[][] dp;
//    static int ans;
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        S = sc.nextInt();
//        dp = new int[S+1][S+1];
//
//        bfs();
//
//        System.out.println(ans);
//    }
//
//    private static void bfs() {
//        PriorityQueue<Q> pq = new PriorityQueue<>();
//
//        pq.offer(new Q(1, 0, 0));
//
//        Q q;
//        int now, tmp, step;
//        while (!pq.isEmpty()) {
//            q = pq.poll();
//            now = q.now;
//            tmp = q.tmp;
//            step = q.step;
//
//            if (now == S) {
//                ans = step;
//                return;
//            }
//
//            //1번
//            if (dp[now][now] == 0 && now != tmp) {
//                pq.offer(new Q(now, now, step + 1));
//                dp[now][now] = step + 1;
//            }
//            //2번
//            if (now+tmp<=S&&dp[now + tmp][tmp] == 0 && tmp > 0){
//                pq.offer(new Q(now + tmp, tmp, step + 1));
//                dp[now + tmp][tmp] = step + 1;
//            }
//
//            //3번
//            if (dp[now - 1][tmp] == 0 && now > 2) {
//                pq.offer(new Q(now - 1, tmp, step + 1));
//                dp[now - 1][tmp] = step + 1;
//            }
//        }
//
//    }
//}

//간단하게 푸는 방법이  있다.
/*
    1차원 dp만 쓰고 bfs없이. 쭉 가는 방법.
 */


import java.util.Scanner;

public class q14226{
    public static void main(String[] args) {
        Scanner  sc=new Scanner(System.in);
        int s=sc.nextInt();
        int[] dp=new int[1002];

        //1인상태에서 복붙만 하면 되니까. 기본적으로
        for(int i=1;i<=1001;i++){
            dp[i]=i;
        }
        for(int i=2;i<=1000;i++){
            //복붙
            for(int j=2;i*j<=1000;j++){
                dp[i*j]=Math.min(dp[i*j],dp[i]+j);
            }
            //-1
            for(int j=1000;j>=2;j--){
                dp[j]=Math.min(dp[j],dp[j+1]+1);
            }
        }

        System.out.println(dp[s]);
    }
}