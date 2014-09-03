package Algorithm.sort.insert;

import Algorithm.sort.Sort;
import Algorithm.sort.SortUtil;

/**
 * Created by never on 2014/9/3.
 *
 * 使用折半搜索法寻找元素插入位置。
 *
 * 时间复杂度:与初始队列无关，仅仅依赖于元素个数，nlog2n
 *
 * 空间复杂度：与直接插入排序一样，依赖于元素的初始排列。
 *
 * 稳定，适合于乱序小型数组，排好序或者基本有序直接插入更合适。
 */
public class Test {
    public static void main(String arg[]) {
        System.out.println("============= Direct Insert Sort ===============");
        int[] array1 = {1, 4, 2, 40, 23, 90,56};
        SortUtil.printArray(array1);
        Sort directInsertSort = new DirectInsertSort();
        directInsertSort.sort(array1);
        SortUtil.printArray(array1);

        System.out.println("============= Binary Insert Sort ===============");
        int[] array2 = {1, 4, 2, 40, 23, 90,56};
        SortUtil.printArray(array2);
        Sort binaryInsertSort = new BinaryInsertSort();
        binaryInsertSort.sort(array2);
        SortUtil.printArray(array2);

        System.out.println("============= Shell Insert Sort ===============");
        int[] array3 = {1, 4, 2, 40, 23, 90,56};
        SortUtil.printArray(array3);
        Sort shellSort = new ShellSort();
        shellSort.sort(array3);
        SortUtil.printArray(array3);
    }
}
