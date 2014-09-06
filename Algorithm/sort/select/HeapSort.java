package Algorithm.sort.select;

import Algorithm.sort.Sort;
import Algorithm.sort.SortUtil;

/**
 * Created by never on 2014/9/5.
 *
 * 核心思想: 将数据建成最大（小）堆，然后将堆第一个元素heap[0]和heap[n-1]交换，然后调整0~n-2;不断调整交换位置下去就可以。
 *
 * 时间复杂度：设树深度为k，从根到叶的筛选，元素比较次数至多2(k-1)次，交换记录至多k 次。最坏情况下 nlog2n； 建堆时比较次数不超过4n
 *
 * 空间复杂度：附加存储主要在第二个for循环中用来执行元素交换时所用的一个临时元素，所以空间复杂度为1.
 *
 * 不稳定，适合大量数据
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

