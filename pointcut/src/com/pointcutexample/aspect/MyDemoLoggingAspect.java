package com.pointcutexample.aspect;

import com.pointcutexample.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @Before("com.pointcutexample.aspect.MyAopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
        System.out.println("\n=====>>> Executing @Before advice on method");

        // display the method signature
        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
        System.out.println("Method: " + methodSignature);

        //display the method args
        Object[] methodParameters = theJoinPoint.getArgs();
        for (Object tempArg : methodParameters) {
            System.out.println(tempArg);

            if (tempArg instanceof Account) {
                Account theAccount = (Account) tempArg;

                System.out.println("account name: " + theAccount.getName());
                System.out.println("account level: " + theAccount.getLevel());
            }
        }
    }

    @AfterReturning(
            pointcut = "execution(* com.pointcutexample.dao.AccountDAO.findAccounts(..))",
            returning = "result")
    public void afterReturningFindAccountsAdvice(
            JoinPoint JoinPoint, List<Account> result) {

        String method = JoinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Executing @AfterReturning on method: " + method);

        System.out.println("\n=====>>> The result: " + result);

        convertAccountNamesToUpperCase(result);
        System.out.println("\n=====>>> The result: " + result);
    }

    private void convertAccountNamesToUpperCase(List<Account> result) {

        for (Account account : result) {

            String theUpperName = account.getName().toUpperCase();

            account.setName(theUpperName);

        }
    }

    @AfterThrowing(
            pointcut = "execution(* com.pointcutexample.dao.AccountDAO.findAccounts(..))",
            throwing = "e")
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Exception e) {

        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Executing @AfterThrowing on method: " + method);

        System.out.println("\n=====>>> The exception: " + e);
    }

    @After("execution(* com.pointcutexample.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Executing @After (finally) on method: " + method);
    }
}










