import com.fengli.CGLlBProxy.CgliBProxy;
import com.fengli.JDKDynamic.JdkProxy;
import com.fengli.JDKDynamic.UserDao;
import com.fengli.JDKDynamic.UserDaoImpl;

/**
 * @Package: [PACKAGE_NAME.Main]
 * @ClassName: [Main]
 * @Author: [fengli@founder.com.cn]
 * @CreateDate: [2018/12/7 17:07]
 * @UpdateUser: [fengli@founder.com.cn (如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2018/12/7 17:07，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容, (如多次修改保留历史记录 ， 增加修改记录)]
 * @Version: [v1.0]
 * ${tags}
 */
public class Main {
    public static void main(String argc[]){
        /* jdk动态代理方法
        //创建代理对象
        JdkProxy jdkProxy=new JdkProxy();
        //创建目标对象
        UserDao userDao=new UserDaoImpl();
        //获取代理对象增强后的目标对象
        UserDao userDao1= (UserDao) jdkProxy.createProxy(userDao);
        //执行方法
        userDao1.save();*/

        //CGLIB动态代理方法
        //创建代理对象
        CgliBProxy cgliBProxy=new CgliBProxy();
        //创建目标对象
        com.fengli.CGLlBProxy.UserDao userDao=new com.fengli.CGLlBProxy.UserDao();
        //获取代理对象增强后的目标对象
        com.fengli.CGLlBProxy.UserDao userDao1= (com.fengli.CGLlBProxy.UserDao) cgliBProxy.createProxy(userDao);
        //执行方法
        userDao1.save();
    }
}
