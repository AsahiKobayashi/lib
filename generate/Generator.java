final class Generator {
    
    public static final <T> List<T> [] generateListArray(int n , Class<T> clazz) {
        List<T> [] G = new ArrayList[n];
        Arrays.setAll(G , i -> new ArrayList<>());
        return G;
    }
    
    public static final int [] serialNumber(int n) {
        int [] array = new int[n];
        Arrays.setAll(array , i -> i);
        return array;
    }
    
}
