package cn.controller;

import cn.response.Response;
import cn.response.ResponseEnum;
import cn.entity.Advice;
import cn.service.AdviceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/come/advice")
public class AdviceController {
    @Resource
    AdviceService adviceService;
    @GetMapping("/getAdvice")
    public Response getAdvice(){
        List<Advice> list = adviceService.findAdvice();
        if(list!=null){
            return new Response(ResponseEnum.SUCCESS).setResponseBody(list);
        }
        return new Response(ResponseEnum.ERROR).setResponseBody("查询医嘱出错啦!");
    }
}
