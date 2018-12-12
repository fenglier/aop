package com.fengli.JDKDynamic;

import org.springframework.stereotype.Repository;

/**
 * @Package: [com.fengli.JDKDynamic.UserDaoImpl]
 * @ClassName: [UserDaoImpl]
 * @Author: [fengli@founder.com.cn]
 * @CreateDate: [2018/12/7 16:45]
 * @UpdateUser: [fengli@founder.com.cn (如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2018/12/7 16:45，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容, (如多次修改保留历史记录 ， 增加修改记录)]
 * @Version: [v1.0]
 * ${tags}
 */
@Repository("userDao")
public class UserDaoImpl implements UserDao {

    public void save() {
        System.out.println("save save save!!!");
    }
}
