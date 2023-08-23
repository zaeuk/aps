package solved;

import java.util.*;

public class q22943 {
    /*
        꽤 까다롭다 K가 5까지면 최대 99,999까지는 체크해야되고... 우선 서로다른 소수의 합이 가능한 것들을 구해야되고...
        10만까지 서로다른 소수의합이 가능한 수들을 먼저 체크하고 그 수들중에서 M^(n)*a*b 인 경우를 찾아야된다는 거네
        흠 일단 10만까지 에라토스테네스의 체를 해보는게 좋겠다.
        에라토스테네스의 체는 이제 ...기억해도 될때가 된 것 같은데

        약수 알고리즘 , 소수 알고리즘
        약수 알고리즘은 O(root(n)) 으로 구할 수 있다. 이미 나눠진 값은 약수로 처야하니까...
        근데 우리는 약수를 구하는게 아니잖아.
        소인수 분해 알고리즘이 필요하다.
        이미구해둔 소수를 이용하면 되지않을까?
        2번을 먼저 거르고 1번을 찾자.?
        1번은 골드바흐의 추측으로 4보다 큰 모든 짝수는 두 소수의 합을 만족함을 알 수 있다.
        + 홀수의 경우는 2를 뺀 후 소수인지 판별하면되는 일이다.
        그러면 2번의 경우를 미리 구해둔 소수를 통해 소인수분해 해봐서 적용하면 될 것.



     */
    static boolean prime[] = new boolean[100000];
    static Set<Integer> primes = new TreeSet<>();
    static ArrayList<Integer> second = new ArrayList<>();
    static int[] scope = {0, 9, 99, 999, 9999, 99999};
    static int K;
    static int M;
    static int ans=0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        K = sc.nextInt();
        M = sc.nextInt();

        findPrime(); // K자리의 숫자만큼 소수 구해두기
        int n;
        for (int i = scope[K - 1] + 1; i <= scope[K]; i++) {
            if(check(i)) continue;
            n=i;
            while(n%M==0){
                n/=M;
            }
            for(Integer j:primes){
                if(n%j==0){
                    if(primes.contains(n/j)){
                        if(i>4&&primes.contains(i-2)){
                            ans++;
                        }else if(i%2==0){
                            for(Integer k:primes){
                                if(i<=2*k) break;
                                if(primes.contains(i-k)){
                                    ans++;
                                    break;
                                }
                            }
                        }
                    }
                    break;
                }
            }
        }
        System.out.println(ans);
    }

    private static boolean check(int n) {
        short[] set= new short[10];
        for(int i=0;i<K;i++){
            if(set[n%10]==0) {
                set[n%10]++;
            }
            else return true;
            n/=10;
        }
        return false;
    }

    private static void findPrime() {
        int N = scope[K];

        // 소수는 false
        // 1은 소수가 아니므로 제외
        prime[0] = prime[1] = true;
        for (int i = 2; i * i <= N; i++) {
            // prime[i]가 소수라면
            if (!prime[i]) {
                // prime[j] 소수가 아닌 표시
                for (int j = i * i; j <= N; j += i)
                    prime[j] = true;
            }
        }
        // 소수 넣기
        for (int i = 1; i <= N; i++) {
            if (!prime[i]) primes.add(i);
        }

    }
}
