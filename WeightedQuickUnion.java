import java.util.Arrays;

public class WeightedQuickUnion {
    private int[] parent;

    public WeightedQuickUnion(int n) {
        parent = new int[n];
        Arrays.fill(parent, -1);
    }

    public int find(int p) {
        if (parent[p] < 0) {
            return p;
        }
        parent[p] = find(parent[p]);
        return parent[p];
    }

    public void connect(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);

        if (rootP == rootQ) {
            return;
        }

        if (parent[rootP] < parent[rootQ]) {
            parent[rootQ] = rootP;
            parent[rootP]--;
        } else if (parent[rootQ] < parent[rootP]) {
            parent[rootP] = rootQ;
            parent[rootQ]--;
        } else {
            if (p > q) {
                parent[rootQ] = rootP;
                parent[rootP]--;
            } else {
                parent[rootP] = rootQ;
                parent[rootQ]--;
            }
        }
    }

    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    public static void main(String[] args) {
        WeightedQuickUnion wqu = new WeightedQuickUnion(12);
        wqu.connect(0, 1);
        wqu.connect(1, 2);
        wqu.connect(2, 3);
        wqu.connect(4, 5);
        wqu.connect(5, 3);
        wqu.connect(6, 7);
        wqu.connect(8, 9);
        wqu.connect(9, 10);
        wqu.connect(10, 11);
        wqu.connect(7, 8);
        wqu.connect(3, 11);
    }
}
