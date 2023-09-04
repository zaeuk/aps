package solved;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class q17413 {
    /*
        stack 써서 < 열리면 queue에 넣고
        >나오면 queue에 있던거 꺼내서 sb에 집어넣고
        안열린상태에서는 stack에 집어넣고 <열리기 전 혹은 끝날 다 꺼내서 sb에 집어넣기


     */

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        char[] c=sc.nextLine().toCharArray();
        Stack<Character> stk = new Stack<>();
        Queue<Character> q=new ArrayDeque<>();
        StringBuilder sb=new StringBuilder();
        boolean flag=false;
        for(int i=0;i<c.length;i++){
            if(c[i]=='<'){
                while(!stk.isEmpty()){
                    sb.append(stk.pop());
                }
                flag=true;
                sb.append('<');
            }else if(c[i]=='>'){
                while(!q.isEmpty()){
                    sb.append(q.poll());
                }
                flag=false;
                sb.append('>');
            }else if(flag){
                q.offer(c[i]);
            }else if(!flag&&c[i]==' '){
                while(!stk.isEmpty()){
                    sb.append(stk.pop());
                }
                sb.append(' ');
            }else{
                stk.push(c[i]);
            }
        }
         while(!stk.isEmpty()){
            sb.append(stk.pop());
        }
        System.out.println(sb);

    }
}


