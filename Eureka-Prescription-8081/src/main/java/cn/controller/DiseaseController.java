package cn.controller;

import cn.config.FeignDataApi;
import cn.http.HttpClientHelper;
import cn.response.Response;
import cn.response.ResponseEnum;
import cn.entity.PrescriptionDisease;
import cn.service.DiseaseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/call/disease")
@Api(tags = "疾病测试接口")
@RefreshScope
public class DiseaseController {
    @Value("${server.test}")
    private String test;
    @GetMapping("/test")
    public String test(){
        return "配置文件自动更新数据为："+test;
    }
    @Resource
    FeignDataApi feignDataApi;
    @Resource
    DiseaseService diseaseService;
    String diseaseUrl="http://localhost:8083/come/disease/";
    @GetMapping("/addDisease")
    @ApiOperation(value = "新增疾病处方表",notes = "")
    public Response addDisease(PrescriptionDisease prescriptionDisease){
        System.out.println(prescriptionDisease.getPrescriptionId()+","+prescriptionDisease.getDiseaseId());
        int n=diseaseService.addDisease(prescriptionDisease);
        if(n>0){
            return new Response(ResponseEnum.SUCCESS).setResponseBody(n);
        }
        return new Response(ResponseEnum.ERROR).setResponseBody("添加疾病处方出错啦!");
    }
    @GetMapping("/getDisease")
    @ApiOperation(value = "查询所有疾病",notes = "")
    public Response findDisease(){
        return feignDataApi.getDisease();
    }

}
