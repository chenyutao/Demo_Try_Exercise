package spi.dubbo;

/**
 * @author: chenyutao
 * @date: 2021/12/13 11:02 上午
 */
public class RobotDog implements Robot {
    @Override
    public void sayHi() {
        System.out.println("dog: Wo~");
    }


    @Override
    public void leanSpeak(String word) {
        System.out.println("dog: "+ word+" , 汪~");
    }
}
