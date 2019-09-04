package com.cxk.mapper;

import com.cxk.po.TTeam;
import com.cxk.po.TTeamExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TTeamMapper {
    int countByExample(TTeamExample example);

    int deleteByExample(TTeamExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TTeam record);

    int insertSelective(TTeam record);

    List<TTeam> selectByExample(TTeamExample example);

    TTeam selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TTeam record, @Param("example") TTeamExample example);

    int updateByExample(@Param("record") TTeam record, @Param("example") TTeamExample example);

    int updateByPrimaryKeySelective(TTeam record);

    int updateByPrimaryKey(TTeam record);
}