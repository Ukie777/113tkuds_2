
import java.util.*;

public class M10_RBPropertiesCheck {

    static class Node {

        int val;
        char color; // 'B' 或 'R'
        Node left, right;

        Node(int v, char c) {
            val = v;
            color = c;
        }
    }

    static Node buildTree(int n, int[] vals, char[] colors) {
        if (n == 0 || vals[0] == -1) {
            return null;
        }
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            if (vals[i] != -1) {
                nodes[i] = new Node(vals[i], colors[i]);
            }
        }
        for (int i = 0; i < n; i++) {
            if (nodes[i] != null) {
                int l = 2 * i + 1, r = 2 * i + 2;
                if (l < n) {
                    nodes[i].left = nodes[l];
                }
                if (r < n) {
                    nodes[i].right = nodes[r];
                }
            }
        }
        return nodes[0];
    }

    // 檢查性質 2 & 3
    static int check(Node root) {
        if (root == null) {
            return 1; // NIL 節點算黑高 1

                }int left = check(root.left);
        if (left == -1) {
            return -1;
        }
        int right = check(root.right);
        if (right == -1) {
            return -1;
        }
        if (left != right) {
            throw new RuntimeException("BlackHeightMismatch");
        }
        if (root.color == 'R') {
            if ((root.left != null && root.left.color == 'R')
                    || (root.right != null && root.right.color == 'R')) {
                throw new RuntimeException("RedRedViolation");
            }
        }
        return left + (root.color == 'B' ? 1 : 0);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] vals = new int[n];
        char[] colors = new char[n];
        for (int i = 0; i < n; i++) {
            vals[i] = sc.nextInt();
            colors[i] = sc.next().charAt(0);
            if (vals[i] == -1) {
                colors[i] = 'B'; // 空節點視為黑

                    }}
        Node root = buildTree(n, vals, colors);

        if (root != null && root.color != 'B') {
            System.out.println("RootNotBlack");
            return;
        }
        try {
            check(root);
            System.out.println("RB Valid");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
