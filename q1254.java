    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;

    public class q1254 {
        /*
            팰린드롬 만들기
            문자열 문제다.
            중간부터 시작해서 앞뒤로 같은지 체크 안같으면 하나 늘려서 같은지 비교
            같으면 중간값 *2+1 하면 될것 같다고 생각하는데
            + 만약 뒤에께 나와 같다면 2번째 옵션 짝수 팰린드롬 고려.
         */
        public static void main(String[] args) throws IOException {
            BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

            String str=br.readLine();
            int cnt=0;
            for(int i=0;i<str.length()-1;i++){
                String tmp = str.substring(i);
//                System.out.println(tmp+" "+new StringBuffer(tmp).reverse().toString());
                if(!tmp.equals(new StringBuffer(tmp).reverse().toString())) cnt++;
                else break;
            }
            System.out.println(str.length()+cnt);



            //기존풀이
//            char[] arr=br.readLine().toCharArray();
//            int len= arr.length;
//            boolean flag;
//            int ans=0;
//
//            //이미 짝수팰린드롬인거... 거르기용
//            if(len%2==0&&arr[len/2-1]==arr[len/2]){
//                flag=true;
//                for(int i=1;len/2+i<len;i++){
//                    if(arr[len/2-1-i]!=arr[len/2+i]) flag=false;
//                }
//                if(flag){
//                    System.out.println(len);
//                    System.exit(0);
//                }
//            }
//
//            for(int i=len/2;i<len;i++){
//                flag=true;
//                for(int j=1;i+j<len;j++){
//                    if(arr[i-j]!=arr[i+j]) {
//                        flag=false;
//                        break;
//                    }
//                }
//                if(flag){
//                    ans=i*2+1;
//                    break;
//                }
//                if(i!=len-1&&arr[i]==arr[i+1]){
//                    flag=true;
//                    for(int j=1;i+1+j<len;j++){
//                        if(arr[i-j]!=arr[i+1+j]) {
//                            flag=false;
//                            break;
//                        }
//                    }
//                    if(flag){
//                        ans=(i+1)*2;
//                        break;
//                    }
//                }
//            }
//
//            System.out.println(ans);
        }
    }
