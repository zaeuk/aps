package solved;

import java.util.Scanner;

public class q2744 {
    public static void main(String[] args) {
        int diff='a'-'A';
        Scanner sc= new Scanner(System.in);
        String input=sc.nextLine();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<input.length();i++){
            if(input.charAt(i)>='a'){//소문자
                sb.append((char)(input.charAt(i)-diff));
            }else{
                sb.append((char)(input.charAt(i)+diff));
            }
        }
        System.out.println(sb);
    }
}
/*
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next(), t = "";
        for (int d:s.getBytes())
            t += (char)(d ^ 32);
        System.out.println(t);
    }

}
이런풀이도 존재한다.
diff가 32이라
32만큼 어쨋든 바꾸면되는거니까.
 */