import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("#########---WITH THREADS---#########");
        var list = new ArrayList<Thread>();
        var candidate = new ArrayList<NumAndCount>();
        var status = new Counter();

        long sTime;
        long tTime;
        for (int i = 0; i < 5; i++)
            list.add(new Thread(new Targil2(candidate,status)));


        sTime = System.currentTimeMillis();
        for (Thread tr: list)
            tr.start();

        for (Thread tr: list) {
            try {
                tr.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        int index=0;

        for(int i=1; i<candidate.size();i++)
        {
            if (candidate.get(i).count > candidate.get(index).count)
                index = i;
        }
        tTime = System.currentTimeMillis() - sTime;
        System.out.println(candidate.get(index));
        System.out.println("Calc finished in "+tTime+"ms");
        System.out.println(candidate);

    }
}
