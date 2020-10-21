package com.antiy.demo.aop.aop2;


/**
 * 功能描述 : 静态代理
 * <p>
 * 优点 可以在不修改目标对象的条件下修改功能
 * 缺点 代理对象要实现和目标对象一样的接口
 * 一旦接口增加方法，目标和代理都要修改
 *
 * @author ygh
 * @date 13:46
 */
public interface User {
    public void save();
}
