package com.antiy.demo.aop.aop5;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @Author ygh
 * execution 匹配式
 * 匹配所有类public方法  execution(public * *(..))
 * 匹配指定包下所有类方法 execution(* com.baidu.dao.*(..)) 不包含子包
 * execution(* com.baidu.dao..*(..))  ..*表示包、子孙包下所有类
 * 匹配指定类所有方法 execution(* com.baidu.service.UserService.*(..))
 * 匹配实现特定接口所有类方法
 *     execution(* com.baidu.dao.GenericDAO+.*(..))
 * 匹配所有save开头的方法 execution(* save*(..))
 * @Description
 * @Date 2020/9/4
 */
@Component
@Aspect
public class AspectT {

    @Before("execution(* com.antiy.demo.aop.aop5..*(..))")
    public void before(){
        System.out.println("开始之前");
    }

    @After("execution(* com.antiy.demo.aop.aop5..*(..))")
    public void after(){
        System.out.println("开始之后");
    }
//    使用==========================================================
//    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping) && @annotation(io.swagger.annotations.ApiOperation)")
//    public void requestMapping() {
//    }
//
//    /**
//     * @Author: xuemeng
//     * @Description: 日志切面
//     * @Date: 9:56 2019/3/14
//     */
//    @Around(value = "requestMapping()")
//    public Object log(ProceedingJoinPoint point) throws Throwable {
//        ApiOperation apiOperation = ((MethodSignature) point.getSignature()).getMethod().getAnnotation(ApiOperation.class);
//        RequestMapping requestMapping = ((MethodSignature) point.getSignature()).getMethod().getAnnotation(RequestMapping.class);
//        RequestMapping requestMappingClass = point.getTarget().getClass().getAnnotation(RequestMapping.class);
//        Object[] param = point.getArgs();
//
//        // 防止打印日志错误
//        List<RequestMethod> methods = Arrays.asList(requestMapping.method());
//        // 打印时间  用于调试
//        if (methods.indexOf(RequestMethod.GET) == -1 && !(requestMappingClass.value()[0] + requestMapping.value()[0]).contains("file/upload")) {
//            StringBuilder paramSb = new StringBuilder();
//            for (Object object : param) {
//                if (object instanceof ServletResponse || object instanceof ServletRequest) {
//                    continue;
//                }
//                paramSb.append(JsonUtil.object2Json(object));
//            }
//            LogUtils.info(logger, "日志，地址：{}，功能：{}，备注：{}，入参：{}，时间：{}",
//                    requestMappingClass.value()[0] + requestMapping.value()[0], apiOperation.value(), apiOperation.notes(), paramSb.toString(), System.currentTimeMillis());
//        } else {
//            LogUtils.info(logger, "日志，地址：{}，功能：{}，备注：{}",
//                    requestMappingClass.value()[0] + requestMapping.value()[0], apiOperation.value(), apiOperation.notes());
//        }
//
//        Object result = point.proceed();
//
//        if (methods.indexOf(RequestMethod.GET) == -1) {
//            LogUtils.info(logger, "日志，地址：{}，功能：{}，备注：{}，返参：{}，时间：{}",
//                    requestMappingClass.value()[0] + requestMapping.value()[0], apiOperation.value(), apiOperation.notes(), JsonUtil.object2Json(result), System.currentTimeMillis());
//        } else {
//            LogUtils.info(logger, "日志，地址：{}，功能：{}，备注：{}",
//                    requestMappingClass.value()[0] + requestMapping.value()[0], apiOperation.value(), apiOperation.notes());
//        }
//        return result;
//    }
}
