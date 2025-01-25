public class QuickFind implements DisjointSets {
    private int[] id;
    public QuickFind(int num) {
        id = new int[num];
        for(int i = 0; i < num; i++) {
            id[i] = i;
        }
    }

    public void connect(int p, int q) {
        int pid = id[p];
        int qid = id[q];
        for (int i = 0; i < id.length; i++) {
            if (id[i]== pid) {
                id[i] = qid;
            }
        }
    }

    public boolean isConnected(int p, int q) {
        return (id[p] == id[q]);
    }
}
