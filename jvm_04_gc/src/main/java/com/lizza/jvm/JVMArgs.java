package com.lizza.jvm;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * -Xms1350m                            -- 堆初始容量
 * -Xmx1350m                            -- 堆最大容量
 * -Xmn450m                             -- 新生代
 * -XX:MetaspaceSize=450m               -- 元空间初始容量
 * -XX:MaxMetaspaceSize=450m            -- 元空间最大容量
 */
public class JVMArgs {

    public static void main(String[] args){
        while (true) {
            System.out.println(LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:SS")));
            try { Thread.sleep(1000); } catch (Exception e) {}
        }
    }
}
