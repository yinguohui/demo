package com.antiy.demo.meiju;

/**
 * @Author ygh
 * @Description 向枚举中加入方法
 * @Date 2020/1/9
 */
public enum Color1 {
    RED("红色", 213), BLACK("黑色", 255);

    private String name;
    private int c;

    Color1(String name, int c) {
        this.name = name;
        this.c = c;
    }

    public static String getNameByC(int c) {
        for (Color1 co : Color1.values()) {
            if (co.getC() == c) {
                return co.name;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }
}
