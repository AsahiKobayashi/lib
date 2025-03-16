class BinaryTrie {

    private final class Node {
        int size = 0;
        Node[] ch = new Node[2];
    }

    private final int W;
    Node root;

    public BinaryTrie(int wordSize) {
        this.W = wordSize;
        this.root = new Node();
    }

    public void add(int x) {
        Node t = root;
        t.size++;
        for (int i = W - 1; i >= 0; i--) {
            int b = (x >> i) & 1;
            if (t.ch[b] == null) t.ch[b] = new Node();
            t = t.ch[b];
            t.size++;
        }
    }

    public void remove(int x) {
        Node t = root;
        if (t.size == 0) throw new AssertionError();
        t.size--;
        for (int i = W - 1; i >= 0; i--) {
            int b = (x >> i) & 1;
            if (sizeOf(t.ch[b]) == 0) throw new AssertionError();
            t = t.ch[b];
            t.size--;
        }
    }

    public boolean contains(int x) {
        Node t = root;
        if (t.size == 0) return false;
        for (int i = W - 1; i >= 0; i--) {
            int b = (x >> i) & 1;
            if (sizeOf(t.ch[b]) == 0) return false;
            t = t.ch[b];
        }
        return true;
    }

    public int minXor(int xor) {
        Node t = root;
        if (t.size == 0) throw new AssertionError();
        int min = 0;
        for (int i = W - 1; i >= 0; i--) {
            int z = (xor >>> i) & 1;
            int o = z ^ 1;
            if (sizeOf(t.ch[z]) > 0) {
                min |= z << i;
                t = t.ch[z];
            } else {
                min |= o << i;
                t = t.ch[o];
            }
        }
        return min;
    }

    public int max() {
        return minXor(~0);
    }

    public int min() {
        return minXor(0);
    }

    public int countLowerXor(int v, int xor) {
        Node t = root;
        int cnt = 0;
        for (int i = W - 1; i >= 0; i--) {
            if (sizeOf(t) == 0) return cnt;
            int b = (v >>> i) & 1;
            int z = (xor >>> i) & 1;
            int o = z ^ 1;
            if (b == o) {
                cnt += sizeOf(t.ch[z]);
                t = t.ch[o];
            } else {
                t = t.ch[z];
            }
        }
        return cnt;
    }

    public int countLower(int v) {
        return countLowerXor(v, 0);
    }

    public int countFloor(int v) {
        return countLower(v) + count(v);
    }

    public int countHigher(int v) {
        return countLowerXor(v, ~0);
    }

    public int countCeiling(int v) {
        return countHigher(v) + count(v);
    }

    public int count(int v) {
        Node t = root;
        for (int i = W - 1; i >= 0; i--) {
            if (sizeOf(t) == 0) return 0;
            int b = (v >>> i) & 1;
            if (b == 0) {
                t = t.ch[0];
            } else {
                t = t.ch[1];
            }
        }
        return sizeOf(t);
    }

    public int kthElementXor(int k, int xor) {
        if (k < 0 || k >= size()) throw new AssertionError();
        Node t = root;
        int res = 0;
        for (int i = W - 1; i >= 0; i--) {
            int z = (xor >>> i) & 1;
            int o = z ^ 1;
            if (sizeOf(t.ch[z]) > k) {
                res |= z << i;
                t = t.ch[z];
            } else {
                res |= o << i;
                k -= sizeOf(t.ch[z]);
                t = t.ch[o];
            }
        }
        return res;
    }

    public int kthElement(int k) {
        return kthElementXor(k, 0);
    }

    public int lowerElementXor(int v, int xor) {
        return kthElementXor(countLowerXor(v, xor) - 1, xor);
    }

    public int lowerElement(int v) {
        return lowerElementXor(v, 0);
    }

    public int higherElement(int v) {
        return lowerElementXor(v, ~0);
    }

    public int floorElement(int v) {
        return kthElement(size() - countHigher(v) - 1);
    }

    public int ceilElement(int v) {
        return kthElement(countLower(v));
    }

    public int size() {
        return root.size;
    }

    private int sizeOf(Node t) {
        return t == null ? 0 : t.size;
    }
  
}
