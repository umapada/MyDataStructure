import java.util.Arrays;
import java.util.concurrent.*;

public class P {

  //  Queue<Integer> bq = new LinkedBlockingDeque<>();



    public static void main(String[] args) {



        int m[][] = {{1,2,3,4},{20,30,40,50},{2,3,4,5}};


        Arrays.stream(m[1]).forEach(System.out::println);

        //System.out.println(m[0]);


//        BlockingQueue<Integer> bq = new ArrayBlockingQueue<>(10);
//        Producer p = new Producer(bq);
//
//        Consumer c = new Consumer(bq);
//
//        new Thread(p).start();
//        new Thread(c).start();

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

class Consumer implements Runnable{
    BlockingQueue<Integer> bq = null;

    Consumer(BlockingQueue<Integer> bq){
        this.bq = bq;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println(bq.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}