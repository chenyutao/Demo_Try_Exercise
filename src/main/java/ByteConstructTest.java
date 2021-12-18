/**
 * @author: chenyutao
 * @date: 2021/12/1 8:56 下午
 */
public class ByteConstructTest {


    public static void main(String[] args) {
        MyByteConstruct myByteConstruct = new MyByteConstruct((byte) 0);
        System.out.println(myByteConstruct.hhh);
        System.out.println(MyByteConstruct.hhh);
    }

    public static class MyByteConstruct{
        public static String hhh ="zxcv";
        byte a;

        public MyByteConstruct(byte a) {
            this.a = a;
        }
    }
}
