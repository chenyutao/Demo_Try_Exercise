package cmdsort;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.Test;

import java.net.URL;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: chenyutao
 * @date: 2021/11/5 8:19 下午
 */
public class Test01 {
    public static void main(String[] args) throws Exception{
        AtomicInteger count = new AtomicInteger(0);
       while (true){
           try{
               myCall();
           }catch (Exception e){
               System.out.println("---err---");
           }
           int val = count.incrementAndGet();
           if(val% 100==0){
               System.out.println("----  "+val+"    -----");
           }
       }
    }

    public static void myCall() throws Exception {
        System.out.println(System.currentTimeMillis());
        OkHttpClient httpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .get()
                .url(new URL("https://www.baidu.com"))
                .build();
        Call call = httpClient.newCall(request);
        Response response = call.execute();
        System.out.println(response.body());
        System.out.println(System.currentTimeMillis());
    }

}
