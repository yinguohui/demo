package com.antiy.demo.nio.bio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.URLDecoder;
import java.net.UnknownHostException;
import java.util.concurrent.CountDownLatch;

/**
 * @Author ygh
 * @Description
 * @Date 2019/11/20
 */
public class BioThreadClientTest {
    public static void main(String[] args) throws InterruptedException {
        int max = 20;
        CountDownLatch latch = new CountDownLatch(max);
        for (int i = 0; i < max; i++, latch.countDown()) {
            ClientRequestThread requestThread = new ClientRequestThread(latch,i);
            new Thread(requestThread).start();
        }

        // 只是为了保证守护线程在启动所有线程后，进入等待状态
        synchronized (BioThreadClientTest.class){
            BioThreadClientTest.class.wait();
        }
    }

    static class ClientRequestThread implements Runnable {
        private CountDownLatch countDownLatch;

        private int clientId;

        public ClientRequestThread(CountDownLatch countDownLatch, int clientId) {
            this.countDownLatch = countDownLatch;
            this.clientId = clientId;
        }

        @Override
        public void run() {
            Socket socket = null;
            InputStream in = null;
            OutputStream out = null;
            try {
                socket = new Socket("localhost", 8083);
                in = socket.getInputStream();
                out = socket.getOutputStream();
                // 等待所有线程一起发送
                this.countDownLatch.await();
                // 发送消息
                out.write(("这是第" + this.clientId + "客户端的请求").getBytes());
                out.flush();
                // 等待服务器的消息
                int len;
                byte[] receive = new byte[1024];
                String message = "";
                while ((len = in.read(receive, 0, 1024)) != -1) {
                    message = message + new String(receive, 0, 1024).trim();
                }
                message = URLDecoder.decode(message, "UTF-8");
                System.out.println("第" + this.clientId + "客户端收到服务器的信息" + message);
            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
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
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
