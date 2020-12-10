package com.antiy.demo.java8.copy;

import com.antiy.demo.designs.zhongjie.t1.B;

/**
 * @Author ygh
 * @Description 拷贝测试----通过构造函数实现浅拷贝
 * @Date 2020/11/23
 */
public class TestCopy {
    public static void main(String[] args) {
        A a = new A();
        a.setAge(11);
        a.setName("测试");
        B b = new B();
        b.setId("1111");
        a.setB(b);
        A a1 = new A(a);
        System.out.println(a1);
        b.setId("55");
        System.out.println("修改b后："+ a1);


    }

    static class A {
        private Integer age;
        private String  name;
        private B b;
        public A() {
        }

        public A(A a) {
            this.age = a.age;
            this.name = a.name;
            this.b = a.b;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public B getB() {
            return b;
        }

        public void setB(B b) {
            this.b = b;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("A{");
            sb.append("age=").append(age);
            sb.append(", name='").append(name).append('\'');
            sb.append(", b=").append(b);
            sb.append('}');
            return sb.toString();
        }
    }

    static class B {
        private String id;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("B{");
            sb.append("id='").append(id).append('\'');
            sb.append('}');
            return sb.toString();
        }
    }
}
