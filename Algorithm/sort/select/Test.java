package Algorithm.sort.select;

import Algorithm.sort.Sort;
import Algorithm.sort.SortUtil;

/**
 * Created by never on 2014/9/4.
 */
public class Test {
    public static void main(String arg[]) {
        System.out.println("============= Simple Select Sort ===============");
        int[] array1 = {1, 4, 2, 40, 23, 90,56};
        SortUtil.printArray(array1);
        Sort simpleSelectSort = new SimpleSelectSort();
        simpleSelectSort.sort(array1);
        SortUtil.printArray(array1);
    }
}
