class Pair<T extends Comparable<T>, U extends Comparable<U>> implements Comparable<Pair<T, U>> {

    private T first;
    private U second;

    Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }
    
    public void setFirst(T first) {
        this.first = first;
    }
    
    public void setSecond(U second) {
        this.second = second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(first, pair.first) && Objects.equals(second, pair.second);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }

    @Override
    public int compareTo(Pair<T, U> other) {
        T f  = this.first  , F  = other.first;
        U s  = this.second , S  = other.second;
        int First_Result  = f.compareTo(F);
        int Second_Result = s.compareTo(S);
        return First_Result == 0 ? Second_Result : First_Result ;
    }

    @Override
    public String toString() {
        return "(" + this.first + " , " + this.second + ")";
    }
    
}
