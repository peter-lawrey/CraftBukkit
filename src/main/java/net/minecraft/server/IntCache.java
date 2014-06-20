package net.minecraft.server;

import java.util.ArrayList;
import java.util.List;

public class IntCache {
    private static final int CS = 8 * 1024;
    private static final int ES = 1024;
    private static int a = 256;
    private static List<int[]> b = new ArrayList();
    private static List<int[]> c = new ArrayList();
    private static List<int[]> d = new ArrayList();
    private static List<int[]> e = new ArrayList();

    public static synchronized int[] a(int paramInt) {
        int[] arrayOfInt;
        if (paramInt <= 256) {
            if (b.isEmpty()) {
                arrayOfInt = new int[256];
                if (c.size() < CS)
                    c.add(arrayOfInt);
                return arrayOfInt;
            }
            arrayOfInt = (int[]) b.remove(b.size() - 1);
            if (c.size() < CS)
                c.add(arrayOfInt);
            return arrayOfInt;
        }
        if (paramInt > a) {
            a = paramInt;

            d.clear();
            e.clear();

            arrayOfInt = new int[a];
            if (e.size() < ES)
                e.add(arrayOfInt);
            return arrayOfInt;
        }
        if (d.isEmpty()) {
            arrayOfInt = new int[a];
            if (e.size() < ES)
                e.add(arrayOfInt);
            return arrayOfInt;
        }
        arrayOfInt = (int[]) d.remove(d.size() - 1);
        if (e.size() < ES)
            e.add(arrayOfInt);
        return arrayOfInt;
    }

    public static synchronized void a() {
        if (!d.isEmpty()) {
            d.remove(d.size() - 1);
        }
        if (!b.isEmpty()) {
            b.remove(b.size() - 1);
        }
        d.addAll(e);
        b.addAll(c);

        e.clear();
        c.clear();
    }

    public static synchronized String b() {
        return "cache: " + d.size() + ", tcache: " + b.size() + ", allocated: " + e.size() + ", tallocated: " + c.size();
    }
}
