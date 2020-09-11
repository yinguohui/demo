package com.antiy.demo.jvm.clazz;

/**
 * @Author ygh
 * @Description 自定义加载器
 *
 * 要创建用户自己 的类加载器，只需要继承java.lang.ClassLoader，然后覆盖它的findClass(String name)方法即可。
 * 如果要符合双亲委派模型，则重写findClass()方法。如果要破坏的话，则重写 loadClass()方法
 * @Date 2020/9/11
 */
public class UserPlanLoader extends ClassLoader{
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        return super.findClass(name);
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        return super.loadClass(name);
    }
}
