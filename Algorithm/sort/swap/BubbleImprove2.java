package Algorithm.sort.swap;

import Algorithm.sort.Sort;

/**
 * Created by never on 2014/9/1.
 *
 * ��Bubble sort�ĸĽ�--��¼����ÿ��ð�����һ�ν���������λ��lastExchangeIndex����Ϊ֮������ݶ�������ġ�
 *
 * ������������: �ȽϺͼ�¼�ƶ��Ĵ����ֱ�ﵽ��Сֵn-�0�21��0
 *
 * ���������򣩣� �Ƚϴ�����Cmax=�0�2n(n-1)/2; �ƶ������0�2Mmax=3n(n-1)/2�0�2
 */
public class BubbleImprove2 implements Sort {
    @Override
    public void sort(int[] array) {
        int lastExchangeIndex;
        int length = array.length;
        int i = length - 1;
        while (i > 0) {
            lastExchangeIndex = 0;
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j+1]) {
                    int tem = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tem;
                    lastExchangeIndex = j;
                }
            }
            i = lastExchangeIndex;
        }
    }
}
