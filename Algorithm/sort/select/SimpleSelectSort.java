package Algorithm.sort.select;

import Algorithm.sort.Sort;
import Algorithm.sort.SortUtil;

/**
 * Created by never on 2014/9/4.
 *
 * ��Ҫ�����һ�����У�ѡ����С��������󣩵�һ�������1��λ�õ���������Ȼ����ʣ�µ�������������С��������󣩵����2��λ�õ���������
 * �������ƣ�ֱ����n-1��Ԫ�أ������ڶ��������͵�n��Ԫ�أ����һ�������Ƚ�Ϊֹ��
 *
 * ʱ�临�Ӷȣ����ʼ�����޹أ� n(n-1)/2
 *
 * �ռ临�Ӷȣ���ã����򣩣�0�� �� 3��n-1��
 *
 * ���ȶ����ʺ�Ԫ�ع�ģ�ܴ󣬵����������С�����С�����Ϊ�ƶ��ɱ��ȱȽϳɱ��ߣ�
 */
public class SimpleSelectSort implements Sort {
    @Override
    public void sort(int[] array) {
        int length = array.length;
        for (int i = 0; i < length; i++) {
           int k = i;
           for (int j = i; j < length; j++) {
               if (array[j] < array[k]) {
                   k = j;
               }
           }
           if (k != i) {
               SortUtil.swap(array, k , i);
           }
        }
    }
}
