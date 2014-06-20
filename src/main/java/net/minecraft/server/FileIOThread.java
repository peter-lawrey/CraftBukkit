package net.minecraft.server;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileIOThread
        implements Runnable {
    public static final FileIOThread a = new FileIOThread();
    private List b = Collections.synchronizedList(new ArrayList());
    private volatile long c;
    private volatile long d;
    private volatile boolean e;

    private FileIOThread() {
        Thread localThread = new Thread(this, "File IO Thread");
        localThread.setPriority(1);
        localThread.start();
    }

    public void run() {
        for (; ; ) {
            b();
        }
    }

    private void b() {
        for (int i = 0; i < this.b.size(); i++) {
            IAsyncChunkSaver localIAsyncChunkSaver = (IAsyncChunkSaver) this.b.get(i);
            boolean bool = localIAsyncChunkSaver.c();
            if (!bool) {
                this.b.remove(i--);
                this.d++;
            }

            try {
                if (!e) {
                    synchronized (this) {
                        wait(10);
                    }
                }
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }
        if (this.b.isEmpty()) {
            try {
                synchronized (this) {
                    wait(25);
                }
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void a(IAsyncChunkSaver paramIAsyncChunkSaver) {
        if (this.b.contains(paramIAsyncChunkSaver)) {
            return;
        }
        this.c++;
        this.b.add(paramIAsyncChunkSaver);
    }

    public void a() {

        this.e = true;

        int counter = 0;
        while (this.c != this.d) {
            synchronized (this) {
                notify();
            }
            if (counter == 20)
                new Throwable().printStackTrace();
            try {
                if (++counter > 21) counter = 21;
                Thread.sleep(counter);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        }
        this.e = false;
    }
}
