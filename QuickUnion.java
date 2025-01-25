import java.util.Arrays;

public class QuickUnion implements DisjointSets {
    private int[] parent;

    public QuickUnion(int num) {
        parent = new int[num];

        // Same as the array method
        // for (int i = 0; i < num; i++) {
        //    parent[i] = i;
        //}

        // Same as for loop
        Arrays.fill(parent, -1);
    }

    /* public int find(int p) {
        while (parent[p] != -1) {
            p = parent[p];
        }
        return p;
    } */

    public int find(int p) {
        int root = p;
        while (parent[root] >= 0) {
            root = parent[root];
        }

        while (p != root) {
            int next = parent[p];
            parent[p] = root;
            p = next;
        }
        return root;
    }

    public void connect(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP != rootQ) {
            parent[rootP] = rootQ;
        }
    }

    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    public static void main(String[] args) {
        QuickUnion qu = new QuickUnion(10);
        qu.connect(0,1);
        qu.connect(1,2);
        qu.connect(2,3);
        qu.connect(4,5);
        // qu.connect(5,6);
        qu.connect(5,3);
        qu.connect(6,7);
        qu.connect(8,9);
        qu.connect(9,10);
        qu.connect(10,11);
        qu.connect(7,8);
        qu.connect(3,11);
        qu.connect(0,10);
        System.out.println(qu.isConnected(1, 6));
    }
}
