package com.antiy.demo;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeReader;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;

/**
 * @Author ygh
 * @Description
 * @Date 2019/11/26
 */
public class Test {

    public static void main(String[] args) throws NullPointerException, URISyntaxException, IOException, FormatException, ChecksumException, NotFoundException {
//        URI uri = new URI("http://10.240.50.105");
////        System.out.println("URI      : " + uri);
////        System.out.println(uri.isAbsolute());
//        Runtime run = Runtime.getRuntime();
//        String path = "C:\\Users\\yinguohui\\AppData\\Roaming\\TP4A\\Teleport-Assist\\tools\\putty\\putty.exe";
        //putty.exe -ssh -l 用户名 -pw 密码 -P 22   主机ip
//        Process process = run.exec("cmd.exe /k start " + path);
        String path = "C:\\Users\\yinguohui\\Desktop\\1.png";
        File file = new File(path);
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(ImageIO.read(file))));

        HashMap hints = new HashMap();
        //设置字符集
        hints.put(DecodeHintType.CHARACTER_SET, "utf-8");

        //获取二维码的内容
        String result = new QRCodeReader().decode(bitmap, hints).getText();
        System.out.println(result);
    }
}
