@SuppressWarnings("unchecked")
class ArraysUtil {

    public static final <T> void swap(T array , int l , int r) {
        Object left = java.lang.reflect.Array.get(array , l) , right = java.lang.reflect.Array.get(array , r);
        java.lang.reflect.Array.set(array , l , right); java.lang.reflect.Array.set(array , r , left);
    }   

    public static final <T,S> T insert(T array , int index , S value) {
        T e = (T) java.lang.reflect.Array.newInstance(array.getClass().getComponentType() , 1) ;
        java.lang.reflect.Array.set(e, 0 , value);
        T arrays = split(array , index);
        return merge((T) java.lang.reflect.Array.get(arrays, 0) , merge(e , (T) java.lang.reflect.Array.get(arrays, 1)));
    }

    public static final <T> T delete(T array , int index) {
        T arrays = split(array , index);
        T arrays2 = split((T) java.lang.reflect.Array.get(arrays, 1) , 1);
        return merge((T) java.lang.reflect.Array.get(arrays, 0) , (T) java.lang.reflect.Array.get(arrays2, 1));
    }

    public static final <T> T split(T array , int index) {
        T l = (T) java.lang.reflect.Array.newInstance(array.getClass().componentType() , index);
        T r = (T) java.lang.reflect.Array.newInstance(array.getClass().componentType() , java.lang.reflect.Array.getLength(array) - index);
        T ret = (T) java.lang.reflect.Array.newInstance(array.getClass().componentType() , 2);
        System.arraycopy(array , 0 , l , 0 , index);
        System.arraycopy(array , index , r, 0,  java.lang.reflect.Array.getLength(array) - index);
        java.lang.reflect.Array.set(ret,0 , l);
        java.lang.reflect.Array.set(ret,0 , r);
        return ret ;
    }

    public static final <T> T merge(T l , T r) {
        T array = (T) java.lang.reflect.Array.newInstance(l.getClass().componentType() , java.lang.reflect.Array.getLength(l) + java.lang.reflect.Array.getLength(r));
        System.arraycopy(l , 0, array, 0 , java.lang.reflect.Array.getLength(l));
        System.arraycopy(r , 0, array,  java.lang.reflect.Array.getLength(l) , java.lang.reflect.Array.getLength(r));
        return array ;
    }

    public static final <T,S> void fill(T array, S value) {
        int length = java.lang.reflect.Array.getLength(array);
        for (int i = 0; i < length; i++) {
            Object element = java.lang.reflect.Array.get(array, i);
            if (element != null && element.getClass().isArray()) fill(element, value);
            else java.lang.reflect.Array.set(array, i, value);
        }
    }

    public static final <T> void dump(T array) {
        int length = java.lang.reflect.Array.getLength(array);
        for (int i = 0; i < length; i++) {
            Object element = java.lang.reflect.Array.get(array, i);
            if (element != null && element.getClass().isArray()) dump(element);
            else System.out.print(i != length - 1 ? element+" " : element+"\n");
        }
    }

}
