package com.cxk.controller;

import com.cxk.po.TComp;
import com.cxk.service.CompService;
import com.cxk.vo.CompListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CompController {
    @Autowired
    private CompService compService;

    @RequestMapping("/complist")
    public String findAllComp(CompListVo compListVo, Model model) throws Exception {
        compService.findCompByPage(compListVo);
        model.addAttribute("compList", compListVo);
        return "compList";
    }
}
