package cmdsort;

/**
 * @author: chenyutao
 * @date: 2021/11/5 8:19 下午
 */
public class Test02 {
    public static void main(String[] args) {
        Student student = new Student();
        student.study();
    }

    static class Student {
        public Student() {
        }

        public void study() {
            System.out.println(System.currentTimeMillis());
            myCall();
            System.out.println(System.currentTimeMillis());
        }

        public void myCall() {
            int aaaaaaaa = 0;
            int bbbbbbbb = aaaaaaaa + 1;
            int cccccc = bbbbbbbb + aaaaaaaa;
            System.out.println(cccccc);
        }
    }


}
