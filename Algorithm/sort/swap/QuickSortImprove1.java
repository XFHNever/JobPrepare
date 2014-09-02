package Algorithm.sort.swap;

import Algorithm.sort.Sort;
import Algorithm.sort.SortUtil;

/**
 * Created by never on 2014/9/3.
 *
 * ������һ��Ч�ʺܸߵ������㷨�����Ƕ��ڳ��Ⱥ�С�����У�������Զ����һЩ�򵥵������㷨�졣���г���MֵΪ5~25ʱ��ֱ�Ӳ�������ȿ������ٿ�10%��
 * �������ǿ����ڵݹ���ù����У��������й�ģС��Ԥ��ȷ����Mʱ���������ֱ�Ӳ��������������
 *
 * ��һ�ָĽ����ڻ���ʱ������С��ģ��������������������õ�һ�������ϻ����ź�������У�Ȼ���ٲ���ֱ�Ӳ�������
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
