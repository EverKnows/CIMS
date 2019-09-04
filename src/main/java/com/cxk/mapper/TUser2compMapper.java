package com.cxk.mapper;

import com.cxk.po.TUser2comp;
import com.cxk.po.TUser2compExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TUser2compMapper {
    int countByExample(TUser2compExample example);

    int deleteByExample(TUser2compExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TUser2comp record);

    int insertSelective(TUser2comp record);

    List<TUser2comp> selectByExample(TUser2compExample example);

    TUser2comp selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TUser2comp record, @Param("example") TUser2compExample example);

    int updateByExample(@Param("record") TUser2comp record, @Param("example") TUser2compExample example);

    int updateByPrimaryKeySelective(TUser2comp record);

    int updateByPrimaryKey(TUser2comp record);
}