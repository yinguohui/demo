package com.antiy.demo.lingkou.tree;

/**
 * @Author ygh
 * @Description
 * @Date 2020/9/17
 */
public enum  Test {
    PPT(1, "ppt"),
    WORD(2, "word");
    private int name;
    private String value;


    private Test(int name, String value) {
        this.name = name;
        this.value = value;
    }

    public static Test getById(Integer id) {
        for (Test transactType : values()) {
            if (transactType.getName() == id) {
                //获取指定的枚举
                return transactType;
            }
        }
        return null;


    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static void main(String[] args) {
        switch (Test.getById(1)){
            case PPT:
                System.out.println("1");
                break;
            case WORD:

                break;
        }
    }
}
