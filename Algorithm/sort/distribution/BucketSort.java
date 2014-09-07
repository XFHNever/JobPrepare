package Algorithm.sort.distribution;

import Algorithm.sort.Sort;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by soft on 2014/9/6.
 *
 * ����˼�룺�����зֵ�����������Ͱ���ÿ��Ͱ���ٸ��������п�����ʹ�ñ�������㷨�����Եݻط�ʽ����ʹ��Ͱ����������򣩡�
 *
 * ʱ�临�Ӷȣ����ʹ�ÿ��ţ�O(N)+O(M*(N/M)*log(N/M))=O(N+N*(logN-logM))=O(N+N*logN-N*logM)����N=Mʱ��ʱ�临�Ӷ�ΪN��NԪ��������MͰ������
 *
 * �ռ临�Ӷȣ�N+M
 *
 * �ȶ����ʺϷֲ����Ȳ��ظ������ֵ���ܸ�����಻Ҫ̫�����飨��Ҫ��ǰ֪������ֲ������
 */
public class BucketSort implements Sort {
    @Override
    public void sort(int[] array) {
        int length = array.length;

        ArrayList[] lists = new ArrayList[length];

        for (int i = 0; i < length; i++) {
            int temp = (int)Math.floor(length * array[i]/100);
            if (null == lists[temp]) {
                lists[temp] = new ArrayList();
            }
            lists[temp].add(array[i]);
        }

        for (int i = 0; i < length; i++) {
            if (null != lists[i]) {
                insert(lists[i]);
            }
        }

        int count = 0;
        for (int i = 0; i < length; i++) {
            if (null != lists[i]) {
                Iterator iterator = lists[i].iterator();
                while (iterator.hasNext()) {
                    int temp = (Integer) iterator.next();
                    array[count++] = temp;
                }
            }
        }
    }

    public void insert(ArrayList list){
        if(list.size()>1){
            for(int i =1;i<list.size();i++){
                if((Integer)list.get(i)<(Integer)list.get(i-1)){
                    int temp = (Integer) list.get(i);
                    int j = i-1;
                    for(;j>=0&&((Integer)list.get(j)>(Integer)list.get(j+1));j--)
                        list.set(j+1, list.get(j));
                    list.set(j+1, temp);
                }
            }
        }
    }
}
