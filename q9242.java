import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q9242 {
    /*
        폭탄해체
        문자열탐색 -> 어렵다.
        wow...  다른풀이를 보다보니 아예 숫자하나를 0을 예시로 들면
        "**** ** ** ** ****" 이렇게 하나로 보고 substring 해서 주어진것도 하나의 문자열로 만들어버린다음 equals 비교
        진짜 괜찮다.
     */
    static String[] bomb=new String[5];
    static int sum=0;
    static boolean flag=true;
    static boolean isOdd=true;
    static int len;
    static String[] num={"***   * *** *** * * *** *** *** *** ***"
                        ,"* *   *   *   * * * *   *     * * * * *"
                        ,"* *   * *** *** *** *** ***   * *** ***"
                        ,"* *   * *     *   *   * * *   * * *   *"
                        ,"***   * *** ***   * *** ***   * *** ***"};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0;i<5;i++){
            bomb[i]=br.readLine();
        }

        len=bomb[0].length()/4 +1;
        if(bomb[0].length()!=len*4-1) {
            System.out.println("BOOM!!");
            System.exit(0);
        }

        for(int i=0;i<len;i++){
            check(i);
            if(!flag) break;
        }
        if(flag){
            if(sum%3==0&&!isOdd) System.out.println("BEER!!");
            else flag=false;
        }
        if(!flag) System.out.println("BOOM!!");

    }

    private static void check(int idx) {
        boolean same;
        boolean isNum=false;
        for(int k=0;k<10;k++){
            same=true;
            L:for(int i=0;i<3;i++){
                for(int j=0;j<5;j++){
                    if(num[j].charAt(k*4+i)!=bomb[j].charAt(idx*4+i)){
                        same=false;
                        break L;
                    }
                }
            }
            if(same){
                sum+=k;
                isNum=true;
                if(idx==len-1&&k%2==0) isOdd=false;
            }
        }
        if(!isNum) flag=false;
    }
}
