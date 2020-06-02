package com.github.mongo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * <p>
 * 创建时间为 下午4:35 2019/10/17
 * 项目名称 spring-boot-mongo
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */
@Slf4j
@Aspect
@Component
public class AspectLog {

    /**
     * 抽取公共的切入点表达式
     * 1.本类的引用
     * 2.其他的切面引用
     */
    @Pointcut("execution(* com.github.mongo.controller.*.*(..))")
    public void pointCut() {
    }

    @Around(value = "pointCut()")
    public Object logAround(ProceedingJoinPoint pdj) throws Throwable {
        long before = System.currentTimeMillis();
        Object object = pdj.proceed();
        long after = System.currentTimeMillis();
        log.error("{}|{}|{}", (after - before), pdj.getSignature().getName(), Arrays.asList(pdj.getArgs()));
        return object;
    }

}
