package com.antiy.demo.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author ygh
 * @Description
 * @Date 2019/11/15
 */
public class Test2 {
    public static void main(String[] args) throws IOException {
        RandomAccessFile file = new RandomAccessFile("C:\\Users\\yinguohui\\Desktop\\vul.sql", "rw");
        RandomAccessFile file1 = new RandomAccessFile("C:\\Users\\yinguohui\\Desktop\\vul1.sql", "rw");
        FileChannel inChannel = file.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(5);
        ByteBuffer byteBuffer1 = ByteBuffer.allocate(10);
        ByteBuffer[] arr = {byteBuffer, byteBuffer1};
        inChannel.read(arr);
        byteBuffer.flip();
        byteBuffer1.flip();
        FileChannel inChannel1 = file.getChannel();
        inChannel1.write(arr);
    }
}
