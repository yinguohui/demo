package com.antiy.demo.nio.chat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @Author ygh
 * @Description
 * @Date 2019/11/15
 */
//写
public class Test1 {
    public static void main(String[] args) throws IOException {
        String newString = "Hello";
        SocketChannel channel = SocketChannel.open();
        //channel.configureBlocking(false);
        channel.connect(new InetSocketAddress("localhost", 11113));
        ByteBuffer byteBuffer = ByteBuffer.allocate(512);
        byteBuffer.put(newString.getBytes());
        byteBuffer.flip();
        int read = channel.write(byteBuffer);
        System.out.println(read);
        channel.close();
    }
}
