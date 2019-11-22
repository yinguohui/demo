package com.antiy.demo.nio.bio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author ygh
 * @Description
 * @Date 2019/11/21
 */
public class BioThreadPoolServerTest {
    //默认的端口号
    private static int DEFAULT_PORT = 8083;
    //线程池 懒汉式的单例
    private static ExecutorService executorService = Executors.newFixedThreadPool(60);

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            System.out.println("监听来自于"+DEFAULT_PORT+"的端口信息");
            serverSocket = new ServerSocket(DEFAULT_PORT);
            while(true) {
                Socket socket = serverSocket.accept();
                //当然业务处理过程可以交给一个线程（这里可以使用线程池）,并且线程的创建是很耗资源的。
                //最终改变不了.accept()只能一个一个接受socket的情况,并且被阻塞的情况
                SocketServerThread socketServerThreadPool = new SocketServerThread(socket);
                executorService.execute(socketServerThreadPool);
            }
        } catch(Exception e) {

        } finally {
            if(serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

        //这个wait不涉及到具体的实验逻辑，只是为了保证守护线程在启动所有线程后，进入等待状态
        synchronized (BioThreadPoolServerTest.class) {
            try {
                BioThreadPoolServerTest.class.wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
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
