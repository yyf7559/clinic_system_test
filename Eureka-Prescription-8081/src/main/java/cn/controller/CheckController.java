package cn.controller;

import cn.config.FeignMedicineApi;
import cn.http.HttpClientHelper;
import cn.response.Response;
import cn.response.ResponseEnum;
import cn.entity.PrescriptionCheck;
import cn.service.CheckService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Api(tags = "检查项目测试接口")
@RequestMapping("/call/check")
public class CheckController {
    @Autowired
    FeignMedicineApi feignMedicineApi;
    @Resource
    CheckService checkService;
    String checkUrl="http://localhost:8084/come/check/";
    @GetMapping("/findCheck")
    @ApiOperation(value = "查询所有检查项目",notes = "")
    public Response findCheck(){
        return feignMedicineApi.findCheck();
    }
    @GetMapping("/findCheckType")
    @ApiOperation(value = "查询检查项目的类型",notes = "")
    public Response findCheckType(){
        return feignMedicineApi.findCheckType();
    }
    @GetMapping("/findCheckByTypeId")
    @ApiOperation(value = "根据typeID和名称或者拼音查询检查项目",notes = "")
    public Object findCheckByTypeId(@RequestParam(value = "checkTypeId",required = false)Integer checkTypeId,
                                    @RequestParam(value = "checkCode",required = false)String checkCode,
                                    @RequestParam(value = "page",defaultValue = "1")Integer page,
                                    @RequestParam(value = "limit",defaultValue = "3")Integer limit){
        if("".equals(checkCode))checkCode=null;
        return feignMedicineApi.findCheckByTypeId(checkTypeId, checkCode, page, limit).getResponseBody();

    }
    @GetMapping("/addPreCheck")
    @ApiOperation(value = "新增处方检查项目",notes = "")
    public Response addPreCheck(PrescriptionCheck prescriptionCheck) {
        int n = checkService.addPreCheck(prescriptionCheck);
        if(n>0){
            return new Response(ResponseEnum.SUCCESS).setResponseBody(n);
        }
        return new Response(ResponseEnum.ERROR).setResponseBody("新增处方检查项目出错啦");
    }
}
