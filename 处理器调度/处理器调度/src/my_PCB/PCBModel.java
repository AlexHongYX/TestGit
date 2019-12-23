package myPCB;

/**
 * Description: 模拟一个进程以及进程的相关信息
 */
public class PCBModel {

    // 进程名
    private String PCB_name;

    // 进程指针
    private PCBModel PCB_pointer;

    // 运行时间
    private int PCB_time;

    // 进程优先级
    private int PCB_priority;

    // 进程状态
    private char PCB_state;

    public PCBModel(String PCB_name,int PCB_time, int PCB_priority, char PCB_state) {
        this.PCB_name = PCB_name;
        this.PCB_time = PCB_time;
        this.PCB_priority = PCB_priority;
        this.PCB_state = PCB_state;
    }

    public String getPCB_name() {
        return PCB_name;
    }

    public void setPCB_name(String PCB_name) {
        this.PCB_name = PCB_name;
    }

    public PCBModel getPCB_pointer() {
        return PCB_pointer;
    }

    public void setPCB_pointer(PCBModel PCB_pointer) {
        this.PCB_pointer = PCB_pointer;
    }

    public int getPCB_time() {
        return PCB_time;
    }

    public void setPCB_time(int PCB_time) {
        this.PCB_time = PCB_time;
    }

    public int getPCB_priority() {
        return PCB_priority;
    }

    public void setPCB_priority(int PCB_priority) {
        this.PCB_priority = PCB_priority;
    }

    public char getPCB_state() {
        return PCB_state;
    }

    public void setPCB_state(char PCB_state) {
        this.PCB_state = PCB_state;
    }
}
