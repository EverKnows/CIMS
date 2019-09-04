package com.cxk.service;

import com.cxk.po.Page;
import com.cxk.po.TComp;
import com.cxk.po.TCompExample;
import com.cxk.vo.CompListVo;

import java.util.List;

public interface CompService {

    List<TComp> findAllCompInfo() throws Exception;

    List<TComp> findCompBySelected(TCompExample example) throws Exception;

    TComp findCompInfoById(Integer id) throws Exception;

    CompListVo findCompByPage(CompListVo compListVo) throws Exception;
}
