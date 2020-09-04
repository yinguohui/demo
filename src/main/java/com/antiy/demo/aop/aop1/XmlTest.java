package com.antiy.demo.aop.aop1;

/**
 * @Author ygh
 * @Description
 * @Date 2020/9/4
 */
public class XmlTest {
//    <?xml version="1.0" encoding="UTF-8"?>
//<beans xmlns="http://www.springframework.org/schema/beans"
//    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
//    xsi:schemaLocation="http://www.springframework.org/schema/beans
//    http://www.springframework.org/schema/beans/spring-beans.xsd
//            ">
//
//    <!-- 定义被代理者 -->
//    <bean id="h1" class="com.antiy.demo.aop.aop1.Hello1"></bean>
//    <bean id="h2" class="com.antiy.demo.aop.aop1.Hello2"></bean>
//
//    <!-- 定义通知内容，也就是切入点执行前后需要做的事情 -->
//    <bean id="helloCut" class="com.antiy.demo.aop.aop1.HelloCut"></bean>
//
//    <!-- 定义切入点位置，这里定义到了doPrint方法上 -->
//    <bean id="timePointcut" class="org.springframework.aop.support.JdkRegexpMethodPointcut">
//        <property name="pattern" value=".*doPrint"></property>
//    </bean>
//
//    <!-- 使切入点与通知相关联，完成切面配置 -->
//    <bean id="timeHandlerAdvisor" class="org.springframework.aop.support.DefaultPointcutAdvisor">
//        <property name="advice" ref="timeHandler"></property>
//        <property name="pointcut" ref="timePointcut"></property>
//    </bean>
//
//    <!-- 设置代理 -->
//    <bean id="proxy" class="org.springframework.aop.framework.ProxyFactoryBean">
//        <!-- 代理的对象，有打印时间能力 -->
//        <property name="target" ref="h1"></property>
//        <!-- 使用切面 -->
//        <property name="interceptorNames" value="timeHandlerAdvisor"></property>
//        <!-- 代理接口，hw接口 -->
//        <property name="proxyInterfaces" value="com.antiy.demo.aop.aop1.Hello"></property>
//    </bean>
//    <!-- 设置代理 -->
//    <bean id="proxy2" class="org.springframework.aop.framework.ProxyFactoryBean">
//        <!-- 代理的对象，有打印时间能力 -->
//        <property name="target" ref="h2"></property>
//        <!-- 使用切面 -->
//        <property name="interceptorNames" value="timeHandlerAdvisor"></property>
//        <!-- 代理接口，hw接口 -->
//        <property name="proxyInterfaces" value="com.antiy.demo.aop.aop1.Hello"></property>
//    </bean>
//
//   <!--<bean class="org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator"/>-->
//
//</beans>
}
