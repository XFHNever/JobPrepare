package Algorithm.sort.select;

import Algorithm.sort.Sort;
import Algorithm.sort.SortUtil;

/**
 * Created by never on 2014/9/5.
 *
 * ����˼�룺˼���������������ơ� ���Ƚ�n������Ԫ���������飬�ֱ𰴹ؼ��ֽ��бȽϣ��õ�n��2���Ƚϵ���ʤ��(�ؼ���С��)����Ϊ��һ���ȽϵĽ������������
 * Ȼ�����n��2������Ԫ�����������飬�ֱ𰴹ؼ��ֽ��бȽϣ���������ظ���ֱ��ѡ��һ���ؼ�����С������Ԫ��Ϊֹ��
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
