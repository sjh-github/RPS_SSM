package com.hdu.rps.service;

import com.hdu.rps.model.Position;
import com.hdu.rps.model.RecommendedPerson;

import java.util.ArrayList;

/**
 * Created by SJH on 2017/11/20.
 */
public interface HRDeal {
    /**
     * 根据岗位信息查询被推荐人
     * @param posno 岗位ID
     * @return 被推荐人列表
     */
    ArrayList<RecommendedPerson> findRecommendedPersonByPosNo(int posno);

    /**
     * 通过HR该轮面试
     * @param recommendedPersonID 被推荐人ID
     * @param positionNo 岗位ID
     */
    void pass(int recommendedPersonID, int positionNo);

    /**
     * 不通过HR该轮面试
     * @param recommendedPersonID 被推荐人ID
     * @param positionNo 岗位ID
     */
    void notPass(int recommendedPersonID, int positionNo);

    /**
     * 根据岗位ID和面试状态查询被推荐人列表
     * @param posno 岗位ID
     * @param state 面试状态
     * @return
     */
    ArrayList<RecommendedPerson> findRecommendedPersonByPosNoAndState(int posno, int state);

    /**
     * 根据岗位ID查询已通过面试的被推荐人列表
     * @param posno 岗位ID
     * @return 被推荐人列表
     */
    ArrayList<RecommendedPerson> findPassedPersonByPos(int posno);

    /**
     * 查询招聘信息
     * @param posno 岗位ID
     * @return 职位详情
     */
    Position findPosByPosno(int posno);
}
