package com.antiy.demo.java8.copy;

/**
 * @Author ygh
 * @Description 测试浅拷贝clone
 * @Date 2020/11/23
 */
public class TestCopyClone {
    public static void main(String[] args) {
        A a  = new A();
        a.setId("111");
        Student student = new Student();
        student.setA(a);
        student.setAge(11);
        student.setName("测试机哦");
        Student student1 = (Student) student.clone();
        System.out.println(student);
        a.setId("sss");
        System.out.println(student1);


    }
    static class A{
        private String id;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("A{");
            sb.append("id='").append(id).append('\'');
            sb.append('}');
            return sb.toString();
        }
    }

    static class Student  implements Cloneable{
        private Integer age;
        private String name;
        private A a;

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

        public A getA() {
            return a;
        }

        public void setA(A a) {
            this.a = a;
        }
        //重写Object类的clone方法
        public Object clone() {
            Object obj=null;
            //调用Object类的clone方法，返回一个Object实例
            try {
                obj= super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            return obj;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Student{");
            sb.append("age=").append(age);
            sb.append(", name='").append(name).append('\'');
            sb.append(", a=").append(a);
            sb.append('}');
            return sb.toString();
        }
    }
}
