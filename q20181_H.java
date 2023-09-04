import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q20181_H {
    /*
        dp, binary search, prefix sum, two pointer
        K이상 먹으면 연속적으로 먹는것을 멈출건데 그이상의 에너지를 축적하고싶어.
        N이 1억이야. O(n)을 써야 문제가 풀릴텐데.
        dp로 푸는방법이 가장 합리적일것 같다.

        현재 에너지 저장하는 dp 와 boolean값
        O(n) dp를 쓰려면 현재에서 자신을 포함하지 말지를 결정할 수 있어야한다. 그 자리에서 최선을 구해야해.
        k=6
        1 2 3 4 5 6 7 8 9 10
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());


    }
}
