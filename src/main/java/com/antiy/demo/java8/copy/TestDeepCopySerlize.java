package com.antiy.demo.java8.copy;

import java.io.*;

/**
 * @Author ygh
 * @Description 测试深拷贝序列化
 * @Date 2020/11/23
 */
public class TestDeepCopySerlize {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Student student = new Student();
        student.setAge(11);
        student.setName("2231");
        Id id = new Id();
        id.setId("111");
        student.setId(id);
        //通过序列化方法实现深拷贝
        ByteArrayOutputStream bos=new ByteArrayOutputStream();
        ObjectOutputStream oos=new ObjectOutputStream(bos);
        oos.writeObject(student);
        oos.flush();
        ObjectInputStream ois=new ObjectInputStream(new ByteArrayInputStream(bos.toByteArray()));
        Student stu2=(Student)ois.readObject();
        System.out.println("改变之前"+stu2);
        id.setId("茁壮成长");
        System.out.println("改变之后"+stu2);

    }

    static class Student implements Serializable{
        private Integer age;
        private transient String name;
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

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Student{");
            sb.append("age=").append(age);
            sb.append(", name='").append(name).append('\'');
            sb.append(", id=").append(id);
            sb.append('}');
            return sb.toString();
        }
    }
    static class Id implements Serializable {
        private String id;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
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
