package com.lizza;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;

/**
 * 异常处理
 */
public class ByteCode_03 {

    public void test_1() {
        try {
            InputStream is = new FileInputStream("test.txt");
            ServerSocket socket = new ServerSocket(9090);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("finally");
        }
    }
}
