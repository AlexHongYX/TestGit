import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created by xiaoaxiao on 2019/12/30
 * Description:
 */

import java.util.Random;
import java.util.Set;

//进程访问磁盘的磁道号
class Request
{
    private int Number;  //访问的磁道号

    public Request(int number) {
        Number = number;
    }

    public int getNumber() {
        return Number;
    }
}

public class DiskScheduling{
    private Request[] requests; //磁道请求数
    private int head =100;  //磁头设置为100磁道
    private int start;  //起始磁道号
    private int end;    //终止磁道号
    private int num;    //磁道请求数


    public DiskScheduling(int start, int end, int num) {
        this.start = start;
        this.end = end;
        this.num = num;
    }

    /**
     * 设置请求的磁道号
     */
    public void SetRequest()
    {
        requests=new Request[num];
        Set<Integer> reqSet=new TreeSet<>();
        int n=num;
        //将随机产生的磁道号放在TreeSet中
        int randomReq=0;
        while((n--)>0)
        {
            Random random=new Random();
            randomReq=random.nextInt(end-start)+start;

            while(reqSet.contains(randomReq))
            {
                randomReq=random.nextInt(end-start)+start;
            }
            // [start,end]的随机整数
            reqSet.add(randomReq);
        }
        int i=0;

        //初始化磁道请求
        for(int tmp:reqSet)
        {
            requests[i]=new Request(tmp);
            i++;
        }
    }

    /**
     * 电梯调度算法
     * 假定当前磁头在100号磁道上，并向磁道号增加的方向上移动。请给出按电梯调度算法进行磁盘调度时满足请求的次序,
     * 最终返回计算出的平均寻道长度
     */
    public float Scan()
    {
        float sum=0;
        // 高磁道
        TreeSet<Integer> bigNum=new TreeSet<>();
        // 低磁道
        TreeSet<Integer> smallNum=new TreeSet<>();
        for(int i=0;i<num;i++)
        {
            //磁道号高于当前磁道
            if(i<num&&requests[i].getNumber()>=head)
            {
                bigNum.add(requests[i].getNumber());
            }
            //磁道号低于当前磁道
            else
            {
                smallNum.add(requests[i].getNumber());
            }
        }
        System.out.println("下一个磁道号  移动磁道数");
        for(int tmp:bigNum)
        {
            System.out.println("     "+tmp+"             "+(tmp-head));
            sum=sum+(tmp-head);
            head=tmp;
        }
        // 逆序遍历
        for(int tmp:smallNum.descendingSet())
        {
            System.out.println("      "+tmp+"           "+(head-tmp));
            sum=sum+(head-tmp);
            head=tmp;
        }
        return sum/num;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("起始磁道号:");
        int start=scanner.nextInt();
        System.out.print("终止磁道号：");
        int end=scanner.nextInt();
        System.out.println("磁盘请求序列数");
        int num=scanner.nextInt();
        DiskScheduling diskScheduling=new DiskScheduling(start,end,num);
        diskScheduling.SetRequest();
        float length=diskScheduling.Scan();
        System.out.println("平均寻道长度:"+length);
    }
}