package cn.controller;

import cn.response.Response;
import cn.response.ResponseEnum;
import cn.entity.Medicine;
import cn.entity.MedicineType;
import cn.excel.CreateExcel;
import cn.service.MedicineService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@RestController
@RequestMapping("/come/medicine")
public class MedicineController {
    @Resource
    MedicineService medicineService;
    @GetMapping("/docker")
    public String findMedicineType2(Integer pid,String name){
     return name+"dockerMedicine yes"+pid;
    }
    @GetMapping("/findMedicineType")
    public Response findMedicineType(@RequestParam(value = "pid",required = false)Integer pid){
        List<MedicineType> list = medicineService.findMedicineType(pid);
        if(list!=null){
            return new Response(ResponseEnum.SUCCESS).setResponseBody(list);
        }
        return new Response(ResponseEnum.ERROR).setResponseBody("查询数据出错啦！");
    }
    @GetMapping("/findMedicine")
    public Response findMedicine(@RequestParam(value = "typeId",required = false)Integer typeId,
                                 @RequestParam(value = "code",required = false)String code,
                                 @RequestParam(value = "page",defaultValue = "1")Integer page,
                                 @RequestParam(value = "limit",defaultValue = "3")Integer limit) {
        PageHelper.startPage(page,limit);
        List<Medicine> list = medicineService.findMedicine(typeId,code,page,limit);
        Map<String,Object> map=new HashMap<>();
        PageInfo<Medicine> pageInfo=null;
            pageInfo = new PageInfo<>(list);
            map.put("data",pageInfo.getList());
            map.put("code","0");
            map.put("count",pageInfo.getTotal());

            return new Response(ResponseEnum.SUCCESS).setResponseBody(map);
    }
    @GetMapping("/findMedicineByPid")
    public Response findMedicineByPid(@RequestParam(value = "pid",required = false)Integer pid,
                                      @RequestParam(value = "pageNo",defaultValue = "1")Integer pageNo,
                                      @RequestParam(value = "pageSize",defaultValue = "3")Integer pageSize){
        PageHelper.startPage(pageNo,pageSize);
        List<Medicine> list = medicineService.findMedicineByPid(pid);
        Map<String,Object> map=new HashMap<>();
        PageInfo<Medicine> pageInfo = new PageInfo<>(list);
            map.put("data",pageInfo);
            map.put("code","0");
            map.put("count",pageInfo.getTotal());
            return new Response(ResponseEnum.SUCCESS).setResponseBody(map);
    }
    @GetMapping("/report")
    public void report(HttpServletResponse response) {
        List<Medicine> list = medicineService.findMedicine(null,null,null,null);
        CreateExcel report = new CreateExcel();
        List<String> headList = Arrays.asList("序号","单号","药品名称","数量","采购成本");
        List<List<String>> dataList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            dataList.add(Arrays.asList("" + i,"1000" + i,list.get(i).getMedicineName(),"" +list.get(i).getStock(), list.get(i).getPrice()+""));
        }
        report.createWorkBook(null, "a", headList, dataList, response, "报表测试.xls");
    }
    @GetMapping("/updateMedicineStock")
    public Response updateMedicineStock(@RequestParam(value = "id",required = false) int id,
                                        @RequestParam(value = "stock",required = false) int stock){
        System.out.println("id="+id);
        System.out.println("stock="+stock);
        medicineService.updateMedicine(id,stock);
        return new Response(ResponseEnum.SUCCESS);
    }

}
