package com.antiy.demo.nio.bio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author ygh
 * @Description
 * @Date 2019/11/20
 */
public class BioThreadServerTest {
    private static int DEFAULT_PORT = 8083;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        System.out.println("监听来自端口" + DEFAULT_PORT + "的请求");
        try {
            serverSocket = new ServerSocket(DEFAULT_PORT);
            while (true) {
                Socket socket = serverSocket.accept();
                SocketServerThread thread = new SocketServerThread(socket);
                new Thread(thread).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class SocketServerThread implements Runnable {
        private Socket socket;

        public SocketServerThread(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            InputStream in = null;
            OutputStream out = null;
            // 获取Socket的信息
            try {
                in = socket.getInputStream();
                out = socket.getOutputStream();
                int port = socket.getPort();
                System.out.println("接受来自端口" + port + "的新信息");
                byte[] receive = new byte[1024];
                int read = in.read(receive, 0, 1024);
                String newString = new String(receive, 0, 1024);
                System.out.println("数据内容:" + newString.trim());
                // 向服务器发送数据
                out.write("发送数据：".getBytes());
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                // 关闭流
                try {
                    if (in != null) {
                        in.close();
                    }
                    if (out != null) {
                        out.close();
                    }
                    if (socket != null) {
                        socket.close();
                    }
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
