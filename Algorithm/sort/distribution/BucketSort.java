package Algorithm.sort.distribution;

import Algorithm.sort.Sort;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by soft on 2014/9/6.
 *
 * 核心思想：将阵列分到有限数量的桶子里。每个桶子再个别排序（有可能再使用别的排序算法或是以递回方式继续使用桶排序进行排序）。
 *
 * 时间复杂度：如果使用快排，O(N)+O(M*(N/M)*log(N/M))=O(N+N*(logN-logM))=O(N+N*logN-N*logM)；当N=M时，时间复杂度为N（N元素数量，M桶数量）
 *
 * 空间复杂度：N+M
 *
 * 稳定，适合分布均匀不重复，最大值和总个数差距不要太大数组（需要提前知道数组分布情况）
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
