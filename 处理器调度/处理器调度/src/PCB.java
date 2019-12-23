public class PCB {
    //进程名
    String pcb;
    //指针
    PCB pointer;
    //运行时间
    int time;
    //优先数
    int priority;
    //状态
    char state;
    //PCB模拟进程，PCB的构造方法
    public PCB(String pcb, int time, int priority, char state) {
        this.pcb = pcb;
        this.time = time;
        this.priority = priority;
        this.state = state;
    }

}
