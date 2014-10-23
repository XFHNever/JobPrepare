package Algorithm.other;

/**
 * Created by never on 2014/9/16.
 */
public class EightQueue {
    private int s[] = null;
    private int count = 0;
    private int suc;

    private EightQueue(int count) {
        suc = 0;
        this.count = count;
        s = new int[this.count];
        
        for (int i=0; i<this.count; i++) {
            s[i] = -1;
        }

    }
    
    public void queue(int n) {
        if (n == 8) {
            suc++;
            printThis();
            return;
        } else {
            for (int i =0; i<count; i++) {
                s[n]=i;
                if (isCan(n)) {
                    queue(n+1);
                }
            }
        }
    }

    private boolean isCan(int n) {
        for(int i=0;i<n;i++){
            if(s[i]==s[n]) return false;//����ͬһ��
            if(Math.abs(s[n]-s[i])==n-i) return false;//����ͬһб����
        }

        return true;
    }

    private void printThis() {
        System.out.println("��"+suc+"�ַŷ�"+"�ʺ�ֱ���������е������У�");
        for(int i=0;i<count;i++){
            System.out.println("��"+i+"�еĵ�"+s[i]+"��");
        }
    }

    public static void main(String[] args){
        EightQueue bdq=new EightQueue(8);
        bdq.queue(0);
    }
}
