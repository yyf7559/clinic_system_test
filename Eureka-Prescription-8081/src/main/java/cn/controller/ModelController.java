package cn.controller;

import cn.config.FeignDataApi;
import cn.response.Response;
import cn.response.ResponseEnum;
import cn.entity.PrescriptionAddPrice;
import cn.service.ModelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/getModel")
    @ApiOperation(value = "查询模板+详情信息", notes = "信息")
    public Object findModel(Integer typeId, String permissions, String number, Integer pageNum, Integer pageSize) {
        return feignDataApi.findModel(typeId, permissions, number, pageNum, pageSize);
    }


    @GetMapping("/addPrice")
    @ApiOperation(value = "新增附加费用", notes = "")
    public Response addPrice(PrescriptionAddPrice prescriptionAddPrice) {
        int n = modelService.addPrice(prescriptionAddPrice);
        if (n > 0) {
            return Response.success(n);
        }
        return Response.error("新增附加费用出错");
    }

    @GetMapping("uaatest")
    public Object uaatest() {
        return "come uaatest";
    }
}
