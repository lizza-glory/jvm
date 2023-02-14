package com.lizza.memory;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.util.Map;
import java.util.UUID;

public class MemoryLeakTests {

    /**
     * 模拟 ygc 上升
     -XX:+PrintCommandLineFlags
     -XX:+PrintFlagsFinal
     -XX:+PrintGCDetails
     -XX:+PrintGCTimeStamps
     -XX:+PrintGCApplicationStoppedTime
     -XX:+PrintGCApplicationConcurrentTime
     -XX:+PrintHeapAtGC
     -XX:+HeapDumpOnOutOfMemoryError
     -XX:HeapDumpPath=/Users/lizza/Desktop/
     -Xloggc:/Users/lizza/Desktop/gc.log
     -Xms100m
     -Xmx100m
     -Xmn50m
     -XX:+UseConcMarkSweepGC
     -XX:SurvivorRatio=8
     */
    @Test
    public void test1() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        while (true) {
            Map<String, Boolean> map = mapper.readValue(String.format("{\"%s\":\"true\"}", UUID.randomUUID()),
                            new TypeReference<Map<String, Boolean>>() {});
//            System.out.println(map);
//            try {
//                sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }
}