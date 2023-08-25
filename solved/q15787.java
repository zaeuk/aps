package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class q15787 {
    /*
        어떤 자료구조를 취할지 고민을 해봐야할 것 같은데.
        기차가 10만개나 되서 배열괜찮은가. 나중에 중복확인을 어떻게하지.
        200만 불린을 만드는건 어렵지 않다.
        명령하나에 최대 20개연산정도 들어간다.
        명령도 최대 10만개 boolean으로 만들고 나중에 set에 String으로 넣자
        step1. boolean 배열 20*N
        step2. false x , true o String 변환후 set에 삽입 set size 출력
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());

        boolean[][] trains=new boolean[N][20];

        int order,t,x;
        for(int j=0;j<M;j++){
            st=new StringTokenizer(br.readLine());
            order=Integer.parseInt(st.nextToken());
            t=Integer.parseInt(st.nextToken())-1;
            switch (order){
                case 1:
                    x=Integer.parseInt(st.nextToken())-1;
                    trains[t][x]=true;
                    break;
                case 2:
                    x=Integer.parseInt(st.nextToken())-1;
                    trains[t][x]=false;
                    break;
                case 3:
                    for(int i=19;i>0;i--){
                        trains[t][i]=trains[t][i-1];
                    }
                    trains[t][0]=false;
                    break;
                case 4:
                    for(int i=0;i<19;i++){
                        trains[t][i]=trains[t][i+1];
                    }
                    trains[t][19]=false;
                    break;
                default:
                    break;
            }
        }
        Set<String> set=new HashSet<>();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<N;i++){
            sb.setLength(0);
            for(int j=0;j<20;j++){
                if(trains[i][j]) sb.append("o");
                else sb.append("x");
            }
            set.add(sb.toString());
        }
        System.out.println(set.size());
    }
}
