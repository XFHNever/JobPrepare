package Algorithm.sort;

/**
 * Created by never on 2014/9/2.
 */
public class SortUtil {
    public static void swap(int[] array, int left, int right) {
        int tem = array[left];
        array[left] = array[right];
        array[right] = tem;
    }
}
