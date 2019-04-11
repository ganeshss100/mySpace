package rough;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by gsrinivasagam on 4/12/2018.
 */
public class SimpleThreadpool {
    private static AtomicInteger poolCount = new AtomicInteger(0);
    private ConcurrentLinkedQueue<Runnable> runnables;
    private List<SimpleThreadpoolThread> threads;


    public static void main(String[] args) {
        SimpleThreadpool s1 = SimpleThreadpool.getInstance(4);
        //s1.execute();
    }

    private class SimpleThreadpoolThread extends Thread {
        private ConcurrentLinkedQueue<Runnable> runnables;

        public SimpleThreadpoolThread(String name, ConcurrentLinkedQueue<Runnable> runnables) {
            super(name);
            this.runnables = runnables;
        }

        @Override
        public void run() {
            try {
                while (!runnables.isEmpty()) {
                    Runnable runnable;
                    while ((runnable = runnables.poll()) != null) {
                        runnable.run();
                    }
                }
            } catch (Exception e) {
            }
        }
    }

    private SimpleThreadpool(int threadCount) {
        poolCount.incrementAndGet();
        this.runnables = new ConcurrentLinkedQueue<>();
        this.threads = new ArrayList<>();
        for (int threadIndex = 0; threadIndex < threadCount; threadIndex++) {
            SimpleThreadpoolThread thread = new SimpleThreadpoolThread("SimpleThreadpool" + poolCount.get() + "Thread" + threadIndex, this.runnables);
            thread.start();
            this.threads.add(thread);
        }
    }

    public static SimpleThreadpool getInstance() {
        return getInstance(Runtime.getRuntime().availableProcessors());
    }

    public static SimpleThreadpool getInstance(int threadCount) {
        return new SimpleThreadpool(threadCount);
    }

    public void execute(Runnable runnable) {
            runnables.add(runnable);
    }
}
