package com.antiy.demo.jvm.taoyi;

/**
 * @Author ygh
 * @Description
 *
 * -XX:+PrintGC -Xms5M -Xmn5M -XX:+DoEscapeAnalysis
 *
 * -XX:+PrintGC -Xms5M -Xmn5M -XX:-DoEscapeAnalysis
 *
 * 栈上分配测试
 *
 * @Date 2020/10/13
 */
public class EscapeAnalysisTest2 {
    public static void main(String[] args) {
        for (int i = 0; i < 500000000; i++) {
            createObject();
        }
    }

    public static void createObject() {
        new Object();
    }
}
