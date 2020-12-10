package com.antiy.demo.java8.copy;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ygh
 * @Description 测试深拷贝clone
 * @Date 2020/11/23
 */
public class TestDeepCopy {

    public static void main(String[] args) {
        A a = new A();
        a.setAge(11);
        a.setName("55");
        Id id = new Id();
        id.setId("111");
        a.setId(id);
        A a1 = (A) a.clone();
        System.out.println("改造前："+a1);
        id.setId("555");
        System.out.println("改造后："+a1);
        ArrayList arrayList = new ArrayList<String>();
        arrayList.clone();
    }

    static class A implements Cloneable{
        private Integer age;
        private String name;
        private Id id;

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

        public Id getId() {
            return id;
        }

        public void setId(Id id) {
            this.id = id;
        }

        public Object clone() {
            Object obj=null;
            //调用Object类的clone方法——浅拷贝
            try {
                obj= super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            //调用Age类的clone方法进行深拷贝
            //先将obj转化为学生类实例
            A stu=(A)obj;
            //学生类实例的Age对象属性，调用其clone方法进行拷贝
            stu.id=(Id) stu.getId().clone();
            return obj;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("A{");
            sb.append("age=").append(age);
            sb.append(", name='").append(name).append('\'');
            sb.append(", id=").append(id);
            sb.append('}');
            return sb.toString();
        }
    }

    static class Id implements Cloneable{
        private String id;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        //重写Object的clone方法
        public Object clone() {
            Object obj=null;
            try {
                obj=super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            return obj;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Id{");
            sb.append("id='").append(id).append('\'');
            sb.append('}');
            return sb.toString();
        }
    }
}
