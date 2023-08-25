public class test {
    public static void main(String[] args) {
        boolean flag=false;

        flag=(1/2+1/2)>1;
        System.out.println(flag);
        int cnt;
        for(int i=1;i<(1<<10)-1;i++){
            cnt=0;
            for(int j=0;j<10;j++){
                if((i&(1<<j))!=0){
                    cnt++;
                    System.out.println(i&(1<<j));
                    System.out.println(cnt);
                }
            }
        }
//        System.out.println(1<<1);
    }
}
