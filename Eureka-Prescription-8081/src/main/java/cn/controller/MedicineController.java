package cn.controller;

import cn.http.HttpClientHelper;
import cn.response.Response;
import cn.config.FeignMedicineApi;
import cn.excel.CreateExcel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Api(tags = "药品信息查询")
@RestController
@RequestMapping("/call/medicine")
public class MedicineController {
    @Resource
    FeignMedicineApi feignMedicineApi;
    String medicine = "http://localhost:8084/come/medicine/";

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

/*    @GetMapping("/report")
    public void report(HttpServletResponse response) {
        CreateExcel report = new CreateExcel();
        List<String> headList = Arrays.asList("序号","单号","药品名称","数量","采购成本");
        List<List<String>> dataList = new ArrayList<>();
        Response response1=httpClientHelper.getForResponse(medicine+"findMedicineByPid");
        for (int i = 0; i < 10; i++) {
            dataList.add(Arrays.asList("" + i,"1000" + i,"药品" + i,"" +i, "2.55"));
        }
        report.createWorkBook(null, "a", headList, dataList, response, "报表测试.xls");
    }*/
    @GetMapping("/updateMedicineStock")
    public Response updateMedicineStock(@RequestParam(value = "id",required = false) int id,
                                        @RequestParam(value = "stock",required = false) int stock){
        System.out.println("id="+id);
        return feignMedicineApi.updateMedicineStock(id,stock);
    }
}
