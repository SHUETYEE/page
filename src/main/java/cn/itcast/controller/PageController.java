package cn.itcast.controller;

import cn.itcast.model.Inve;
import cn.itcast.service.InveService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author lijingyu
 * @date 2019/9/14 13:54
 */
@Controller
@RequestMapping("/pages")
public class PageController {

    @Autowired
    private InveService inveService;

    @RequestMapping("/page")
    public String page(@RequestParam(value = "pn",defaultValue = "1") Integer pn, Model model){
        PageHelper.startPage(pn,5);
        List<Inve> inves = inveService.findAll();
        PageInfo pageInfo = new PageInfo(inves,5);
        model.addAttribute("pageInfo",pageInfo);
        return "list";
    }
}
