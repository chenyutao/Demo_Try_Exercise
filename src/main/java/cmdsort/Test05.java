package cmdsort;

/**
 * @author: chenyutao
 * @date: 2021/11/8 5:00 下午
 */
public class Test05 {
    static boolean initialized = false;
    static char[] configText;
    static boolean success = false;

    static volatile long timestamp1;
    static volatile long timestamp2;


    public static void main(String[] args) throws InterruptedException {
        int i = 0;
        while (true) {
            i++;
            Thread one = new Thread(new Runnable() {
                @Override
                public void run() {
                    timestamp1 = System.nanoTime();
                    configText = new char[]{};
                    initialized = true;
                    timestamp2 = System.nanoTime();
                }
            });
            Thread other = new Thread(new Runnable() {
                @Override
                public void run() {
                    if (initialized) {
                        if (configText == null) {
                            System.out.println("----");
                            success = true;
                        } else {
                            configText = null;
                            initialized = false;
                        }
                    }
                }
            });
            one.start();
            other.start();
            one.join();
            other.join();
            char mark;
            if (timestamp1 < timestamp2) {
                mark = 'a';
            } else if (timestamp1 == timestamp2) {
                mark = 'b';
            } else {
                mark = 'c';
            }
            String result = "第" + i + "次 (" + mark + "）";
            if (success) {
                System.err.println(result);
                break;
            } else {
                System.out.println(result);
            }
        }


    }


}
