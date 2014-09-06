package Algorithm.sort.select;

import Algorithm.sort.Sort;
import Algorithm.sort.SortUtil;

/**
 * Created by never on 2014/9/5.
 *
 * ����˼��: �����ݽ������С���ѣ�Ȼ�󽫶ѵ�һ��Ԫ��heap[0]��heap[n-1]������Ȼ�����0~n-2;���ϵ�������λ����ȥ�Ϳ��ԡ�
 *
 * ʱ�临�Ӷȣ��������Ϊk���Ӹ���Ҷ��ɸѡ��Ԫ�رȽϴ�������2(k-1)�Σ�������¼����k �Ρ������� nlog2n�� ����ʱ�Ƚϴ���������4n
 *
 * �ռ临�Ӷȣ����Ӵ洢��Ҫ�ڵڶ���forѭ��������ִ��Ԫ�ؽ���ʱ���õ�һ����ʱԪ�أ����Կռ临�Ӷ�Ϊ1.
 *
 * ���ȶ����ʺϴ�������
 *
 */
public class HeapSort implements Sort {
    @Override
    public void sort(int[] array) {
        int length = array.length;
        MaxHeap heap = new MaxHeap(length + 4, array);

        for (int i = (length-2)/2; i >= 0; i--) {
            heap.siftDown(i, length - 1);
        }

        for (int i = length -1; i >= 0; i--) {
            heap.swap(i, 0);
            heap.siftDown(0, i-1);
        }

    }
}
class MaxHeap {
    int[] heap;
    int currentSize;
    int maxSize;

    public MaxHeap(int maxSize, int[] array) {
        this.maxSize = maxSize;
        currentSize = array.length;
        heap = array;
    }

    public void siftDown(int start, int m) {
        int i = start;
        int j = 2*i + 1;
        int tem = heap[i];

        while (j <= m) {
            if (j < m && heap[j] < heap[j+1]) {
                j++;
            }

            if (tem >= heap[j]) {
                break;
            } else {
                heap[i] = heap[j];
                i = j;
                j = 2*j + 1;
            }

        }

        heap[i] = tem;
    }

    public void swap(int i, int j) {
        SortUtil.swap(heap, i, j);
    }
}

