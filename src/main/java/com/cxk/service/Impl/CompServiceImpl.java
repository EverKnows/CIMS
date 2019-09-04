package com.cxk.service.Impl;

import com.cxk.mapper.TCompMapper;
import com.cxk.mapper.TCompPageMapper;
import com.cxk.po.Page;
import com.cxk.po.TComp;
import com.cxk.po.TCompExample;
import com.cxk.service.CompService;
import com.cxk.vo.CompListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
@Service
public class CompServiceImpl implements CompService {

    @Autowired
    private TCompMapper compMapper;

    @Autowired
    private TCompPageMapper compPageMapper;

    public List<TComp> findAllCompInfo() throws Exception {
        TCompExample example = new TCompExample();
        List<TComp> compList = compMapper.selectByExample(example);
        return compList;
    }

    public List<TComp> findCompBySelected(TCompExample example) throws Exception {
        return null;
    }

    public TComp findCompInfoById(Integer id) throws Exception {
        TComp comp = compMapper.selectByPrimaryKey(id);
        return comp;
    }

    public CompListVo findCompByPage(CompListVo compListVo) throws Exception {
        if (compListVo.getPage() == null) {
            compListVo.setPage(new Page());
        }

        if (compListVo.getPage().getCurrentPage() == null) {
            compListVo.getPage().setCurrentPage(1);
        }

        if (compListVo.getPage().getRow() == null) {
            compListVo.getPage().setRow(5);
        }

        compListVo.getPage().setStart((compListVo.getPage().getCurrentPage() - 1) * compListVo.getPage().getRow());
        List<TComp> compList = compPageMapper.findCompByPage(compListVo.getPage());
        Integer sum = compPageMapper.querySumOfRecords();
        compListVo.getPage().setTotalRecords(sum);
        compListVo.setCompList(compList);
        Integer totalPages = (sum % compListVo.getPage().getRow()) == 0 ? (sum / compListVo.getPage().getRow()) :(sum / compListVo.getPage().getRow() + 1);
        compListVo.getPage().setTotalPages(totalPages);
        sortListByOrder(compListVo);
        removeItemNotSuitTime(compListVo);
        removeItemNotSuitLevel(compListVo);

        return compListVo;
    }

    public void sortListByOrder(CompListVo compListVo) {
        if ("new".equals(compListVo.getOrder())) {
            Collections.sort(compListVo.getCompList(), new Comparator<TComp>() {
                public int compare(TComp o1, TComp o2) {
                    return (int) (o1.getSignUpStart().getTime() - o2.getSignUpStart().getTime());
                }
            });
        } else if("long".equals(compListVo.getOrder())) {
            Collections.sort(compListVo.getCompList(), new Comparator<TComp>() {
                public int compare(TComp o1, TComp o2) {
                    return (int) (o2.getSignUpStart().getTime() - o1.getSignUpStart().getTime());
                }
            });
        } else {
            return;
        }
    }

    public void removeItemNotSuitTime(CompListVo compListVo) {
        List<TComp> list = compListVo.getCompList();
        String time = compListVo.getTime();
        long nowTime = new Date().getTime();
        if ("signup".equals(time)) {
            for (int i = list.size() - 1; i >= 0; i--) {
                if ((list.get(i).getSignUpStart().getTime() <= nowTime) && (nowTime <=  list.get(i).getSignUpEnd().getTime())) {

                } else {
                    list.remove(i);
                }
            }
        } else if ("match".equals(time)) {
            for (int i = list.size() - 1; i >= 0; i--) {
                if ((list.get(i).getCompStart().getTime() <= nowTime) && (nowTime <=  list.get(i).getCompEnd().getTime())) {

                } else {
                    list.remove(i);
                }
            }
        } else {
            return;
        }
    }

    public void removeItemNotSuitLevel(CompListVo compListVo) {
        List<TComp> list = compListVo.getCompList();
        String level = compListVo.getLevel();
        if ("default".equals(level)) {
            return;
        } else if("province".equals(level)){
            System.out.println("remove");
            removeItemByLevel("省级", list);
        } else if ("school".equals(level)){
            removeItemByLevel("校级", list);
        } else if ("college".equals(level)){
            removeItemByLevel("院级", list);
        } else {
            return;
        }
    }

    public void removeItemByLevel(String level, List<TComp> list) {
        for (int i = list.size() - 1; i >= 0; i--) {
            if (level.equals(list.get(i).getLevel())) {
                list.remove(i);
            }
        }
    }
}
