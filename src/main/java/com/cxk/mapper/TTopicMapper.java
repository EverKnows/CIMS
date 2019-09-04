package com.cxk.mapper;

import com.cxk.po.TTopic;
import com.cxk.po.TTopicExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TTopicMapper {
    int countByExample(TTopicExample example);

    int deleteByExample(TTopicExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TTopic record);

    int insertSelective(TTopic record);

    List<TTopic> selectByExample(TTopicExample example);

    TTopic selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TTopic record, @Param("example") TTopicExample example);

    int updateByExample(@Param("record") TTopic record, @Param("example") TTopicExample example);

    int updateByPrimaryKeySelective(TTopic record);

    int updateByPrimaryKey(TTopic record);
}