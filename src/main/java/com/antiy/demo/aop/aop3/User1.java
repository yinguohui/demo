package com.antiy.demo.aop.aop3;


/**
 * 功能描述 : 动态代理
 * 动态代理利用了JDK API，动态地在内存中构建代理对象，从而实现对目标对象的代理功能。动态代理又被称为JDK代理或接口代
 * <p>
 * 静态代理与动态代理的区别主要在：
 * 静态代理在编译时就已经实现，编译完成后代理类是一个实际的class文件
 * 动态代理是在运行时动态生成的，即编译完成后没有实际的class文件，而是在运行时动态生成类字节码，并加载到JVM中
 * 特点：
 * 动态代理对象不需要实现接口，但是要求目标对象必须实现接口，否则不能使用动态代理
 *
 * @author ygh
 * @date 14:49
 */

public interface User1 {
    public void save();
}
