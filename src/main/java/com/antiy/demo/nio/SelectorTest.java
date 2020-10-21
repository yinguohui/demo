package com.antiy.demo.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @Author ygh
 * @Description
 * @Date 2019/11/20
 */
public class SelectorTest {
    private void selector() throws IOException {
        // 初始化容量大小
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        // 打开选择器
        Selector selector = Selector.open();
        // 打开服务器
        ServerSocketChannel channel = ServerSocketChannel.open();
        // 设置非阻塞
        channel.configureBlocking(false);
        // 绑定端口
        channel.socket().bind(new InetSocketAddress(8080));
        // 服务端口注册监听
        channel.register(selector, SelectionKey.OP_ACCEPT);
        //
        while (true) {
            // 取得所有key的集合
            Set selectedKeys = selector.selectedKeys();
            Iterator it = selectedKeys.iterator();
            while (it.hasNext()) {
                SelectionKey key = (SelectionKey) it.next();
                if ((key.readyOps() & SelectionKey.OP_ACCEPT) == SelectionKey.OP_ACCEPT) {
                    ServerSocketChannel channel1 = (ServerSocketChannel) key.channel();
                    // 接受请求
                    SocketChannel channel2 = channel1.accept();
                    channel2.configureBlocking(false);
                    channel2.register(selector, SelectionKey.OP_READ);
                    it.remove();
                } else if ((key.readyOps() & SelectionKey.OP_READ) == SelectionKey.OP_READ) {
                    SocketChannel channel1 = (SocketChannel) key.channel();
                    while (true) {
                        buffer.clear();
                        int n = channel1.read(buffer);
                        if (n <= 0) {
                            break;
                        }
                        buffer.flip();
                    }
                    it.remove();
                }
            }
        }

    }
}
