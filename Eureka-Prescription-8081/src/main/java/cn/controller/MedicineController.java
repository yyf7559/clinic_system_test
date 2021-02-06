package cn.controller;

import cn.response.Response;
import cn.config.FeignMedicineApi;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api(tags = "药品信息查询")
@RestController
@RequestMapping("/call/medicine")
public class MedicineController {
    @Resource
    FeignMedicineApi feignMedicineApi;

    @GetMapping("/findMedicineByPid")
    @ApiOperation(value = "根据处方ID查询药品",notes = "")
    public Object findMedicineByPid(@RequestParam(value = "pid",required = false)Integer pid,
                                    @RequestParam(value = "pageNo",defaultValue = "1")Integer pageNo,
                                    @RequestParam(value = "pageSize",defaultValue = "3")Integer pageSize) {
        System.out.println("pid="+pid+"pageNo="+pageNo+"pageSize="+pageSize);
        return feignMedicineApi.findMedicineByPid(pid,pageNo,pageSize);
    }

    @GetMapping("/findMedicine")
    @ApiOperation(value = "根据typeID和名称或者拼音查询药品信息",notes = "")
    public Object findMedicine(@RequestParam(value = "typeId",required = false)Integer typeId,
                               @RequestParam(value = "code",required = false)String code,
                               @RequestParam(value = "page",defaultValue = "1")Integer page,
                               @RequestParam(value = "limit",defaultValue = "3")Integer limit){
        if("".equals(code)){
            code=null;
        }
        return feignMedicineApi.findMedicine(typeId,code,page,limit).getResponseBody();
    }

    @GetMapping("/findMedicineType")
    @ApiOperation(value = "查询药品分类",notes = "")
    public Object findMedicineType(@RequestParam(value = "pid",required = false)Integer pid){
        return feignMedicineApi.findMedicineType(pid);
    }

    @GetMapping("/updateMedicineStock")
    public Response updateMedicineStock(@RequestParam(value = "id",required = false) int id,
                                        @RequestParam(value = "stock",required = false) int stock){
        System.out.println("id="+id);
        return feignMedicineApi.updateMedicineStock(id,stock);
    }
}
