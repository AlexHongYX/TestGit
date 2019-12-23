import jdk.internal.org.objectweb.asm.commons.RemappingAnnotationAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Method {
    //实现CPU每次调度队列的队首元素
    public static void CPUdispatch(List<PCB> list){
        if(list.size()>0) {
            System.out.println("本次选中的进程为:"+list.get(0).pcb);
            //选中的队首元素优先数-1
            list.get(0).priority = list.get(0).priority - 1;
            //选中的队首元素运行时间-1
            list.get(0).time = list.get(0).time - 1;
            //对队列进行重新排序
            sortPCB(list);
        }
    }
    private static List<PCB> sortPCB(List<PCB> list){
        for(int i=0;i<list.size();i++){
            //如果队列中进程的运行时间==0，则修改状态为‘E’，并从队列中删除
            if(list.get(i).time==0){
                char c=list.get(i).state='E';
                //PCB p=list.get(i);
                list.remove(list.get(i));
                //System.out.println(p.pcb+"的调度已完成"+"，状态为："+c);
            }
        }
        //使用实现了Comparator接口的类对队列进行排序
        list.sort(new PCBComparator());
        //将队列用链表连接起来
        for(int i=0;i<list.size()-1;i++){
            list.get(i).pointer=list.get(i+1);
        }
        return list;
    }
    public static List<PCB> buildPCB() {
        //创建5个进程
        Random random=new Random(2019);
        PCB pcb1 = new PCB("p1", random.nextInt(10), random.nextInt(8), 'R');
        PCB pcb2 = new PCB("p2", random.nextInt(10), random.nextInt(8), 'R');
        PCB pcb3 = new PCB("p3", random.nextInt(10), random.nextInt(8), 'R');
        PCB pcb4 = new PCB("p4", random.nextInt(10), random.nextInt(8), 'R');
        PCB pcb5 = new PCB("p5", random.nextInt(10), random.nextInt(8), 'R');
        List<PCB> list=new ArrayList<>();
        list.add(pcb1);
        list.add(pcb2);
        list.add(pcb3);
        list.add(pcb4);
        list.add(pcb5);
        list.sort(new PCBComparator());
        for(int i=0;i<list.size()-1;i++){
            list.get(i).pointer=list.get(i+1);
        }
        return list;
    }
    private static void print(List<PCB> list){
        //打印队列
        for(PCB pcb:list){
            if(pcb.pointer!=null) {
                System.out.println("进程名：" + pcb.pcb + " 它的下一个为：" + pcb.pointer.pcb + " 优先数：" + pcb.priority + " 运行时间" + pcb.time + " 状态" + pcb.state);
            }else{
                System.out.println("进程名：" + pcb.pcb + " 它的下一个为：null" + " 优先数：" + pcb.priority + " 运行时间" + pcb.time + " 状态" + pcb.state);
            }
        }
    }
    public static void main(String[] args) {
        List<PCB> list=buildPCB();
        System.out.println("最开始的队列为：");
        print(list);
        System.out.println("================");
        while(list.size()>0) {
            CPUdispatch(list);
            System.out.println("本次调度之后的队列变化为：");
            print(list);
            System.out.println("===============");
        }
        System.out.println("本次CPU调度完全结束");
    }
}
