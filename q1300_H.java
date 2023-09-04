import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class q1300_H {
    /*
        K번째 수
        k 범위는 Integer
        1
        1 2 2 4
        1 2 2 3 3 4 6 6 9
        1 2 2 3 3 4 4 4 5 6 6 8 8 9 12 12 16
        약수 문제인가. k까지 linear하게 갈건데 n보다 큰 소수는 제끼고 그보다 작은 경우는 n보다 작은 약수가 존재하는지 체크하면서 간다.

        이분탐색 문제라는데 어떻게 접근하는건지 모르겠다.
     */
    static int n,k;
    static Set<Integer> set=new HashSet<>();
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        n=sc.nextInt();
        k=sc.nextInt();
        int cnt=0;
        int ans=0;

        prime();


        for(int i=1;i<1000000000;i++){
            if(i>n&&set.contains(i)) continue;
            if(i>n*n) break;
            for(int j=1;j*j<=i;j++){
                if(j>n) break;
                if(i/j>n) continue;
                if(j*j==i) cnt++;
                else if(i%j==0) cnt+=2;
            }
            if(cnt>=k){
                ans=i;
                break;
            }
        }
        System.out.println(ans);


    }

    private static void prime() {
        boolean[] v=new boolean[100000];
        v[0]=true;
        v[1]=true;

        for(int i=2;i*i<=100000;i++){
            if(!v[i]){
                set.add(i);
                for(int j=i*i;j<100000;j+=i){
                    v[j]=true;
                }
            }
        }

    }
}
