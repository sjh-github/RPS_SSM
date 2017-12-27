package com.hdu.rps.service;

import com.hdu.rps.model.Position;

import java.util.List;

/**
 * Created by SJH on 2017/11/14.
 */
public interface HRRecruitService {
    /**
     * 发布招聘信息
     * @param jobname 岗位名称
     * @param jobcount 招聘人数
     * @param province 工作地点省份
     * @param city 工作地点城市
     * @param deadtime 截止日期
     * @param salary1 薪水下限
     * @param salary2 薪水上限
     * @param duty 岗位职责
     * @param skill 要求技能
     * @param message 备注
     */
    void recruit(String jobname, String jobcount, String province, String city, String deadtime, int salary1, int salary2
            , String duty, String skill, String message);

    /**
     * 获得所有招聘列表
     * @return 职位列表
     */
    List<Position> getPositionList();

    /**
     * 删除招聘信息
     * @param id 职位ID
     */
    void delByID(int id);

    /**
     * 多选删除招聘信息
     * @param ids 职位ID数组
     */
    void delSelected(String[] ids);

    /**
     * 获得已处理招聘信息
     * @return 职位列表
     */
    List<Position> getPositionListHaveNoNeeds();
}
