public class DataStructor {
    private int n=0;
    private int m=0;
    //可利用资源向量，K表示共有K类资源，其中的值表示该类资源有多少个
    private int[] Available=new int[m];
    //最大需求矩阵，它定义了n个进程中对m类资源的最大需求
    private int[][] Max=new int[n][m];
    //分配矩阵,他表示每一类资源当前已分配给每个进程的资源数
    private int[][] Allocation=new int[n][m];
    //需求矩阵，他表示每一个进程尚需的各类资源数
    private int[][] Need=new int[n][m];

    public int[] getAvailable() {
        return Available;
    }

    public void setAvailable(int[] available) {
        Available = available;
    }

    public int[][] getMax() {
        return Max;
    }

    public void setMax(int[][] max) {
        Max = max;
    }

    public int[][] getAllocation() {
        return Allocation;
    }

    public void setAllocation(int[][] allocation) {
        Allocation = allocation;
    }

    public int[][] getNeed() {
        return Need;
    }

    public void setNeed(int[][] need) {
        Need = need;
    }

    public int getN() {
        return n;
    }

    public int getM() {
        return m;
    }

    public void setN(int n) {
        this.n = n;
    }

    public void setM(int m) {
        this.m = m;
    }
}
