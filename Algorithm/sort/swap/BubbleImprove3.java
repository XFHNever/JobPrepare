package Algorithm.sort.swap;

import Algorithm.sort.Sort;

/**
 * Created by never on 2014/9/1.
 *
 * ��Bubble sort�ĸĽ�--˫��ɨ�衣����������н���ı�ɨ�跽��.���ȴ���ɨ���ϣ��ٴ���ɨ���£����صؽ���ɨ�裬�����͵õ�˫��ð�������㷨
 *
 *���ţ�����;n-1��0��
 *
 * �����򣩣�����[n/2]������
 * ���ֻ�����ص������������棨��������������������棩�������������ʱ���ֻ��Ҫ�Ƚ�1�ˡ��������������£��㷨�ĸ��Ӷ�ҲΪO(n^2)��
 *
 */
public class BubbleImprove3 implements Sort {
    @Override
    public void sort(int[] array) {
        int low = 0,
            length = array.length,
            up = length -1,
            i, k;
        while (up > low) {
            for (i = k = low; i < up; i++) {
                if (array[i] > array[i+1]) {
                    int tem = array[i];
                    array[i] = array[i+1];
                    array[i+1] = tem;
                    k = i;
                }
            }

            up = k;

            for (i = k = up; i > low; i--) {
                if (array[i] < array[i-1]) {
                    int tem = array[i];
                    array[i] = array[i-1];
                    array[i-1] = tem;
                    k = i-1;
                }
            }

            low = k;
        }


    }
}
