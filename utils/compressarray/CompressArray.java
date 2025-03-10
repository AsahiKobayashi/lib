record CompressArray(int h , int w) {
    
    public final int dim1(final int i , final int j) {
        return i * w + j ;
    }
    
    public final int [] dim2(final int ij) {
        return new int[]{ij / w , ij % w};
    }
    
}
