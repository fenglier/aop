package com.fengli.JDKDynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理类
 *
 * @Package: [com.fengli.JDKDynamic.JdkProxy]
 * @ClassName: [JdkProxy]
 * @Author: [fengli@founder.com.cn]
 * @CreateDate: [2018/12/7 16:55]
 * @UpdateUser: [fengli@founder.com.cn (如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2018/12/7 16:55，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容, (如多次修改保留历史记录 ， 增加修改记录)]
 * @Version: [v1.0]
 * ${tags}
 */
public class JdkProxy implements InvocationHandler {
    //声明目标类借口
    private UserDao userDao;

    //创建代理方法
    public Object createProxy(UserDao userDao) {
        this.userDao = userDao;
        // 1.类加载器
        ClassLoader classLoader = JdkProxy.class.getClassLoader();
        // 被代理对象实现的所有接口
        Class[] clazz = userDao.getClass().getInterfaces();
        // 3. 使用代理类，进行增强 返回的是代理后的对象
        return Proxy.newProxyInstance(classLoader, clazz, this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //声明切面
        MyAspect myAspect=new MyAspect();

        //前增强
        myAspect.permissionCheck();
        //在目标类上调用方法，并传入参数
        Object obj=method.invoke(userDao, args);
        //后增强
        myAspect.log();

        return obj;
    }
}
