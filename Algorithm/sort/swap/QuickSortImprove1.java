package Algorithm.sort.swap;

import Algorithm.sort.Sort;
import Algorithm.sort.SortUtil;

/**
 * Created by never on 2014/9/3.
 *
 * 快排是一个效率很高的排序算法，但是对于长度很小的序列，其性能远不如一些简单的排序算法快。序列长度M值为5~25时，直接插入排序比快排至少快10%。
 * 所以我们可以在递归调用过程中，当子序列规模小于预先确定的M时，程序调用直接插入排序进行排序。
 *
 * 另一种改进是在划分时，不对小规模序列排序而掉过，这样得到一个整体上基本排好序的序列，然后再采用直接插入排序。
 */
public class QuickSortImprove1 implements Sort {
    @Override
    public void sort(int[] array) {
        quicksort(array, 0 , array.length-1);
    }

    public void quicksort(int[] array, int low, int high) {
        if (high - low <= 5) {
            insert(array, low, high);
        } else {
            int partition = partition(array, low, high);
            quicksort(array, low, partition - 1);
            quicksort(array, partition + 1, high);
        }
    }

    public int partition(int[] array, int low, int high) {
        int pivot = array[low];

        while (low < high) {
            while (low < high && array[high] > pivot) {
                high--;
            }

            SortUtil.swap(array, low, high);

            while (low < high && array[low] < pivot) {
                low++;
            }

            SortUtil.swap(array, low, high);
        }

        return low;
    }

    public void insert(int[] array, int low, int high) {

    }
}
