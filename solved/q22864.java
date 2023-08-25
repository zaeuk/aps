package solved;

import java.util.Scanner;

public class q22864 {
    /*
        A 한시간 피로도
        B 시간당 일처리량
        C 한시간 휴식시 피로도 감소
        M 최대 피로도
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int A=sc.nextInt();
        int B=sc.nextInt();
        int C=sc.nextInt();
        int M=sc.nextInt();

        int f=0;
        int w=0;
        int t=0;
        while(t<24){
            if(f+A<=M){
                f+=A;
                w+=B;
            }else{
                f-=C;
                if(f<0) f=0;
            }
            t++;
        }
        System.out.println(w);
    }
}
