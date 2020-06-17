package cn.controller;

import cn.response.Response;
import cn.response.ResponseEnum;
import cn.entity.Disease;
import cn.service.DiseaseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/come/disease")
public class DiseaseController {
    @Resource
    DiseaseService diseaseService;

    @GetMapping("/getDisease")
    public Response getDisease(){
        List<Disease> list = diseaseService.findDisease();
        if(list!=null){
            return new Response(ResponseEnum.SUCCESS).setResponseBody(list);
        }
        return new Response(ResponseEnum.ERROR).setResponseBody("查询疾病出错啦!");
    }
}
