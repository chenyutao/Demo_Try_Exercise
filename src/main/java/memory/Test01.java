package memory;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * @author: chenyutao
 * @date: 2021/11/5 11:43 上午
 */
public class Test01 {

    public static void main(String[] args) {
        System.out.println("------start-----");
        useMuchMemory();
        System.out.println("------end-----");
    }

    public static void useMuchMemory(){
        System.out.println("--before--");
//        byte[] _2M = new byte[10 * 1024 * 1024];
        for (int i = 0; i < 1000; i++) {
            try{
                Thread.sleep(1000* 10);
            }catch (Exception e){

            }
        }
        System.out.println("--after--");
    }

    @Test
    public void test() {
        BigDecimal bigDecimal1 = new BigDecimal(10.50);
        BigDecimal bigDecimal2 = new BigDecimal("10.5");
        System.out.println(Objects.equals(bigDecimal1,bigDecimal2));
        System.out.println(bigDecimal1.equals(bigDecimal2));
    }

}
