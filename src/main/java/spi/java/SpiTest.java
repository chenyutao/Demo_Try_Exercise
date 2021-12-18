package spi.java;

import org.junit.Test;

import java.util.ServiceLoader;

/**
 * @author: chenyutao
 * @date: 2021/12/13 11:35 上午
 */
public class SpiTest {

    public static void main(String[] args) {
        /**
         * 寻找 'PREFIX' 目录的接口，
         * ```static final String PREFIX = "META-INF/services/";```
         */
        ServiceLoader<Robot> serviceLoader = ServiceLoader.load(Robot.class);
        System.out.println("Java SPI");
        serviceLoader.forEach(Robot::sayHi);
    }

    @Test
    public void test() {
        ServiceLoader<Robot> serviceLoader = ServiceLoader.load(Robot.class);
        System.out.println("Java SPI");
        serviceLoader.forEach((api)->{api.leanSpeak("你好哇~");});
    }

}
