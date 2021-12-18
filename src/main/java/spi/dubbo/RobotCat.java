package spi.dubbo;

/**
 * @author: chenyutao
 * @date: 2021/12/13 11:02 上午
 */
public class RobotCat implements Robot {
    @Override
    public void sayHi() {
        System.out.println("cat: Mi~ao~");
    }

    @Override
    public void leanSpeak(String word) {
        System.out.println("cat: "+ word+" 喵~");
    }
}
