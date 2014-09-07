package Algorithm.sort.merge;

import Algorithm.sort.Sort;
import Algorithm.sort.SortUtil;

/**
 * Created by soft on 2014/9/6.
 */
public class MergeTest {
    public static void main(String arg[]) {
        System.out.println("============= Merge Sort ===============");
        int[] array1 = {1, 4, 2, 40, 23, 90,56};
        SortUtil.printArray(array1);
        Sort mergeSort = new MergeSort();
        mergeSort.sort(array1);
        SortUtil.printArray(array1);

        System.out.println("============= Merge Sort2 ===============");
        int[] array2 = {1, 4, 2, 40, 23, 90,56};
        SortUtil.printArray(array2);
        Sort mergeSort2 = new MergeSort2();
        mergeSort2.sort(array2);
        SortUtil.printArray(array2);

        System.out.println("============= Merge Sort Improve ===============");
        int[] array3 = {1, 4, 2, 40, 23, 90,56};
        SortUtil.printArray(array3);
        Sort mergeSortImprove = new MergeSortImprove();
        mergeSortImprove.sort(array3);
        SortUtil.printArray(array3);
    }
}
