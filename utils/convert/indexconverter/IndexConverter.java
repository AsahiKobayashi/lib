record ConvertIndex(int h , int w) {
    
    public final int toDim1(final int i , final int j) {
        return i * w + j ;
    }
    
    public final int [] toDim2(final int ij) {
        return new int[]{ij / w , ij % w};
    }
    
}
