package cn.controller;

import cn.response.Response;
import cn.response.ResponseEnum;
import cn.entity.AddPrice;
import cn.entity.PrescriptionModel;
import cn.entity.PrescriptionType;
import cn.service.ModelService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/come")
public class ModelController {
    @Resource
    ModelService modelService;
    @GetMapping("/getModel")
    public Response findModel( @RequestParam(value = "typeId",required = false) Integer typeId,
                               @RequestParam(value = "permissions",required = false)String permissions,
                               @RequestParam(value = "number",required = false)String number,
                               @RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum,
                               @RequestParam(value = "pageSize",defaultValue = "3")Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<PrescriptionModel> list = modelService.findModel(typeId,permissions,number,pageNum,pageSize);
        PageInfo<PrescriptionModel> pageInfo=null;
            pageInfo = new PageInfo<>(list);
            return new Response(ResponseEnum.SUCCESS).setResponseBody(pageInfo);
    }
    @GetMapping("/findAddPrice")
    public Response findAddPrice(){
        List<AddPrice> list= modelService.findAddPrice();
        if(list!=null){
            return new Response(ResponseEnum.SUCCESS).setResponseBody(list);
        }
        return new Response(ResponseEnum.ERROR).setResponseBody("查询附加费用出错啦!");
    }
    @GetMapping("/findPrescriptionType")
    public Response findPrescriptionType(){
        List<PrescriptionType> list= modelService.findPrescriptionType();
        if(list!=null){
            return new Response(ResponseEnum.SUCCESS).setResponseBody(list);
        }
        return new Response(ResponseEnum.ERROR).setResponseBody("查询处方类型出错啦!");
    }
}

