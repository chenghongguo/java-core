import java.util.concurrent.TimeUnit;

/**
 * TestThread
 *
 * @author chenghongguo
 * @date 2020/4/15
 * @since 1.0.0
 */
public class TestThread {
    public static void main(String[] args) throws Exception {
        Thread t = new DemoThread();
        // 启动线程
        t.start();
        System.in.read();
    }

    static class DemoThread extends Thread {

        @Override
        public void run() {
            try {
                TimeUnit.HOURS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
