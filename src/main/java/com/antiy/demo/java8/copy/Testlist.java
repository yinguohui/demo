package com.antiy.demo.java8.copy;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author ygh
 * @Description
 * @Date 2020/11/23
 */
public class Testlist {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        String a =  new String("a");
        list.add("111");
        list.add("sss");
        list.add(a);
        List<String> list1 = (List<String>) list.clone();
        System.out.println(list1);
        a = new String("bb");
        System.out.println(a);
        System.out.println("之后"+list1);
        System.out.println(list);

//        ArrayList<Stu> list = new ArrayList<>();
//        Stu stu = new Stu();
//        stu.setName("1");
//        stu.setAge(1);
//        Stu stu1 = new Stu();
//        stu1.setName("2");
//        stu1.setAge(2);
//        list.add(stu1);
//        list.add(stu);
//        List<Integer> list2 = new ArrayList<>();
//
//        List<Stu> list1 = new ArrayList<>(list);
//        System.out.println("之前"+list1);
//        //
//        stu.setAge(22);
//        stu1.setAge(33);
//        list1.add(new Stu("aaa",55));
//        System.out.println("之后"+list1);
//        System.out.println(list);
//        ArrayList<Integer> list = new ArrayList<>();
//        Integer a = new Integer(11);
//        list.add(11);
//        list.add(1214);
//        list.add(a);
//
//        ArrayList<Integer> list1 = (ArrayList<Integer>) list.clone();
//        System.out.println(list1);
//        a= new Integer(2222);
//        System.out.println(list1);
    }

    static class Stu implements Cloneable,Serializable {
        private transient String name;
        private Integer age;

        public Stu() {
        }

        public Stu(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
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

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Stu{");
            sb.append("name='").append(name).append('\'');
            sb.append(", age=").append(age);
            sb.append('}');
            return sb.toString();
        }
        public Object clone() {
            Object obj=null;
            try {
                obj=super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            return obj;
        }
    }
}
