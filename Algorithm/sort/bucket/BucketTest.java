package Algorithm.sort.bucket;

import Algorithm.sort.Sort;
import Algorithm.sort.SortUtil;

/**
 * Created by soft on 2014/9/6.
 */
public class BucketTest {
    public static void main(String arg[]) {
        System.out.println("============= bucket Sort ===============");
        int[] array1 = {1, 4, 2, 40, 23, 90,56};
        SortUtil.printArray(array1);
        Sort bucketSort = new BucketSort();
        bucketSort.sort(array1);
        SortUtil.printArray(array1);
    }
}
