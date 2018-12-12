package com.fengli.AnnotationAspectJ;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/******************************************************************************
 * @Package: [com.fengli.XMLAspectJ.MyAspect]
 * @ClassName: [MyAspect]
 * @Description: [基于注解的Aspectj]
 * @Author: [LETFL@founder.com.cn]  
 * @CreateDate: [2018/12/10 13:31]   
 * @UpdateUser: [LETFL@founder.com.cn (如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate: [2018/12/10 13:31，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容, (如多次修改保留历史记录 ， 增加修改记录)]
 * @Version: [v1.0]
 * ${tags}
 */
@Aspect
@Component
public class MyAspect {
    //定义切入点表达式
    @Pointcut("execution(* com.fengli.JDKDynamic.UserDaoImpl.*(..))")//对UserDaoImpl的所有方法进行处理
    private void myPointCut(){}

    //前置通知
    @Before("myPointCut()")
    public void myBefor(JoinPoint joinPoint){
        System.out.print("前置通知：模拟执行权限检查……");
        System.out.print("目标类是："+joinPoint.getTarget());
        System.out.println(",被植入增强处理的目标方法为："+joinPoint.getSignature().getName());
    }

    //后置通知
    @AfterReturning(value = "myPointCut()")
    public void myAferReturning(JoinPoint joinPoint){
        System.out.print("后置通知：模拟记录日志……");
        System.out.println("被植入增强处理的目标方法为："+joinPoint.getSignature().getName());
        
    }
    
   /** @Title: myAround
   * @Description: 环绕通知，必须是Object类型方返回值，必须接收一个参数，类型为ProceedingJoinPoint，必须throws Throwable
   * @param proceedingJoinPoint 是JoinPoint子接口，表示可以执行目标方法
   * @return java.lang.Object    返回类型
   * @throws
   */
    @Around("myPointCut()")
    public Object myAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        //开始
        System.out.println("环绕开始：执行目标方法之前，模拟开启事务……");
        //执行当前目标方法
        Object obj=proceedingJoinPoint.proceed();
        //结束
        System.out.println("环绕结束：执行目标方法之后，模拟关闭事务");
        return obj;
    }

    /** @Title: myAfterThrowing
    * @Description: 异常通知
    * @param joinPoint
    * @param  e
    * @return void    返回类型
    * @throws
    */
    @AfterThrowing(value = "myPointCut()",throwing = "e")
    public void myAfterThrowing(JoinPoint joinPoint,Throwable e){
        System.out.println("最终通知："+"出错了"+e.getMessage());
    }

    /** @Title: myAfter
    * @Description: 最终通知
    * @param
    * @return void    返回类型
    * @throws
    */
    @After("myPointCut()")
    public void myAfter(){
        System.out.println("最终通知：模拟方法结束后的释放资源……");
    }

}
