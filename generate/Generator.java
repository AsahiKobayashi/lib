final class Generator {
    
    public static <T> List<T> [] listArray(int n , Class<T> clazz) {
        List<T> [] G = new ArrayList[n];
        Arrays.setAll(G , i -> new ArrayList<>());
        return G;
    }
    
}
