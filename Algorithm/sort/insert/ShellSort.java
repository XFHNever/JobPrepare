package Algorithm.sort.insert;

import Algorithm.sort.Sort;

/**
 * Created by never on 2014/9/3.
 *
 * �Ƚ�����������ļ�¼���зָ��Ϊ���������зֱ����ֱ�Ӳ������򣬴����������еļ�¼����������ʱ���ٶ�ȫ���¼��������ֱ�Ӳ�������
 *
 * ʱ�ո��ӶȱȽ��Ѽ��㡣ʱ�临�Ӷȣ�O��nlog2n����O��n2����ƽ��nlog2n
 *
 * ���ȶ���Shell�����ð�������5�����Ȳ���������¿�2����Shell�������QuickSort��MergeSort��HeapSort���ܶࡣ
 * ��������ԱȽϼ򵥣����ʺ�����������5000���²����ٶȲ������ر���Ҫ�ĳ��ϡ���������������С�������ظ������Ƿǳ��õġ�
 */
public class ShellSort implements Sort {
    @Override
    public void sort(int[] array) {
        int length = array.length;
        int gap = length;
        int tem;
        int j;

        do {
            gap = gap/3 + 1;
            for (int i = gap; i < length; i++) {
                if (array[i] < array[i - gap]) {
                    tem = array[i];
                    j = i - gap;
                    do {
                        array[j + gap] = array[j];
                        j = j - gap;
                    }while (j >= 0 && tem < array[j]);

                    array[j + gap] = tem;
                }
            }
        }while (gap > 1);


    }
}
