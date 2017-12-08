package com.hdu.rps.mapper;

import com.hdu.rps.model.Counts;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
@MapperScan
public interface CountsMapper {
    int deleteByPrimaryKey(Integer countsno);

    int insert(Counts record);

    int insertSelective(Counts record);

    Counts selectByPrimaryKey(Integer countsno);

    int updateByPrimaryKeySelective(Counts record);

    int updateByPrimaryKey(Counts record);

    Counts selectByUserNo(Integer userno);

    ArrayList<Counts> findAllOrderByCounts();

    int selectCountByUserNo(Integer userno);
}