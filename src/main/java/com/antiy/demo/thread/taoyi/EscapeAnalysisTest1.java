package com.antiy.demo.thread.taoyi;

/**
 * @author yinguohui
 * <p>
 * JVM 参数为-server -Xmx10m -Xms10m -XX:-DoEscapeAnalysis -XX:+PrintGC, 运行结果 530
 * <p>
 * java默认是开启逃逸分析的
 * <p>
 * JVM 参数为-server -Xmx10m -Xms10m -XX:+DoEscapeAnalysis -XX:+PrintGC, 运行结果 5
 */
public class EscapeAnalysisTest1 {
    public static void alloc() {
        byte[] b = new byte[2];
        b[0] = 1;
    }

    public static void main(String[] args) {
        long b = System.currentTimeMillis();
        for (int i = 0; i < 1000 * 1000 * 10; i++) {
            alloc();
        }
        long e = System.currentTimeMillis();
        System.out.println(e - b);
    }
}