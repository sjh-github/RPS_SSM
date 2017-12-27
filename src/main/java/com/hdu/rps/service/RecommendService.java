package com.hdu.rps.service;

import com.hdu.rps.model.FollowDetail;
import com.hdu.rps.model.RecommendedPerson;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;

/**
 * Created by SJH on 2017/11/17.
 */
public interface RecommendService {
    /**
     * 查询所有推荐人
     * @return 推荐人列表
     */
    ArrayList<RecommendedPerson> findAll();

    /**
     * 新增人才库
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
     * @param fil 照片文件
     * @return
     */
    int addToRepos(String name, String sex, String birthdate,
                   String minzu, String mianmao, String province,
                   String city, String telphone, String email,
                   String address, String school, String major,
                   String xueli, String computer, String english,
                   String interest, MultipartFile fil);

    /**
     * 查询推荐人信息
     * @param id 推荐人ID
     * @return 推荐人
     */
    RecommendedPerson findByID(int id);

    /**
     * 进行推荐
     * @param userID 推荐人ID
     * @param recommendedPersonID  被推荐人ID
     * @param positionID 职位ID
     * @return 推荐结果
     */
    int recommend(int userID, int recommendedPersonID, int positionID);

    /**
     * 检查是否延期
     * @param positionID 职位ID
     * @return 检查结果
     */
    int haveDelayed(int positionID);

    /**
     * 推荐跟踪
     * @param userno 用户ID
     * @return 跟踪状态
     */
    ArrayList<FollowDetail> getFollowDetailByUserno(int userno);
}
