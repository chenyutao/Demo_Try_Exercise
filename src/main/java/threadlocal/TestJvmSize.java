package threadlocal;

/**
 * @author: chenyutao
 * @date: 2021/10/25 5:59 下午
 */
public class TestJvmSize {

    public static void main(String[] args) throws Exception {
        byte[] _2M = new byte[10 * 1024 * 1024];
        System.out.println("------before gc-----");
        System.gc();
        System.out.println("------allocation_2M:0x00000000" + _2M.length);
//        System.out.println("allocation_2M:0x00000000" + Long.toHexString(addressOf(_2M)));
    }
//
//    private static Unsafe unsafe;
//    static {
//        try {
//            Field field = Unsafe.class.getDeclaredField("theUnsafe");
//            field.setAccessible(true);
//            unsafe = (Unsafe) field.get(null);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//    public static long addressOf(Object o) throws Exception {
//        Object[] array = new Object[] { o };
//        long baseOffset = unsafe.arrayBaseOffset(Object[].class);
//        int addressSize = unsafe.addressSize();
//        long objectAddress;
//        switch (addressSize) {
//            case 4:
//                objectAddress = unsafe.getInt(array, baseOffset);
//                break;
//            case 8:
//                objectAddress = unsafe.getLong(array, baseOffset);
//                break;
//            default:
//                throw new Error("unsupported address size: " + addressSize);
//        }
//        return (objectAddress);
//    }
}
