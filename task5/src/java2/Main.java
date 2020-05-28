package java2;

public class Main {
    static final int size = 10000000;
    static final int h = size / 2;

    public static void main(String[] args) {
        arrayFill();
        arrayFillParallel();
    }

    public static void arrayFill() {
        float[] arr = new float[size];

        long start = System.currentTimeMillis();

        for (int i = 0; i < size; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        long finish = System.currentTimeMillis();

        System.out.println("[Non-Parallel] Array fill took " + (finish - start) + "ms");
    }

    public static void arrayFillParallel() {
        float[] arr = new float[size];

        long start = System.currentTimeMillis();
        try {
            Thread t1 = new Thread(() -> {
                float[] filledArr = fillPartial(arr, 0, arr.length / 2);
                long st = System.currentTimeMillis();
                synchronized (arr) {
                    System.arraycopy(filledArr, 0, arr, 0, arr.length / 2);
                }
                long fin = System.currentTimeMillis();
                System.out.println("[Parallel] 1/2 copy back took " + (fin - st) + "ms");
            });
            t1.start();
            Thread t2 = new Thread(() -> {
                float[] filledArr = fillPartial(arr, arr.length / 2, arr.length - 1);
                long st = System.currentTimeMillis();
                synchronized (arr) {
                    System.arraycopy(filledArr, 0, arr, arr.length / 2, arr.length / 2 - 1);
                }
                long fin = System.currentTimeMillis();
                System.out.println("[Parallel] 1/2 copy back took " + (fin - st) + "ms");
            });
            t2.start();

            t1.join();
            t2.join();

            long finish = System.currentTimeMillis();
            System.out.println("[Parallel] Array fill took " + (finish - start) + "ms");
        } catch(InterruptedException e) {
            System.out.println(e);
        }
    }

    public static float[] fillPartial(float[] arr, int startIdx, int endIdx) {
        float[] toFill = new float[endIdx - startIdx];

        long start = System.currentTimeMillis();

        System.arraycopy(arr, startIdx, toFill, 0, endIdx - startIdx);

        long finish = System.currentTimeMillis();
        System.out.println("[Parallel] 1/2 copy took " + (finish - start) + "ms");

        start = System.currentTimeMillis();
        for (int i = 0; i < toFill.length; i++) {
            toFill[i] = (float)(toFill[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        finish = System.currentTimeMillis();
        System.out.println("[Parallel] Partial fill took " + (finish - start) + "ms");

        return toFill;
    }

}
