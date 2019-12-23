import java.util.Scanner;

public class Methods {
    /**
     *
     * @param i 表示它是哪个进程
     * @param request 表示它请求的每个资源的数量
     */
    static DataStructor dataStructor=new DataStructor();
    public static boolean bankerMethod(int i,int[] request){
        int[][] need=dataStructor.getNeed();
        int[] available=dataStructor.getAvailable();
        int[][] allocation=dataStructor.getAllocation();
        for(int j=0;j<request.length;j++) {
            //如果请求的小于等于他所需要的
            if (need[i][j] >= request[j]) {
                //如果系统中的资源大于他所请求的
                if (available[j] >= request[j]) {
                    available[j] -= request[j];
                    allocation[i][j] += request[j];
                    need[i][j] -= request[j];
                    dataStructor.setAllocation(allocation);
                    dataStructor.setAvailable(available);
                    dataStructor.setNeed(need);
                    //如果分配给他存在不安全状态，撤销对它的分配
                    if (!safeMethod(i)) {
                        available[j] += request[j];
                        allocation[i][j] -= request[j];
                        need[i][j] += request[j];
                        dataStructor.setAllocation(allocation);
                        dataStructor.setAvailable(available);
                        dataStructor.setNeed(need);
                        System.out.println("不安全状态，无法分配资源");
                        return false;
                    }
                } else {//如果系统中没有足够的资源给它
                    System.out.println("尚未足够的资源 p" + i + "需等待");
                    return false;
                }
            } else {//如果他要的比他需要的多
                System.out.println("请求资源超过他的最大值！");
                return false;
            }
        }
        System.out.println("分配成功");
        return true;
    }
    private static boolean safeMethod(int k){
        int[] work=dataStructor.getAvailable();
        int[][] need=dataStructor.getNeed();
        int[][] allocation=dataStructor.getAllocation();
        boolean[] finish=new boolean[dataStructor.getN()];
        //初始化finish全为false
        for(int i=0;i<finish.length;i++){
            if(i!=k) {
                finish[i] = false;
            }else{
                finish[i]=true;
            }
        }
        for(int m=0;m<finish.length;m++){
            for(int i=0;i<finish.length;i++) {
                if(i==k){
                    continue;
                }
                if (!finish[i]) {
                    boolean record = true;
                    for (int j = 0; j < work.length; j++) {
                        //判断如果它需要的大于系统中的资源，则跳出
                        if (need[i][j] > work[j]) {
                            record = false;
                            break;
                        }
                    }
                    //如果i进程中的每一个都可以申请到系统中的资源，则将该进程改为true
                    if (record) {
                        finish[i] = true;
                        //该进程完成，释放资源
                        for (int j = 0; j < work.length; j++) {
                            work[j] += allocation[i][j];
                        }
                    }
                }
            }
        }
        for(boolean b:finish){
            if(!b){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("输入系统中的资源数目：");
        int m=scanner.nextInt();
        scanner.nextLine();
        System.out.println("输入系统中的进程总数：");
        int n=scanner.nextInt();
        scanner.nextLine();

        int[] available=new int[m];
        System.out.println("输入系统中每类资源的数目：");
        String s1=scanner.nextLine();
        String[] strings1=s1.split(" ");
        for(int i=0;i<strings1.length;i++){
            available[i]=Integer.valueOf(strings1[i]);
        }
        dataStructor.setAvailable(available);


        int[][] allocation=new int[n][m];
        for(int i=0;i<n;i++){
            System.out.println("请输入"+m+"个数字表示"+(i+1)+"进程中对每类资源的已分配资源(以空格分隔)");
            String string=scanner.nextLine();
            String[] strings=string.split(" ");
            for(int j=0;j<strings.length;j++){
                allocation[i][j]=Integer.valueOf(strings[i]);
            }
        }
        dataStructor.setAllocation(allocation);


        int[][] need=new int[n][m];
        for(int i=0;i<n;i++){
            System.out.println("请输入"+m+"个数字表示"+(i+1)+"此进程中对每类资源的需求(以空格分隔)");
            String string=scanner.nextLine();
            String[] strings=string.split(" ");
            for(int j=0;j<strings.length;j++){
                 need[i][j]=Integer.valueOf(strings[i]);
            }
        }
        dataStructor.setNeed(need);

        int[][] max=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                max[i][j]=allocation[i][j]+need[i][j];
            }
        }
        dataStructor.setMax(max);


        System.out.println("输入你所需要分配资源的进程：");
        int p=scanner.nextInt();
        scanner.nextLine();
        System.out.println("输入你所需要申请的资源数目：");
        int[] request=new int[m];
        String s2=scanner.nextLine();
        String[] strings2=s2.split(" ");
        for(int i=0;i<strings2.length;i++){
            request[i]=Integer.valueOf(strings2[i]);
        }
        bankerMethod(p,request);
    }
}
