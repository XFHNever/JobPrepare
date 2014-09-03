package Algorithm.sort.swap;

import Algorithm.sort.Sort;
import Algorithm.sort.SortUtil;

/**
 * Created by never on 2014/9/3.
 *
 * ȡ��׼Ԫ��pivotʱ���ô�������˵�left���Ҷ˵�right���յ�λ��mid = ��left + right��/2��ȡ�м�ֵ����������rightλ�ã��������ٿ��Ա���������
 */
public class QuickSortImprove2 implements Sort{

    @Override
    public void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    public int median3(int[] array, int left, int right) {
        int mid = (left + right)/2;
        int k = left;
        if (array[mid] < array[k]) {
            k = mid;
        }

        if (array[right] < array[k]) {
            k = right;
        }

        if (k != left) {
            SortUtil.swap(array, k, left);
        }

        if (mid != right && array[mid] < array[right]) {
            SortUtil.swap(array, right, mid);
        }

        return array[right];
    }

    public int partition(int[] array, int left, int right) {
        int pivot = median3(array, left, right);
        int k = right;

        while (left < right) {
            while (left < right && array[left] < pivot) {
                left++;
            }
            while (left < right && array[right] > pivot) {
                right--;
            }

            SortUtil.swap(array, left, right);
            left++;
            right--;
        }
        if (array[left] > pivot) {
            array[k] = array[left];
            array[left] = pivot;
        }

        return  left;
    }

    public void quickSort(int[] array, int left, int right) {
        if (right - left <= 5) {
            insert(array, left, right);
        } else {
            int partition = partition(array, left, right);
            quickSort(array, left, partition - 1);
            quickSort(array, partition + 1, right);
        }
    }

    private void insert(int[] array, int left, int right) {
    }
}
