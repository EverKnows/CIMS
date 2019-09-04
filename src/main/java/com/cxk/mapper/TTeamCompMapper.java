package com.cxk.mapper;

import java.util.List;

import com.cxk.po.TComp;
import com.cxk.po.TTeam;
import com.cxk.vo.TeamListVo;

public interface TTeamCompMapper {
	List<TTeam> findTeamByCompIdByPage(TeamListVo teamListVo);

	Integer querySumOfTeam(TeamListVo teamListVo);

	TComp findCompByTeamId(Integer id) throws Exception;
}
