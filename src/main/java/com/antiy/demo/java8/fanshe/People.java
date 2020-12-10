package com.antiy.demo.java8.fanshe;

/**
 * @Author ygh
 * @Description 反射实体类
 * @Date 2020/11/23
 */
public class People {
    private String name;
    private Integer age;

    private String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    private void show(){
        System.out.println("这是本人");
    }
}
