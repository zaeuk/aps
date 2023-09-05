import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class q1918_H {
    /*
        후위 표기식
        stack problem
        다시풀려니까 너무어려운데.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str=br.readLine();
        char[] arr=str.toCharArray();
        char c;

        Stack<Character> stk=new Stack<>();

        StringBuilder sb=new StringBuilder();
        for(int i=0;i<arr.length;i++){
            c=arr[i];
            if(c=='+'||c=='-'){
                while(!stk.isEmpty()&&stk.peek()!='('){
                    sb.append(stk.pop());
                }
                stk.add(c);
            }else if(c=='*'||c=='/'){
                while(!stk.isEmpty()&&(stk.peek()=='*'||stk.peek()=='/')){
                    sb.append(stk.pop());
                }
                stk.add(c);
            }else if(c=='('){
                stk.add(c);
            }else if(c==')'){
                while(stk.peek()!='(')
                    sb.append(stk.pop());
                stk.pop();
            }else{
                sb.append(c);
            }
        }
        while(!stk.isEmpty()){
            sb.append(stk.pop());
        }
        System.out.println(sb);

    }
}