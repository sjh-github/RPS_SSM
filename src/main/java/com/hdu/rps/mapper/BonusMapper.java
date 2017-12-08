package com.hdu.rps.mapper;

import com.hdu.rps.model.Bonus;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;


@Repository
@MapperScan
public interface BonusMapper {
    int deleteByPrimaryKey(Integer bonusno);

    int insert(Bonus record);

    int insertSelective(Bonus record);

    Bonus selectByPrimaryKey(Integer bonusno);

    int updateByPrimaryKeySelective(Bonus record);

    int updateByPrimaryKey(Bonus record);
}