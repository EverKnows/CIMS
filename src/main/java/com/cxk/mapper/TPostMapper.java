package com.cxk.mapper;

import com.cxk.po.TPost;
import com.cxk.po.TPostExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TPostMapper {
    int countByExample(TPostExample example);

    int deleteByExample(TPostExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TPost record);

    int insertSelective(TPost record);

    List<TPost> selectByExample(TPostExample example);

    TPost selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TPost record, @Param("example") TPostExample example);

    int updateByExample(@Param("record") TPost record, @Param("example") TPostExample example);

    int updateByPrimaryKeySelective(TPost record);

    int updateByPrimaryKey(TPost record);
}