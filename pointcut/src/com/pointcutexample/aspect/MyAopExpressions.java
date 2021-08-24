package com.pointcutexample.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MyAopExpressions {

    @Pointcut("execution(* com.pointcutexample.dao.*.*(..))")
    public void forDaoPackage() {}

    // pointcut for getter methods
    @Pointcut("execution(* com.pointcutexample.dao.*.set*(..))")
    public void getter() {}

    // pointcut for setter methods
    @Pointcut("execution(* com.pointcutexample.dao.*.get*(..))")
    public void setter() {}

    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterSetter() {}

}
