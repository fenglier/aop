package com.fengli.XMLAspectJ;

import com.fengli.JDKDynamic.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/******************************************************************************
 * @Package: [com.fengli.XMLAspectJ.TestXmlAspectj]
 * @ClassName: [com.fengli.XMLAspectJ.TestXmlAspectj]
 * @Description: [一句话描述该类的功能]
 * @Author: [LETFL@founder.com.cn]  
 * @CreateDate: [2018/12/10 14:21]   
 * @UpdateUser: [LETFL@founder.com.cn (如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate: [2018/12/10 14:21，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容, (如多次修改保留历史记录 ， 增加修改记录)]
 * @Version: [v1.0]
 * ${tags}
 */
public class TestXmlAspectj {
    public static void main(String argc[]){
        //E:\IdeaProjects\aop\src\main\java\com\fengli\XMLAspectJ\proxyFactoryBeanApplicationContext.xml
        //String xmlPath="com/fengli/XMLAspectJ/proxyFactoryBeanApplicationContext.xml";
          String xmlPath= "applicationContext.xml";
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(xmlPath);
        //1 从spring获得内容
        UserDao userDao= (UserDao) applicationContext.getBean("userDao");
        //执行方法
        userDao.save();
    }

}
