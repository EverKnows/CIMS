package com.cxk.mapper;

import com.cxk.po.TUserForum;
import com.cxk.po.TUserForumExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TUserForumMapper {
    int countByExample(TUserForumExample example);

    int deleteByExample(TUserForumExample example);

    int insert(TUserForum record);

    int insertSelective(TUserForum record);

    List<TUserForum> selectByExample(TUserForumExample example);

    int updateByExampleSelective(@Param("record") TUserForum record, @Param("example") TUserForumExample example);

    int updateByExample(@Param("record") TUserForum record, @Param("example") TUserForumExample example);
}