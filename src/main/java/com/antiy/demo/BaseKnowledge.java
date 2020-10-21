package com.antiy.demo;

/**
 * @Author ygh
 * @Description
 * @Date 2019/11/19
 */
public class BaseKnowledge {
    public void main(String[] args) {
        People people = new People();
        people.setAge(11);
        people.setName("aaa");


    }

    public class People implements Cloneable {
        private int age;
        private String name;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
