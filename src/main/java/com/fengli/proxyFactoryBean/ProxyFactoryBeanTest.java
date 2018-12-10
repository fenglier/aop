package com.fengli.proxyFactoryBean;

import com.fengli.JDKDynamic.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/******************************************************************************
 * @Package: [com.fengli.proxyFactoryBean.ProxyFactoryBeanTest]
 * @ClassName: [ProxyFactoryBeanTest]
 * @Description: [一句话描述该类的功能]
 * @Author: [LETFL@founder.com.cn]  
 * @CreateDate: [2018/12/10 16:00]   
 * @UpdateUser: [LETFL@founder.com.cn (如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate: [2018/12/10 16:00，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容, (如多次修改保留历史记录 ， 增加修改记录)]
 * @Version: [v1.0]
 * ${tags}
 */
public class ProxyFactoryBeanTest {
    public static void main(String argc[]) {
        String xmlPath = "proxyFactoryBeanApplicationContext.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        UserDao userDao = (UserDao) applicationContext.getBean("userDaoProxy");
        //执行方法
        userDao.save();
    }
}
