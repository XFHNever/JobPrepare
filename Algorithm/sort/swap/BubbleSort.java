package Algorithm.sort.swap;

import Algorithm.sort.Sort;

/**
 * Created by never on 2014/8/31.
 *
 * ����˼�룺�����������ݽ��бȽϣ�����������Ҫ��ͽ���λ�á�
 *
 * ʱ�临�Ӷȣ�n^2, �������С����ʼ����˳���޹�
 *
 * �ռ临�Ӷȣ�������˳���йأ�����Ϊ0������Ϊn^2
 *
 * �ȶ��������ʺϳ��Ƚ�С����Ƚϡ�
 */
public class BubbleSort implements Sort {
    @Override
    public void sort(int[] array) {
        int length = array.length;

        for (int i = 0; i < length; i++) {
            for (int j = i; j < length - 1; j++) {
                if (array[j] > array[j+1]) {
                    int tem = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tem;
                }
            }
        }
    }
}
