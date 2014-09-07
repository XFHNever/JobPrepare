package Algorithm.sort.distribution;

import Algorithm.sort.Sort;
import Algorithm.sort.SortUtil;

/**
 * Created by soft on 2014/9/6.
 */
public class DistributionTest {
    public static void main(String arg[]) {
        System.out.println("============= bucket Sort ===============");
        int[] array1 = {1, 4, 2, 40, 23, 90,56};
        SortUtil.printArray(array1);
        Sort bucketSort = new BucketSort();
        bucketSort.sort(array1);
        SortUtil.printArray(array1);

        System.out.println("============= Radix Sort ===============");
        int[] array2 = {1, 4, 2, 40, 23, 90,56};
        SortUtil.printArray(array2);
        Sort radixSort = new RadixSort();
        radixSort.sort(array2);
        SortUtil.printArray(array2);
    }
}
