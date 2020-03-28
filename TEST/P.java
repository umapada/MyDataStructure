package TEST;

import java.util.concurrent.*;

public class P {

    public static void main(String[] args) {

        int m[][] = {{1,2,3,4},{20,30,40,50},{2,3,4,5}};

        BlockingQueue<Integer> bq = new ArrayBlockingQueue<>(10);
        Producer p = new Producer(bq);



    }
}

class Producer implements Runnable{
    int element = 0;
    BlockingQueue<Integer> bq = null;
    Producer(BlockingQueue<Integer> bq){
        this.bq = bq;
    }

    @Override
    public void run() {
        while (true) {
            bq.add(element++);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

