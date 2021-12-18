package cmdsort;

/**
 * @author: chenyutao
 * @date: 2021/11/8 5:00 下午
 */
public class Test04 {
    static boolean initialized = false;
    static char[] configText;
    static boolean success = false;

    public static void main(String[] args) throws InterruptedException {
        int i = 0;
        while (true) {
            i++;
            Thread one = new Thread(new Runnable() {
                @Override
                public void run() {
                    configText = new char[]{};
                    initialized = true;
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
            String result = "第" + i + "次 ";
            if (success) {
                System.err.println(result);
                break;
            } else {
                System.out.println(result);
            }
        }


    }


}
