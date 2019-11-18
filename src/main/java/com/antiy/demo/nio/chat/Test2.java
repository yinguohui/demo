package com.antiy.demo.nio.chat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @Author ygh
 * @Description
 * @Date 2019/11/15
 */
// 读
public class Test2 {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel channel = ServerSocketChannel.open();
        channel.configureBlocking(false);
        ServerSocket serverSocket = channel.socket();
        serverSocket.bind(new InetSocketAddress(11113));
        while(true){
            SocketChannel socketChannel =
                    channel.accept();
            if (socketChannel!= null){
                ByteBuffer byteBuffer = ByteBuffer.allocate(512);
                int len = socketChannel.read(byteBuffer);
                //byteBuffer.flip();
                while (byteBuffer.hasRemaining()){
                    String receiveText = new String( byteBuffer.array(),0,len);
                    System.out.println(receiveText);
                }
                System.out.println(len);
            }
        }

    }
}
