package myPCB;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/**
 * Description: 模拟进程的执行
 */

/**
 * 定义进程比较器——根据优先级
 */
class PCBComparable implements Comparator<PCBModel> {
    @Override
    public int compare(PCBModel o1, PCBModel o2) {
        // 按优先级从大到小排序
        // 因此需要设置为o2-o1，返回正，说明o2优先于o1，o2和o1就交换位置
        return o2.getPCB_priority()-o1.getPCB_priority();
    }
}

public class Main {

    public static void main(String[] args) {
        // 创建5个PCBModel对象
        // 任意设置其优先数和要求运行时间
        Random r = new Random(100);
        PCBModel pcb1 = new PCBModel("pcb1",r.nextInt(20),r.nextInt(10),'R');
        PCBModel pcb2 = new PCBModel("pcb2",r.nextInt(20),r.nextInt(10),'R');
        PCBModel pcb3 = new PCBModel("pcb3",r.nextInt(20),r.nextInt(10),'R');
        PCBModel pcb4 = new PCBModel("pcb4",r.nextInt(20),r.nextInt(10),'R');
        PCBModel pcb5 = new PCBModel("pcb5",r.nextInt(20),r.nextInt(10),'R');

        // 创建链表组合进程
        List<PCBModel> list = new ArrayList<>();
        list.add(pcb1);
        list.add(pcb2);
        list.add(pcb3);
        list.add(pcb4);
        list.add(pcb5);

        // 将链表根据不同的优先级
        list.sort(new PCBComparable());

        System.out.println("初始化list为：");
        printList(list);

        System.out.println("CPU开始调度：");
        CPUDiaoDu(list);
        System.out.println("CPU调度完成");
    }

    private static void printList(List<PCBModel> list){
        for (PCBModel pcbModel : list){
            System.out.println("进程名："+pcbModel.getPCB_name()+" 运行时间："+pcbModel.getPCB_time()
                +" 优先级："+pcbModel.getPCB_priority()+" 状态："+pcbModel.getPCB_state());
        }
    }

    private static void CPUDiaoDu(List<PCBModel> list){
        while (list.size()>0){
            // 获取队首的PCB元素
            PCBModel firstPCB = list.get(0);

            // 输出该PCB
            System.out.println("选中进程"+firstPCB.getPCB_name());

            // 将该PCB优先级-1，运行时间-1
            firstPCB.setPCB_priority(firstPCB.getPCB_priority()-1);
            firstPCB.setPCB_time(firstPCB.getPCB_time()-1);

            // 如果此时该PCB的运行时间为0，则将其状态设置为'E'，并将其从队列中删除
            if (firstPCB.getPCB_time()==0){
                firstPCB.setPCB_state('E');
                // 将其从队列中删除
                list.remove(0);
            }

            // 在将此时的队列进行重新排序，进行下一次的调度
            list.sort(new PCBComparable());

            // 如果队列还有元素，则输出
            // 若没有元素，则直接返回，说明CPU执行完成了
            if (list.size()>0){
                System.out.println("本次系统调度结束，队列变为：");
                printList(list);
            }

        }
    }
}
