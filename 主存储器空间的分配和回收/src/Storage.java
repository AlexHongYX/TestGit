/**
 * Created by xiaoaxiao on 2019/12/30
 * Description:
 */
import java.util.LinkedList;
import java.util.Scanner;


public class Storage {


    /**
     * 作业展示
     * @param array
     */
    public static void Show(int[][] array) {
        int i, j;
        for (i = 0; i <= 7; i++) {
            for (j = 0; j <= 7; j++) {
                System.out.print(array[i][j] + "  ");
            }
            System.out.println();
        }
    }


    /**
     * 添加作业
     * @param array
     * @return
     */
    public static int Plus(int[][] array) {
        int i, j;
        int num = 0;
        for (i = 0; i <= 7; i++) {
            for (j = 0; j <= 7; j++) {
                if (array[i][j] == 0) {
                    num++;
                }
            }
        }
        return num;
    }


    /**
     * 申请作业
     * @param array
     */
    public static void Apply(int[][] array) {
        int i = 0, j = 0, k = 0;
        int id = 0;
        int residue = 0;
        int num = 0;
        System.out.println("输入作业id以及内存块：\n");
        Scanner scan = new Scanner(System.in);
        id = scan.nextInt();
        num = scan.nextInt();

        residue = Plus(array);
        if (residue < num) {
            System.out.println("内存不足，创建进程失败！\n");
        } else {

            StoreClass sto = new StoreClass();
            sto.setId(id);

            int[] temp = new int[64];
            for (i = 0; i < 64; i++) {
                temp[i] = -1;
            }
            sto.setYe(temp);

            boolean b = list.add(sto);
            for (i = 0; i <= 7; i++) {
                for (j = 0; j <= 7; j++) {
                    if (array[i][j] == 0) {
                        array[i][j] = 1;
                        sto.ye[k] = i * 8 + j;
                        k++;
                    }
                    if (k == num) {
                        break;
                    }
                }
                if (k == num) {
                    break;
                }
            }
        }
    }

    /**
     * 删除作业
     * @param a
     */
    public static void Revocation(int[][] a) {
        int tempi = -1, tempj = -1;
        int i = 0, j = 0, id = 0;
        String cla = "";//是否要删除作业
        int flag = 0;//是否查找到需要删除的作业
        System.out.println("输入要删除作业的id：");
        Scanner scan = new Scanner(System.in);
        id = scan.nextInt();

        for (int k = 0; k < list.size(); k++) {
            StoreClass store = (StoreClass) list.get(k);
            if (store.getId() == id) {
                if (cla.equals("Y") || cla.equals("y")) {
                    flag = 1;
                    list.remove(store);
                    for (i = 0; i <= 63; i++) {//将作业占用的内存块归还
                        if (store.ye[i] != -1) {//页表存放的数字是内存块的地址 （8*i+j）
                            tempi = store.ye[i] / 8;
                            tempj = store.ye[i] % 8;
                            a[tempi][tempj] = 0; //将内存块的使用标记修改为0
                        }
                    }
                } else {
                    System.out.println("取消撤销作业！");
                    return;
                }
            }
        }
        if (flag != 1) {
            System.out.println("未找到该作业，撤销作业失败！");
        }
    }

    /**
     * 查看单个作业的页表信息
     * @param a
     */
    public static void lookpage(int[][] a) {
        int i = 0, x = 0, y = 0;
        int id = 0;
        int flag = 0;//是否查找到该作业
        Scanner scan = new Scanner(System.in);
        System.out.println("输入你想要查看的作业的id号：");
        id = scan.nextInt();
        for (int k = 0; k < list.size(); k++) {
            StoreClass store = (StoreClass) list.get(k);
            if (store.getId() == id) {
                flag = 1;
                System.out.println("该作业的页表情况为：");
                System.out.println("页号-----------块号---------- 详细");
                for (i = 0; i <= 63; i++) {
                    if (store.ye[i] != -1) {
                        x = store.ye[i] / 8;
                        y = store.ye[i] % 8;
                        System.out.println(i + "---------------" + store.ye[i] + "-------------- 8 *" + x + "+" + y);
                    }
                }
                return;
            }
        }
        if (flag != 1) {
            System.out.println("没有查找到作业，查看失败！");
        }
    }

    /**
     * 创建链表
     */
    public static LinkedList list = new LinkedList();


    public static void main(String[] args) {
        int num = 0;
        int order = 0;
        int[][] a = new int[8][8];                             //模拟内存，初始化为0
        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j <= 7; j++) {
                a[i][j] = 0;
            }
        }
        System.out.println("-----------------输入0:退出-------------------");
        System.out.println("-----------------输入1:新建作业----------------");
        System.out.println("-----------------输入2:撤销作业----------------");
        System.out.println("-----------------输入3:查看列表----------------");
        System.out.println("-----------------输入4：输出内存块信息----------");
        Scanner scan = new Scanner(System.in);
        order = scan.nextInt();
        while (order != 0) {
            switch (order) {
                case 1:
                    Apply(a);
                    break;
                case 2:
                    Revocation(a);
                    break;
                case 3:
                    lookpage(a);
                    break;
                case 4:
                    Show(a);
                    break;
            }

            System.out.println("-----------------输入0:退出-------------------");
            System.out.println("-----------------输入1:新建作业----------------");
            System.out.println("-----------------输入2:撤销作业----------------");
            System.out.println("-----------------输入3:查看列表----------------");
            System.out.println("-----------------输入4：输出内存块信息----------");
            order = scan.nextInt();
        }
        System.out.println("程序运行结束");
    }
}
