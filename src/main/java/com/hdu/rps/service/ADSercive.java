package com.hdu.rps.service;

import com.hdu.rps.model.RecommendedPerson;
import com.hdu.rps.model.ScoreRule;
import com.hdu.rps.model.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;

/**
 * Created by SJH on 2017/11/23.
 */
public interface ADSercive {
    /***
     * 根据岗位名称查找用户
     * @param job 岗位名称
     * @return 用户列表
     */
    ArrayList<User> findAllUserByJob(String job);

    /**
     * 根据用户ID删除用户
     * @param userno 用户ID
     */
    void userManageDelByUserNO(int userno);

    /**
     * 编辑用户信息
     * @param userno 用户ID
     * @return 用户
     */
    User userManageEditByUserNO(int userno);

    /**
     * 查找已经通过管理员审核的人才库简历
     * @return 被推荐人简历列表
     */
    ArrayList<RecommendedPerson> selectRecommendedPersonHaveChecked();

    /**
     * 查找未通过管理员审核的人才库简历
     * @return 被推荐人简历列表
     */
    ArrayList<RecommendedPerson> selectRecommendedPersonNotChecked();

    /**
     * 查看被推荐人详细信息
     * @param rdpno 被推荐人ID
     * @return 被推荐人信息
     */
    RecommendedPerson selectRecommendPersonByRdpno(int rdpno);

    /**
     * 通过新增简历申请
     * @param rdpno 被推荐人简历ID
     */
    void recommendedNotcheckedPass(int rdpno);

    /**
     * 不通过新增简历申请
     * @param rdpno 被推荐人简历ID
     */
    void recommendedNotcheckedNotPass(int rdpno);

    /**
     * 删除已审核人才库简历
     * @param rdpno 简历ID
     */
    void delHavePassedRecommended(int rdpno);

    /**
     * 提交已审核人才库编辑
     * @param rdpno 简历ID
     * @param name 姓名
     * @param sex 性别
     * @param birthdate 出生日期
     * @param minzu 民族
     * @param mianmao 政治面貌
     * @param province 籍贯省份
     * @param city 籍贯城市
     * @param telphone 手机号
     * @param email 邮箱
     * @param address 现住址
     * @param school 毕业院校
     * @param major 专业
     * @param xueli 学历
     * @param computer 计算机水平
     * @param english 英语水平
     * @param interest 兴趣爱好
     * @param file 照片
     */
    void haveCheckedPersonEditSubmit(int rdpno, String name, String sex, String birthdate, String minzu, String mianmao, String province, String city,
                                     String telphone, String email, String address, String school, String major,
                                     String xueli, String computer, String english, String interest, MultipartFile file);

    /**
     * 删除HR
     * @param rdpno HR ID
     */
    void delHR(int rdpno);

    /**
     * 提交职员编辑
     * @param rdpno 职员ID
     * @param name 姓名
     * @param phone 手机号
     * @param email 邮箱
     * @param password 密码
     * @param sex 性别
     * @param score 积分
     */
    void userManageEditSubmit(int rdpno, String name, String phone, String email, String password, String sex, String score);

    /**
     * 提交HR信息编辑
     * @param rdpno HR ID
     * @param name 姓名
     * @param phone 手机号
     * @param email 邮箱
     * @param password 密码
     * @param sex 性别
     */
    void hrManageEditSubmit(int rdpno, String name, String phone, String email, String password, String sex);

    /**
     * 新增HR
     * @param name 性别
     * @param phone 手机号
     * @param email 邮箱
     * @param password 密码
     * @param sex 密码
     */
    void hrManageAddSubmit(String name, String phone,
                           String email, String password, String sex);

    /**
     * 积分管理
     * @return 积分
     */
    ScoreRule selectScoreRule();

    /**
     * 更新积分规则
     * @param scoreRule 现有积分规则
     */
    void updateScoreRule(ScoreRule scoreRule);
}
