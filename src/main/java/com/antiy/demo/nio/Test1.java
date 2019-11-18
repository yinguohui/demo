package com.antiy.demo.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author ygh
 * @Description
 * @Date 2019/11/15
 */
public class Test1 {
    public static void main(String[] args) throws IOException {
        RandomAccessFile file = new RandomAccessFile("C:\\Users\\yinguohui\\Desktop\\vul.sql","rw");
        RandomAccessFile file1 = new RandomAccessFile("C:\\Users\\yinguohui\\Desktop\\vul1.sql","rw");
        FileChannel inChannel = file.getChannel();
        System.out.println(inChannel.size());
        FileChannel in = file1.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        byteBuffer.put((byte) 'c');
        int bytesRead = inChannel.read(byteBuffer);
        while (bytesRead != -1){
            byteBuffer.flip();
            while (byteBuffer.hasRemaining()){
                System.out.print((char) byteBuffer.get());
            }
            byteBuffer.clear();
            bytesRead = inChannel.read(byteBuffer);
        }
        int read = in.write(byteBuffer);
        file.close();
    }
}
