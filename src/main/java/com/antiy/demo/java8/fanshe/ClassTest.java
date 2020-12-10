package com.antiy.demo.java8.fanshe;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author ygh
 * @Description
 *
 * 　getName()：获得类的完整名字。
 * 　　getFields()：获得类的public类型的属性。
 * 　　getDeclaredFields()：获得类的所有属性。包括private 声明的和继承类
 * 　　getMethods()：获得类的public类型的方法。
 * 　　getDeclaredMethods()：获得类的所有方法。包括private 声明的和继承类
 * 　　getMethod(String name, Class[] parameterTypes)：获得类的特定方法，name参数指定方法的名字，parameterTypes 参数指定方法的参数类型。
 * 　　getConstructors()：获得类的public类型的构造方法。
 * 　　getConstructor(Class[] parameterTypes)：获得类的特定构造方法，parameterTypes 参数指定构造方法的参数类型。
 * 　　newInstance()：通过类的不带参数的构造方法创建这个类的一个对象。
 * @Date 2020/11/23
 */
public class ClassTest {
    public static void main(String[] args) throws ClassNotFoundException {
        //1、通过对象调用 getClass() 方法来获取,通常应用在：比如你传过来一个 Object
        //  类型的对象，而我不知道你具体是什么类，用这种方法
        People p1 = new People();
        Class c1 = p1.getClass();

        //2、直接通过 类名.class 的方式得到,该方法最为安全可靠，程序性能更高
        //  这说明任何一个类都有一个隐含的静态成员变量 class
        Class c2 = People.class;

        //3、通过 Class 对象的 forName() 静态方法来获取，用的最多，
        //   但可能抛出 ClassNotFoundException 异常
        Class c3 = Class.forName("com.antiy.demo.java8.fanshe.People");
        //获得类的完整名字。
        System.out.println(c1.getName());
        // 获得类的public类型的属性。
        System.out.println(c1.getFields());
        // 获得类的所有属性。包括private 声明的和继承类
        System.out.println(c1.getDeclaredFields());
        // 获得类的public类型的方法。
        System.out.println(c1.getMethods());
        // 获得类的所有方法。包括private 声明的和继承类
        System.out.println(c1.getDeclaredMethods());
        // 获得类的public类型的构造方法。
        System.out.println(c1.getConstructors());

    }
}
