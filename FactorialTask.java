import java.util.concurrent.Callable;

public class FactorialTask implements Callable<Integer> {
    int number;

    FactorialTask(int n){
        number = n;
    }

    // standard constructors

    public Integer call() throws Exception {
        int fact = 1;
        // ...
        for(int count = number; count > 1; count--) {
            fact = fact * count;
        }

        return fact;
    }


    public static void main(String[] args) throws Exception{
        FactorialTask ft = new FactorialTask(5);
        System.out.println(ft.call());
    }
}
