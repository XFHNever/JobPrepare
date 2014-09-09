package Algorithm.sort.distribution;

import Algorithm.sort.Sort;
import Algorithm.sort.SortUtil;

/**
 * Created by soft on 2014/9/6.
 *
 * 核心思想
 *
 * 时间复杂度
 *
 * 空间复杂度
 *
 * 稳定的
 *
 */
public class DistributionTest {
    public static void main(String arg[]) {
        System.out.println("============= bucket Sort ===============");
        int[] array1 = {1, 4, 2, 40, 23, 90,56};
        SortUtil.printArray(array1);
        Sort bucketSort = new BucketSort();
        bucketSort.sort(array1);
        SortUtil.printArray(array1);

        System.out.println("============= MSD Radix Sort ===============");
        int[] array2 = {1, 4, 2, 40, 23, 90,56};
        SortUtil.printArray(array2);
        Sort msdRadixSort = new MSDRadixSort();
        msdRadixSort.sort(array2);
        SortUtil.printArray(array2);

        System.out.println("============= LSD Radix Sort ===============");
        int[] array3 = {1, 4, 2, 40, 23, 90,56};
        SortUtil.printArray(array3);
        Sort lsdRadixSort = new LSDRadixSort();
        lsdRadixSort.sort(array3);
        SortUtil.printArray(array3);
    }
}
