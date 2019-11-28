package com.antiy.demo.java8.base64;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.UUID;

/**
 * @Author ygh
 * @Description
 * 简单类型(simple) : 编码字符只包含 A-Za-z0-9+/ 等 64 个字符。且编码的时候不会包含任何换行符 ( \r 、 \n 、\r\n ）。解码的时候也只会解码 A-Za-z0-9+/ 内的字符，超出的则会被拒绝。
 * URL : 编码字符只包含 A-Za-z0-9+_ 等 64 个字符。和 简单 相比，就是把 / 换成了 _ 。因为没有 / 字符，因此这种编码方式非常适合 URL 和文件名等。
 * MIME : 编码会被映射为 MIME 友好格式：每一行输出不超过 76 个字符，而且每行以 \r\n 符结束。但末尾行并不会包含 \r\n
 * @Date 2019/11/26
 */
public class Base64T1 {
    public static void main(String[] args) {
        f1();

        f2();

        f3();

        f4();
    }

    /**
     * 功能描述 : 基本的编码解码器
     * @author ygh
     * @date 13:44
     */
    private static void f1(){
        try {
            String base64encodedString = Base64.getEncoder().encodeToString(
                    "C:\\Users\\yinguohui\\Desktop".getBytes("utf-8"));
            // 编码
            System.out.println(base64encodedString);

            System.out.println();

            // 解码
            byte[] base64decodedBytes = Base64.getDecoder().decode(base64encodedString);

            System.out.println(new String(base64decodedBytes, "utf-8"));

        } catch(UnsupportedEncodingException e) {
            System.out.println("异常：" + e.getMessage());
        }
    }


    /**
     * 功能描述 :  URL 和文件名安全的编码解码器
     * @author ygh
     * @date 13:44
     */
    private static void f2(){
        try {
            String base64encodedString = Base64.getUrlEncoder().encodeToString(
                    "Java 8 Base64 编码解码 - Java8新特性 - 简单教程 ".getBytes("utf-8"));
            System.out.println(base64encodedString);

            System.out.println();

            byte[] base64decodedBytes = Base64.getUrlDecoder().decode(base64encodedString);

            System.out.println(new String(base64decodedBytes, "utf-8"));

        } catch(UnsupportedEncodingException e) {
            System.out.println("异常：" + e.getMessage());
        }
    }

    /**
     * 功能描述 : MIME Base64 编码解码器
     * @author ygh
     * @date 13:43
     */
    private static void f3(){
        try {

            StringBuilder stringBuilder = new StringBuilder();

            for (int i = 0; i < 10; ++i) {
                stringBuilder.append(UUID.randomUUID().toString());
            }

            byte[] mimeBytes = stringBuilder.toString().getBytes("utf-8");
            String mimeEncodedString = Base64.getMimeEncoder().encodeToString(mimeBytes);
            System.out.println(mimeEncodedString);
            System.out.println();

            byte[] base64decodedBytes = Base64.getMimeDecoder().decode(mimeEncodedString);

            System.out.println(new String(base64decodedBytes, "utf-8"));

        } catch(UnsupportedEncodingException e) {
            System.out.println("异常：" + e.getMessage());
        }
    }

   /**
    * 功能描述 : MIME Base64 编码解码器
    * @author ygh
    * @date 13:43
    */
    private static void f4(){
        try {

            StringBuilder stringBuilder = new StringBuilder();

            for (int i = 0; i < 10; ++i) {
                stringBuilder.append(UUID.randomUUID().toString());
            }

            byte[] mimeBytes = stringBuilder.toString().getBytes("utf-8");
            String mimeEncodedString = Base64.getMimeEncoder(32,"@~@\n\n".getBytes("utf-8")).encodeToString(mimeBytes);
            System.out.println(mimeEncodedString);
            System.out.println();

            byte[] base64decodedBytes = Base64.getMimeDecoder().decode(mimeEncodedString);

            System.out.println(new String(base64decodedBytes, "utf-8"));

        } catch(UnsupportedEncodingException e) {
            System.out.println("异常：" + e.getMessage());
        }
    }
}
