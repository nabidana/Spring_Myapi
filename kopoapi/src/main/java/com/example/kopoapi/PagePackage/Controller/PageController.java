package com.example.kopoapi.PagePackage.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.kopoapi.PagePackage.Domain.apiTableInfo;
import com.example.kopoapi.PagePackage.Service.apiTableInfoService;

@Controller
public class PageController {

    @Autowired
    private apiTableInfoService service;
    
    @RequestMapping(value = "/")
    public String mainPage(Model model, HttpServletRequest request) throws Exception{
        String pageNum = request.getParameter("pagenumber");
        if(pageNum == null || "".equals(pageNum)){
            pageNum = "1";
        }
        int pageNumbers = Integer.parseInt(pageNum);

        model.addAttribute("totalpage", (service.totalCount()/20));
        model.addAttribute("getPageList", service.getPageList(pageNumbers));
        return "index";
    }

    @RequestMapping(value = "/getpage")
    public String getPage(Model model, @RequestParam("idx")String idx) throws Exception{

        int idxnum = Integer.parseInt(idx);
        model.addAttribute("getpages", service.getDetailTable(idxnum));
        return "getPage";
    }
}
