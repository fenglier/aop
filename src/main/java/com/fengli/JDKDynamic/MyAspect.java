package com.fengli.JDKDynamic;

import java.util.Random;

/**
 * @Package: [com.fengli.JDKDynamic.MyAspect]
 * @ClassName: [MyAspect]
 * @Author: [fengli@founder.com.cn]
 * @CreateDate: [2018/12/7 16:47]
 * @UpdateUser: [fengli@founder.com.cn (如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2018/12/7 16:47，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容, (如多次修改保留历史记录 ， 增加修改记录)]
 * @Version: [v1.0]
 * ${tags}
 */
public class MyAspect {
    public void permissionCheck() {
        System.out.println("正在进行权限检查……");
        Random r = new Random();
        boolean result = r.nextBoolean();
        String msg = result ? "权限验证成功" : "无权限";

        System.out.println("result:" + msg);

    }

    public void log() {
        System.out.println("记录日志……");
    }

}
