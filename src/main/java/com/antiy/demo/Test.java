package com.antiy.demo;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * @Author ygh
 * @Description
 * @Date 2019/11/26
 */
public class Test {

    public static void main(String[] args) throws NullPointerException, URISyntaxException {
        URI uri = new URI("http://10.240.50.105");
        System.out.println("URI      : " + uri);
        System.out.println(uri.isAbsolute());
    }
}
