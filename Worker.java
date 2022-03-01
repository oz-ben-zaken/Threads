import java.util.List;

public class Worker implements Runnable{
    int counter = 0;
    int maxNum = 0;
    int maxCount = 0;
    int procces = 0;
    int current=0;
    Counter status;
    List candidate;

    public Worker(List candidate, Counter status) {
        this.candidate = candidate;
        this.status = status;
    }

    public void run() {
        while (current < 100_001) {
            synchronized (this) {
                current = status.moveCounter();
            }
            procces++;
            for (int j = 1; j <= current; j++)
                if (current % j == 0)
                    this.counter++;

            if (counter > maxCount) {
                maxCount = counter;
                maxNum = current;
            }
            counter = 0;
        }
        synchronized (candidate) {
            candidate.add(new NumAndCount(maxNum, maxCount));
        }
        System.out.println(procces + " calculations done by "+ Thread.currentThread().getName());
    }
}
