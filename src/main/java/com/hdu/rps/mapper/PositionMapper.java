package com.hdu.rps.mapper;

import com.hdu.rps.model.Position;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@MapperScan
@Transactional
public interface PositionMapper {
    int deleteByPrimaryKey(Integer posno);

    int insert(Position record);

    int insertSelective(Position record);

    Position selectByPrimaryKey(Integer posno);

    int updateByPrimaryKeySelective(Position record);

    int updateByPrimaryKey(Position record);

    List<Position> findAllHaveNeeds();

    List<Position> findAllHaveNoNeeds();

    String selectDeatTimeByPositionID(int posno);

}