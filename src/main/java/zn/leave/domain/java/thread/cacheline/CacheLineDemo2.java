package zn.leave.domain.java.thread.cacheline;

/**
 *
 * 缓存行对齐
 * @author ning
 * @date 2020/11/13
 */
public class CacheLineDemo2 {

    public static class Padding {
        //缓存行对齐填充
        public volatile static long p1, p2, p3, p4, p5, p6, p7;
    }

    public static class T extends Padding {
        public volatile static long x = 0L;
    }


    public static T[] arr = new T[2];

    static {

        arr[0] = new T();
        arr[1] = new T();

    }

    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        demo();
        long end = System.currentTimeMillis();
        while (Thread.activeCount() > 2) {
        }

        System.out.println("cost : " + (end - start));
    }


    public static void demo() {

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000_0000; i++) {
                arr[0].x = i;
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000_0000; i++) {
                arr[1].x = i;
            }
        });
        t1.start();
        t2.start();
    }

}
