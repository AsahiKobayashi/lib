class Permutation<T> {

    private int n ;
    
    private T [] array;

    private List<T[]> permutation ;

    Permutation(T [] array) {
        this.n = array.length;
        this.array = array;
        this.permutation = new ArrayList<>();
        int [] index = new int[n];
        Arrays.setAll(index, i -> i);
        build(index);
    }

    @SuppressWarnings("unchecked")
    private void build(int [] index) {
        do{
            T [] data = (T []) java.lang.reflect.Array.newInstance(this.array.getClass().getComponentType(), n);
            for(int i = 0 ; i < n ; i ++) data[i] = (T) java.lang.reflect.Array.get(array, index[i]);
            permutation.add(data);
        }while(nextPermutation(index));
    }

    public List<T[]> get() {
        return this.permutation;
    }
    
    private static void swap(int [] array , int l , int r) {
        int tmp = array[l];
        array[l] = array[r];
        array[r] = tmp;
    }

    /**
     * 順列を生成します
     * @param array 
     * @return
     */
    private static boolean nextPermutation(int [] array) {
        if (array == null) return false;
        for (int change = array.length - 2; change >= 0; --change) {
            if (array[change] < array[change + 1]) {
                int min = change, max = array.length, halfDiff, mid;
                while ((halfDiff = max - min >> 1) != 0) {
                    if (array[change] < array[mid = min + halfDiff]) min = mid;
                    else max = mid;
                }
                swap(array, change, min);
                for (min = change + 1, max = array.length - 1; min < max; ++min, --max) swap(array, min, max);
                return true;
            }
        }
        return false;
    }

}
