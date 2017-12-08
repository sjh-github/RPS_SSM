package com.hdu.rps.mapper;

import com.hdu.rps.model.Employ;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

@Repository
@MapperScan
public interface EmployMapper {
    int deleteByPrimaryKey(Integer employno);

    int insert(Employ record);

    int insertSelective(Employ record);

    Employ selectByPrimaryKey(Integer employno);

    int updateByPrimaryKeySelective(Employ record);

    int updateByPrimaryKey(Employ record);
}