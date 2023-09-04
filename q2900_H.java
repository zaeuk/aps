import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q2900_H {
    /*
        구간합을 어떻게 쉽게 구할 것인지.
        N,K,Q가 100만까지라 하나씩 더하는건 안되고.
        이거 테트리스랑 비슷한거 같기도
        소수? 에라토스테네스의체로 소수 구해서. 하는건 어떄
        a[9]-a[0] = sum 이되게끔하면되는데 모든 합을 구해야한다. 그럴려면 100만 *100만이 되면안돼 누적합만 구하려는데도.
     */
    static int N,K,Q;
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
    }
}
