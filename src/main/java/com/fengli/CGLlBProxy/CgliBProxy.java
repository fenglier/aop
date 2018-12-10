package com.fengli.CGLlBProxy;

import com.fengli.JDKDynamic.MyAspect;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Package: [com.fengli.CGLlProxy.CgliProxy]
 * @ClassName: [CgliProxy]
 * @Author: [fengli@founder.com.cn]
 * @CreateDate: [2018/12/7 17:29]
 * @UpdateUser: [fengli@founder.com.cn (如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2018/12/7 17:29，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容, (如多次修改保留历史记录 ， 增加修改记录)]
 * @Version: [v1.0]
 * ${tags}
 */
public class CgliBProxy implements MethodInterceptor {
        //代理方法
        public Object createProxy(Object target){
                //创建一个动态类对象
                Enhancer enhancer=new Enhancer();
                //确定要增强的类，设置其父类
                enhancer.setSuperclass(target.getClass());
                //添加回调函数
                enhancer.setCallback(this);
                //返回创建的代理类
                return  enhancer.create();
        }


        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                //创建切面类对象
                MyAspect myAspect=new MyAspect();
                //前增强
                myAspect.permissionCheck();
                //目标方法执行
                Object obj=methodProxy.invokeSuper(o, objects);
                //后增强
                myAspect.log();
                return obj;
        }
}
