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
            if(s[i]==s[n]) return false;//不在同一行
            if(Math.abs(s[n]-s[i])==n-i) return false;//不在同一斜线上
        }

        return true;
    }

    private void printThis() {
        System.out.println("第"+suc+"种放法"+"皇后分别放在以下列的以下行：");
        for(int i=0;i<count;i++){
            System.out.println("第"+i+"列的第"+s[i]+"行");
        }
    }

    public static void main(String[] args){
        EightQueue bdq=new EightQueue(8);
        bdq.queue(0);
    }
}
