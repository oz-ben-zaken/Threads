import java.util.concurrent.atomic.LongAdder;

public class Counter {
    volatile LongAdder current = new LongAdder();

    public synchronized int moveCounter(){
        current.increment();
        return current.intValue();
    }
}
