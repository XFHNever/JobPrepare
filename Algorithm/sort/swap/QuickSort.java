package Algorithm.sort.swap;

import Algorithm.sort.Sort;
import Algorithm.sort.SortUtil;

/**
 * Created by never on 2014/9/1.
 *
 * ����˼�룺 ѡ��һ����׼Ԫ��(ͨ���ǵ�һ���������һ������ͨ��һ���������Ԫ�����л���Ϊ�������������У�������������Ԫ�ض��Ȼ�׼Ԫ��С������
 * �Ȼ�׼��Ȼ���ٷֱ�������н�����������
 *
 * ʱ�临�Ӷȣ� ƽ��nlog2n�� ���������У���ѡȡ��һ��Ϊ��׼��n(n-1)/2;
 *
 * �ռ临�Ӷȣ��ݹ�ģ���Ҫһ��ջ���ÿ��ݹ���õ�ָ��Ͳ�����������ò���log2��n+1�������n-1�εݹ���á�
 *
 * ���ȶ��ģ��ʺ�n�ϴ�ʱ��
 */
public class QuickSort implements Sort {
    @Override
    public void sort(int[] array) {
        quicksort(array, 0 , array.length-1);
    }

    public void quicksort(int[] array, int low, int high) {
        if (low < high) {
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


}
