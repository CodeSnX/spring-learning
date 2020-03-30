package com.soft1851.spring.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.soft1851.spring.web.service.RankService;
import com.soft1851.spring.web.service.TopicService;
import com.soft1851.spring.web.util.ResponseObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping(value = "/rank")
public class RankController {
    @Resource
    private RankService rankService;

    @GetMapping(value = "",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getTopics(){
        ResponseObject rs = new ResponseObject(1,"success",rankService.queryAll());
        return JSONObject.toJSONString(rs);
    }

    @GetMapping("/")
    public String topic(Model model){
        model.addAttribute("ranks", rankService.queryAll());
        return "templates/rank";
    }
}
