import java.util.Scanner;

public class q1934 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb= new StringBuilder();
        int T=sc.nextInt();
        int a,b;
        for(int i=0;i<T;i++){
            a=sc.nextInt();
            b=sc.nextInt();
            sb.append(a*b/findGCD(a,b)+"\n");
        }
        System.out.println(sb);
    }

    private static int findGCD(int a, int b) {
        if(a<b) {
            int tmp=a;
            a=b;
            b=tmp;
        }
        while(true){
            if(a%b==0){
                return b;
            }
            int tmp=b;
            b=a%b;
            a=tmp;
        }
    }
}
