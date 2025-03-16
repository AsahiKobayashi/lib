class BinaryIndexedTree {

    private int n;
    private long [] data;

    public BinaryIndexedTree(int n){
        this.n = n;
        data = new long[n];
    }

    public long get(int p){
        return sum(p, p+1);
    }

    public void set(int p, long x){
        add(p, x - get(p));
    }

    public void add(int p, long x){
        assert(0<=p && p<n);
        p++;
        while(p<=n){
            data[p-1] += x;
            p += p&-p;
        }
    }

    public long sum(int l, int r){
        assert(0<=l && l<=r && r<=n);
        return sum(r)-sum(l);
    }

    private long sum(int r){
        long s = 0;
        while(r>0){
            s += data[r-1];
            r -= r&-r;
        }
        return s;
    }

}
