import java.util.Comparator;

//通过实现Comparator接口，对队列按照优先数的大小进行排序（从大到小）
public class PCBComparator implements Comparator<PCB> {
    @Override
    public int compare(PCB o1, PCB o2) {
        return o2.priority-o1.priority;
    }
}
