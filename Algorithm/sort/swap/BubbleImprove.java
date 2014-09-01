package Algorithm.sort.swap;

import Algorithm.sort.Sort;

/**
 * Created by never on 2014/8/31.
 *
 * ��Bubble sort�ĸĽ�--ʹ�ñ�־λexchangge����Ƿ�������ͽ�������exchange=false�������Ѿ��ź��򣬿�����ֹð�ݡ�
 *
 * ������ź���ģ�ֻ��Ҫһ��ð�ݣ���õ��������Ҫn-1�αȽϺ�0�ν�����
 * �������£���Լ��Ҫn(n-1)/2�αȽϺ�3n(n-1)/2����������
 *
 */
public class BubbleImprove implements Sort{
    @Override
    public void sort(int[] array) {
        boolean exchange = false;
        int length = array.length;

        for (int i = 0; i < length; i++) {
            exchange = false;
            for (int j = i; j < length - 1; j++) {
                if (array[j] > array[j+1]) {
                    int tem = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tem;
                    exchange = true;
                }
            }

            if (!exchange) {
                 return;
            }
        }
    }
}
