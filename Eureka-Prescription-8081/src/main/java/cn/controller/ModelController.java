package cn.controller;

import cn.config.FeignDataApi;
import cn.http.HttpClientHelper;
import cn.response.Response;
import cn.response.ResponseEnum;
import cn.entity.PrescriptionAddPrice;
import cn.service.ModelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api(tags = "模板信息查询")
@RestController
@RequestMapping("/call/model")
public class ModelController {
    @Resource
    FeignDataApi feignDataApi;
    @Resource
    ModelService modelService;
    private static final String CURRENT_SERVER_URL = "http://localhost:8082";
    String modelUrl="http://localhost:8083/come/";
    @GetMapping("/getModel")
    @ApiOperation(value = "查询模板+详情信息",notes = "信息")
    public Object findModel(Integer typeId,String permissions,String number,Integer pageNum,Integer pageSize){
/*        StringBuffer sb = new StringBuffer(modelUrl+"getModel?");
        sb.append("permissions="+permissions+"&number"+number);
        if(typeId!=null){
            sb.append("&typeId="+typeId);
        }
        if(pageNum!=null){
            sb.append("&pageNum="+pageNum);
        }
        if(pageSize!=null){
            sb.append("&pageSize="+pageSize);
        }*/
        return feignDataApi.findModel(typeId, permissions, number, pageNum, pageSize);
    }


    @GetMapping("/addPrice")
    @ApiOperation(value = "新增附加费用",notes = "")
    public Response addPrice(PrescriptionAddPrice prescriptionAddPrice){
            int n = modelService.addPrice(prescriptionAddPrice);
            if(n>0){
                return new Response(ResponseEnum.SUCCESS).setResponseBody(n);
            }
        return new Response(ResponseEnum.ERROR).setResponseBody("新增附加费用出错");
    }
    @GetMapping("uaatest")
    public Object uaatest(){
        return "come uaatest";
    }
}
