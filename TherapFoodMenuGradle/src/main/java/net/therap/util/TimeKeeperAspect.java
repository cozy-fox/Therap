package net.therap.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author sanjoy.saha
 * @date 6/5/14
 * @time 12:51 PM
 */

@Aspect
public class TimeKeeperAspect {
    long startTimeMiliSeconds;
    long endTimeMiliSeconds;
    private static final Logger log = LoggerFactory.getLogger(DatabaseTemplate.class);
//    pointcut deliverMessage() :call(* net.therap.MessageCommunication.deliver(..));
//
//    before() : deliverMessage() {
//        System.out.println("Hello from aJ !!");
//    }

//    @Pointcut( "execution(* net.therap.controller.AdminController.doGet(..) )" )
//    protected void printing() {
//    }

//    @Before("printing()")
    @Before("execution(* net.therap.service.*Service.*(..) )")
    public void beforeExecutionOfService(){
        startTimeMiliSeconds = System.currentTimeMillis();
    }

    @After("execution(* net.therap.service.*Service.*(..) )")
    public void afterExecutionOfService(){
        endTimeMiliSeconds = System.currentTimeMillis();
    }

    @After("execution(* net.therap.service.*Service.*(..) )")
    public void afterExecutionLoggingOfTime( JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        long timeDifference = (endTimeMiliSeconds-startTimeMiliSeconds);
        String output = String.format("%5d ms :::: fn: %s", timeDifference, methodName);
        log.info(output);
    }


}
