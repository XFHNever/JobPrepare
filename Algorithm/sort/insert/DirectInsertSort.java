package Algorithm.sort.insert;

import Algorithm.sort.Sort;

/**
 * Created by never on 2014/9/3.
 *
 * ��һ��Ԫ�ز��뵽������õ�������У��Ӷ��õ�һ���µġ���¼����1�������
 *
 * ʱ�临�Ӷȣ����ţ����򣩣�n-1�������򣩣�n��n-1��/2
 *
 * �ռ临�Ӷȣ����ţ����򣩣�0�������򣩣�  ��n+4)��n-1��/2
 *
 * �ȶ��ģ��ʺϻ��������С������
 */
public class DirectInsertSort implements Sort {
    @Override
    public void sort(int[] array) {
        int length = array.length;

        for (int i = 0; i < length; i++) {
            int tem = array[i];

            for (int j = i; j > 0; j--) {
                if (tem < array[j-1]) {
                    array[j] = array[j-1];
                } else {
                    array[j] = tem;
                    break;
                }
            }
        }
    }

    public void insertSort(int[] array){
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i-1]) {
                int j = i-1;
                int tem = array[i];
                while (j>0 && tem < array[j]) {
                    array[j+1] = array[j];
                    j--;
                }
                array[j+1] = tem;
            }
        }
    }
}
