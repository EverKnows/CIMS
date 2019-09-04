package com.cxk.mapper;

import com.cxk.po.TTeam2comp2award;
import com.cxk.po.TTeam2comp2awardExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TTeam2comp2awardMapper {
    int countByExample(TTeam2comp2awardExample example);

    int deleteByExample(TTeam2comp2awardExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TTeam2comp2award record);

    int insertSelective(TTeam2comp2award record);

    List<TTeam2comp2award> selectByExample(TTeam2comp2awardExample example);

    TTeam2comp2award selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TTeam2comp2award record, @Param("example") TTeam2comp2awardExample example);

    int updateByExample(@Param("record") TTeam2comp2award record, @Param("example") TTeam2comp2awardExample example);

    int updateByPrimaryKeySelective(TTeam2comp2award record);

    int updateByPrimaryKey(TTeam2comp2award record);
}