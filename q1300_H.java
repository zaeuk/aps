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
        B[k]=x 일때 k를 구하는건 쉽기때문에
        x로 k에 들어올 값을 구하는게 쉽기 때문에 역으로 x를 이분탐색으로 찾는다.
        여기서 중요한것은. left right가 있을때 left right를 조정하는 방법인데...
        B[low~high]=x 이다.
        여기서 high를 찾는건 매우쉽다.
        cnt+=Math.min(x/i,n); 를 n까지 다 돌려주면 구할 수 있기떄문에. 쉽다.
     */
    static int n,k;
    static int ans;
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        n=sc.nextInt();
        k=sc.nextInt();

        long left=1;
        long right=k;
        long ans=0;

        while(left<right){
            long mid=(left+right)/2;
            long cnt=0;
            for(int i=1;i<=n;i++){
                cnt+=Math.min(mid/i,n);
            }
            if(cnt<k){
                left=mid+1;
            }else{
                right=mid;
            }
        }
        System.out.println(left);
    }
}
