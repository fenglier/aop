package com.fengli.proxyFactoryBean;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Method;

/******************************************************************************
 * @Package: [com.fengli.proxyFactoryBean.MyAspects]
 * @ClassName: [MyAspects]
 * @Description: [该类是用来演示使用ProxyFActoryBean创建aop代理]
 * @Author: [LETFL@founder.com.cn]
 * @CreateDate: [2018/12/10 15:42]
 * @UpdateUser: [LETFL@founder.com.cn (如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2018/12/10 15:42，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容, (如多次修改保留历史记录 ， 增加修改记录)]
 * @Version: [v1.0]
 * ${tags}
 */
public class MyAspects implements MethodInterceptor {


    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        check_Permissions();
        //执行目标方法
        Object obj=methodInvocation.proceed();
        log();
        return obj;
    }
    public void check_Permissions(){
        System.out.println("模拟检查权限……");
    }
    public void log(){
        System.out.println("模拟记录日志……");
    }
}
