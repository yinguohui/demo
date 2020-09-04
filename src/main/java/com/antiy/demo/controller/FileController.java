package com.antiy.demo.controller;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @Author ygh
 * @Description
 * @Date 2019/10/16
 */
@Api(tags = "1.1" ,description = "测试文件上传",value = "文件上传")
//@Controller
//@RequestMapping("/a")
public class FileController {
    @GetMapping("/")
    @ResponseBody
    private String index(){
        return "upload";
    }

    public static void main(String[] args) {
        String site = "11111111111";
        System.out.printf("", site);
        String wosi = "wosi";
        String.format("yyyy-mm-ss", "");
        if (wosi != null) {

        }
        List ls = Arrays.asList("11","122");
        for (Object l : ls) {

        }
        for (int i = ls.size() - 1; i >= 0; i--) {

        }
        for (Object l : ls) {

        }
    }

    public String testSql(){

        return "";
    }
}
