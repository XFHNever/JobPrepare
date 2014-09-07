package Algorithm.sort.select;

import Algorithm.sort.Sort;
import Algorithm.sort.SortUtil;

/**
 * Created by never on 2014/9/5.
 *
 * 核心思想：思想与体育比赛类似。 首先将n个数据元素两两分组，分别按关键字进行比较，得到n／2个比较的优胜者(关键字小者)，作为第一步比较的结果保留下来，
 * 然后对这n／2个数据元素再两两分组，分别按关键字进行比较，…，如此重复，直到选出一个关键字最小的数据元素为止。
 *
 *
 *
 */
public class TournamentSort implements Sort {
    @Override
    public void sort(int[] array) {
        int length = array.length;
        int size = 1;
        while (size < length) {
            size = 2*size;
        }
        size = 2 * size - 1;
        int[] tempArray = new int[size];

        for (int i = size/2; i < size; i++) {
            tempArray[i] = (i-size/2<length) ? array[i-size/2] : Integer.MAX_VALUE;
        }

        for (int i = size/2-1; i >= 0; i--) {
            tempArray[i] = Math.min(tempArray[2*i + 1],tempArray[2*i + 2]);
        }

        for (int i = 0; i < length; i++) {
            array[i] = tempArray[0];
            update(tempArray, 0, size);
        }

    }

    public void  update(int[] array, int start, int end) {
        int left = 2*start + 1;
        int right = left+1;

        if (left >= end) {
            array[start] = Integer.MAX_VALUE;
            return;
        } else if (right >= end) {
            array[start] = array[left];
            return;
        }

        if (array[left] == array[start]) {
            update(array, left, end);
        } else {
            update(array, right, end);
        }

        array[start] = Math.min(array[left], array[right]);

    }
}
