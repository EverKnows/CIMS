package com.cxk.mapper;

import com.cxk.po.TComp;
import com.cxk.po.TCompExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TCompMapper {
    int countByExample(TCompExample example);

    int deleteByExample(TCompExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TComp record);

    int insertSelective(TComp record);

    List<TComp> selectByExample(TCompExample example);

    TComp selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TComp record, @Param("example") TCompExample example);

    int updateByExample(@Param("record") TComp record, @Param("example") TCompExample example);

    int updateByPrimaryKeySelective(TComp record);

    int updateByPrimaryKey(TComp record);
}