package com.antiy.demo.nio.file;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author ygh
 * @Description
 * @Date 2019/11/22
 */
public class Test1 {
    public static void main(String[] args) throws IOException {
        // 获取文件来源 和 输出地址
        // RandomAccessFile inputStream = new RandomAccessFile("D://1.txt","rw");
        // RandomAccessFile outputStream = new RandomAccessFile("D://3.txt","rw");
        FileInputStream inputStream = new FileInputStream("D://1.txt");
        FileOutputStream outputStream = new FileOutputStream("D://2.txt");

        // 获取文件通道
        FileChannel fileChannel = inputStream.getChannel();
        FileChannel outChannel = outputStream.getChannel();

        // 建立缓存区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byteBuffer.put("你好".getBytes());
        // 读取数据到缓存区(可能未读完，假设数据大于缓存区)
        fileChannel.read(byteBuffer);

        // 切换模式
        byteBuffer.flip();

        // 将缓存区数据输出到文件
        outChannel.write(byteBuffer);


        // 清理缓存区数据
        byteBuffer.clear();

        // 切换模式
        byteBuffer.flip();

        // 将缓存区数据输出到文件
        outChannel.write(byteBuffer);

    }
}
