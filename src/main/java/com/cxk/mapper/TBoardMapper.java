package com.cxk.mapper;

import com.cxk.po.TBoard;
import com.cxk.po.TBoardExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TBoardMapper {
    int countByExample(TBoardExample example);

    int deleteByExample(TBoardExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TBoard record);

    int insertSelective(TBoard record);

    List<TBoard> selectByExample(TBoardExample example);

    TBoard selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TBoard record, @Param("example") TBoardExample example);

    int updateByExample(@Param("record") TBoard record, @Param("example") TBoardExample example);

    int updateByPrimaryKeySelective(TBoard record);

    int updateByPrimaryKey(TBoard record);
}