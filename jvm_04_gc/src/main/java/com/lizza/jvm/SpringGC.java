package com.lizza.jvm;

import cn.hutool.json.JSONUtil;
import com.lizza.jvm.entity.Param;
import okhttp3.*;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 使用 okhttp 请求接口
 * https://segmentfault.com/a/1190000020171608#item-7
 *
 */
public class SpringGC {

    @Test
    public void test1() throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .get()
                .url("http://localhost:8080/hello")
                .build();
        Response response = client.newCall(request)
                .execute();
        System.out.println(new String(response.body().bytes()));
    }

    @Test
    public void test2() throws Exception {
        OkHttpClient client = new OkHttpClient();
        Param param = Param.builder()
                .name("lizza")
                .age(19).build();
        RequestBody body;
        while (true) {
            Map<String, String> map = new HashMap<>();
            String uuid = UUID.randomUUID().toString();
            map.put(uuid, uuid);
            param.setProps(map);

            body = RequestBody.create(MediaType.parse("application/json;charset=utf-8"), JSONUtil.toJsonStr(param));
            Request request = new Request.Builder()
                    .post(body)
                    .url("http://localhost:8080/handle")
                    .build();
            Response res = client.newCall(request)
                    .execute();
            System.out.println(new String(res.body().bytes()));
            try { Thread.sleep(15); } catch (Exception e) {}
        }
    }
}
