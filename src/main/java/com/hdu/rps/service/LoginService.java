package com.hdu.rps.service;

import java.util.ArrayList;

/**
 * Created by SJH on 2017/11/5.
 */

public interface LoginService {

   /**
    * 查询用户
    * @param useremail 用户邮箱
    * @param userpassword 用户密码
    * @param userjob 用户职位类型
    * @return 查询结果
    */
   int findByUserEmailAndUserPasswordAndUserJob(String useremail, String userpassword, String userjob);

   /**
    * 查询邮箱
    * @param job 职位类型
    * @return 邮箱列表
    */
   ArrayList<String> findEmailByJob(String job);
}
