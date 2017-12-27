package com.hdu.rps.service;

import com.hdu.rps.model.Counts;

import java.util.ArrayList;

/**
 * Created by SJH on 2017/11/22.
 */
public interface CountsService {
    /**
     * 排序查询所有积分
     * @return 积分列表
     */
    ArrayList<Counts> findAllOrderByCounts();
}
