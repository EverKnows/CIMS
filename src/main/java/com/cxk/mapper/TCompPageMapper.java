package com.cxk.mapper;

import com.cxk.po.Page;
import com.cxk.po.TComp;

import java.util.List;

public interface TCompPageMapper {
    List<TComp> findCompByPage(Page page);

    Integer querySumOfRecords();
}
